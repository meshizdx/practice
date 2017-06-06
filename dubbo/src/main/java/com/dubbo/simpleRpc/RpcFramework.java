package com.dubbo.simpleRpc;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 博学之，审问之，慎思之，明辨之，笃行之。
 * 人一能之，己百之；人十能之，己千之。
 * 果能此道矣，虽愚必明，虽柔必强。
 *
 * @Description:
 * @create by shaott at 2017-06-02 16:08
 **/
public class RpcFramework {

    /**
     * 暴露服务
     *
     * @param service 服务实现
     * @param port 服务端口
     * @throws Exception
     */
    public static void export(final Object service,int port) throws Exception{
        if(service == null){
            throw new IllegalArgumentException("service instance == null");
        }
        if(port <=0 || port > 65535){
            throw new IllegalArgumentException("Invalid port " + port);
        }
        System.out.println("export service " + service.getClass().getName()+"on port "+port);

        ServerSocket serverSocket = new ServerSocket(port);

        for(;;){
            try {
                final Socket socket = serverSocket.accept();
                new Thread(new Runnable() {
                    ObjectOutputStream output = null;
                    ObjectInputStream input = null;
                    @Override
                    public void run() {
                        try{
                            input = new ObjectInputStream(socket.getInputStream());
                            String methodName = input.readUTF();
                            Class<?>[] parameterTypes = (Class<?>[])input.readObject();
                            Object[] arguments = (Object[])input.readObject();
                            output = new ObjectOutputStream(socket.getOutputStream());
                            Method method = service.getClass().getMethod(methodName,parameterTypes);
                            Object result = method.invoke(service,arguments);
                            output.writeObject(result);
                        }catch (Exception e){
                            e.printStackTrace();
                        }finally {
                            try {
                                input.close();
                                output.close();
                                socket.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }

                    }
                }).start();


            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    /**
     * 引用服务
     *
     * @param <T> 接口泛型
     * @param interfaceClass 接口类型
     * @param host 服务器主机名
     * @param port 服务器端口
     * @return 远程服务
     * @throws Exception
     */
    public static <T> T  refer(final Class<T> interfaceClass,final String host,final int port) throws Exception{
        if(interfaceClass == null){
            throw new IllegalArgumentException("Interface class == null");
        }
        if(!interfaceClass.isInterface()){
            throw new IllegalArgumentException("the "+interfaceClass.getName()+"must be interface class!");
        }
        if(host == null || host.length() == 0){
            throw new IllegalArgumentException("Host == null!");
        }
        if(port <=0 || port > 65535){
            throw new IllegalArgumentException("Invalid port " + port);
        }
        System.out.println("Get remote service " + interfaceClass.getName() + " from server " + host + ":" + port);
        return (T) Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class<?>[]{interfaceClass}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                Socket socket = new Socket(host, port);
                ObjectOutputStream outPut = null;
                ObjectInputStream input = null;
                try {
                    outPut = new ObjectOutputStream(socket.getOutputStream());
                    outPut.writeUTF(method.getName());
                    outPut.writeObject(method.getParameterTypes());
                    outPut.writeObject(args);
                    input = new ObjectInputStream(socket.getInputStream());
                    Object result = input.readObject();
                    if(result instanceof Throwable){
                        throw (Throwable)result;
                    }
                    return result;
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    input.close();
                    outPut.close();
                    socket.close();
                }

                return null;
            }
        });
    }

}

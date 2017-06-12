package com.dubbo.event_notify.api;

/**
 * 博学之，审问之，慎思之，明辨之，笃行之。
 * 人一能之，己百之；人十能之，己千之。
 * 果能此道矣，虽愚必明，虽柔必强。
 * <p>
 * Description:
 * Created by Admin on 2017/6/11.
 */
public interface INotify {

    public void oninvoke(Object args);

    public void onreturn(Object res,Object... args);

    public void onthrow(Throwable ex,Object... args);
}

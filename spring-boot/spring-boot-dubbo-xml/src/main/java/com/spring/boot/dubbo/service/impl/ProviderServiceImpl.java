package com.spring.boot.dubbo.service.impl;

import com.spring.boot.dubbo.service.IProviderService;
import org.springframework.stereotype.Service;

/**
 * Created by BF100177 on 2017/6/1.
 */
@Service
public class ProviderServiceImpl implements IProviderService{
    @Override
    public String testProvider() {
        return "this is a provider";
    }
}

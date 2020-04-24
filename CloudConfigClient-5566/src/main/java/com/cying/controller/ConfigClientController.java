package com.cying.controller;

import com.cying.entities.ConfigResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigClientController {

    @Value("${server.port}")
    private String port;

    @Value("${config.info}")
    private String configInfo;

    @GetMapping(value = "/config")
    public ConfigResult getConfigInfo() {
        return new ConfigResult(port, configInfo);
    }

}
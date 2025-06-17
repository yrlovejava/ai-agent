package com.xiaobai.aiagent.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
public class HealthController {

    /**
     * 检查服务健康状态
     * @return 返回"OK"表示服务正常
     */
    @RequestMapping("/check")
    public String checkHealth() {
        return "OK";
    }
}

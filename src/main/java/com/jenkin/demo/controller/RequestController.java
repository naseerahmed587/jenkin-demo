package com.jenkin.demo.controller;

import com.jenkin.demo.service.JenkinService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jenkin")
public class RequestController {
    private JenkinService jenkinService;

    public RequestController(JenkinService jenkinService) {
        this.jenkinService = jenkinService;
    }

    @PostMapping("test")
    public Object saveCampaignBusinessRule() {
        return jenkinService.donothing();
    }

}

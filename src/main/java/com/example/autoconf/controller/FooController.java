package com.example.autoconf.controller;

import com.example.autoconf.service.AplicationContextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/app")
public class FooController {
    @Autowired
    private AplicationContextService aplicationContextService;

//beans/all -> all beans from context
//beans/controller -> all beans from domain/controller
//beans/service -> all beans from domain/service

    @GetMapping(value = "/beans/all" ,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Map<String,String>> path(@RequestParam String name) {
        return new ResponseEntity<>(aplicationContextService.getBeans(name), HttpStatus.OK);
    }
}
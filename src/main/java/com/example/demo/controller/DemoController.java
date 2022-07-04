package com.example.demo.controller;

import com.example.demo.model.DataHolder;
import com.example.demo.model.Response;
import com.example.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class DemoController {

        @Autowired
        private DemoService demoService;

        @GetMapping("/get")
        public ResponseEntity<Response> getData(@RequestBody DataHolder dataHolder) {

            return ResponseEntity.status(HttpStatus.OK).body(demoService.submit(dataHolder));
        }
}

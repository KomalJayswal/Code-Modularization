package net.learning.demo.controller;

import net.learning.demo.model.DataHolder;
import net.learning.demo.model.Response;
import net.learning.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class DemoController {

        @Autowired
        private DemoService demoService;

        @PostMapping()
        public ResponseEntity<DataHolder> getData(@RequestBody DataHolder dataHolder) {

            return ResponseEntity.status(HttpStatus.OK).body(demoService.submit(dataHolder));
        }
}

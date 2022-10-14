package net.learning.demo.controller;

import net.learning.demo.model.DataHolder;
import net.learning.demo.model.OhmErrors;
import net.learning.demo.model.Response;
import net.learning.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hello")
public class DemoController {

        @Autowired
        private DemoService demoService;

        @GetMapping("/get")
        public ResponseEntity<List<OhmErrors>> getData(@RequestBody DataHolder dataHolder) {

            return ResponseEntity.status(HttpStatus.OK).body(demoService.submit(dataHolder));
        }
}

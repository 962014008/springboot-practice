package cn.stackbox.demo.controller;

import cn.stackbox.demo.annotation.TestAnnotation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aop")
public class AopController {


    @TestAnnotation(name = "no")
    @RequestMapping("/testAop1")
    public ResponseEntity testAop1() {

        System.out.println("testAop1");
        return ResponseEntity.ok("ok");
    }


    @TestAnnotation(name = "yes")
    @RequestMapping("/testAop2")
    public ResponseEntity testAop2() {

        System.out.println("testAop2");
        return ResponseEntity.ok("ok");
    }
}

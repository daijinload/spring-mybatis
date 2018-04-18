/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.project.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class GreetingController {

    @RequestMapping("/greeting")
    public @ResponseBody String greeting() {
//        // mybatisのテストを動かすためのサンプル
//        https://github.com/mybatis/spring
//
//        // やりたいのはこれな気がするが。。
//        https://www.luckyryan.com/2013/08/24/unit-test-controllers-spring-mvc-test/

        return "hello";
    }

}
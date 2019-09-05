/**
 * FileName:   HelloController
 * Author:     O了吗
 * Date:       2019/9/2 23:08
 * Description:
 * History:
 * author:     oleolema
 */
package com.nobug.qingxinjiajiao.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 〈〉
 *
 * @author O了吗
 * @create 2019/9/2
 * @since 1.0.0
 */
@Slf4j
@Controller
@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "hello world!!";
    }



}
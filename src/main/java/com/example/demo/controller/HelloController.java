package com.example.demo.controller;

import com.example.demo.utils.MailUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * 类的简介:
 * 类的描述:
 * 开发日期 2023/2/22 15:00.
 *
 * @author Mchen （开发人）.
 * @since 1.8 （JDK版本号）.
 */
@RestController
public class HelloController {
    @Autowired
    private MailUtils mailUtils;
    //

    //5分钟执行一次。
    @Scheduled(cron = "0 0/5 * * * ?")
    @GetMapping("/email")
    public void sendEmail() {
        // mailto 发送给谁？
        String mailto ="972831099@qq.com";
        //  定制邮件内容
        StringBuffer content = new StringBuffer();
        content.append("心态还需努力呀~").append("\n");
        String text = "";
        //三个参数、1.接收者  2.邮件标题  3.发送的内容
        mailUtils.sendSimpleEmail(mailto, String.valueOf(content), text);
    }
}

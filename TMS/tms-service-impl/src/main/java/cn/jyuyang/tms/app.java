package cn.jyuyang.tms;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class app {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("spring*.xml");
        classPathXmlApplicationContext.start();
        System.out.println("-------服务启动-------------");
        System.in.read();
    }
}

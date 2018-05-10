package cn.jyuyang.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("listener==============================");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}

package cn.jyuyang.config;

import cn.jyuyang.web.filter.MyFilter;
import cn.jyuyang.web.interceport.MyInterceport;
import cn.jyuyang.web.listener.MyListener;
import org.omg.PortableInterceptor.Interceptor;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

import javax.servlet.FilterRegistration;

@Configuration
public class WebConfig extends WebMvcAutoConfiguration {
    /**
     * 添加拦截器
     * @param registry
     */
//    public void addInterceport(InterceptorRegistry registry){
//        registry.addInterceptor(new MyInterceport()).addPathPatterns("/*");
//
//    }

    /**
     * 添加过滤器
     * @return
     */
  /*  public FilterRegistrationBean addFilter(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new MyFilter());

        filterRegistrationBean.addUrlPatterns("/*");
        return  filterRegistrationBean;
    }*/

 /*   public ServletListenerRegistrationBean listenerRegistrationBean(){
        ServletListenerRegistrationBean servletListenerRegistrationBean = new ServletListenerRegistrationBean();
        servletListenerRegistrationBean.setListener(new MyListener());
        return servletListenerRegistrationBean;
    }*/
}

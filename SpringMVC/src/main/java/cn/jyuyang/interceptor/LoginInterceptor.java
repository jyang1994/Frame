package cn.jyuyang.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String url = request.getRequestURI();
        if(url.startsWith("/static")||url.equals("/favicon.ico")){
            return true;
        }
        if("".equals(url)||"/".equals(url)){
            return true;
        }
     /*   HttpSession session = request.getSession();
        if(session.getAttribute("name")==null){
            response.sendRedirect("/");
        }*/
        return true;
    }
}

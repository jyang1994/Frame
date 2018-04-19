package cn.jyuyang.tms.controller.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdviceException {


    @ExceptionHandler(org.apache.shiro.authz.UnauthorizedException.class)
    public String unauthorizedHandler() {
        return "error/401";

    }
}

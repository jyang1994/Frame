package cn.jyuyang.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/movie")
@CrossOrigin("*")
public class MovieController {
    @GetMapping
    public Map<String,String> home(){
        Map<String,String> maps = new HashMap<>();
        maps.put("name","lisi");
        maps.put("age","23");
        return maps;
    }
}
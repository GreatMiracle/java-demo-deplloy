package com.example.j6storeit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {


    @RequestMapping({"/","/home/index"})
    public String home(){
        return "redirect:/product/list";
    }
    @RequestMapping({"/admin","/admin/home/index"})
    public String admin(){
        return "redirect:/assets/admin/index.html";
    }

}

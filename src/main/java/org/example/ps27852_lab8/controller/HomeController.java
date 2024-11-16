package org.example.ps27852_lab8.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping({"/","/home/index"})
    public String home(){
        return "redirect:/products/list";
    }

    @RequestMapping({"/admin","/admin/home/index"})
    public String admin(){
        return "redirect:/assets/admin/index.html";
    }

}

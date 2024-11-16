package org.example.ps27852_lab8.config;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class GeneralAdvice {
    @ModelAttribute
    public void getRequest(Model model, HttpServletRequest req, Authentication auth) {
        model.addAttribute("request",req);
    }
}

package com.example.top;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 */
@Controller
public class LoginController {

    @RequestMapping(value="top", method = RequestMethod.GET)
    public String top(Model model){

        LoginForm loginForm = new LoginForm();
        model.addAttribute("loginForm", loginForm);

        return "top/top";
    }
}

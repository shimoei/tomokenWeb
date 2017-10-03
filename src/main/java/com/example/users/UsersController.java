package com.example.users;

import com.example.security.LoginUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



/**
 * ユーザ管理画面。ログイン後に表示させる。
 */
@Controller
@RequestMapping(value="users/")
public class UsersController {

    @Autowired
    UsersService usersService;

    @RequestMapping(value="top", method = RequestMethod.GET)
    public String top(Model model){

        return "users/top";
    }

    @RequestMapping(value="another", method = RequestMethod.GET)
    public String another(Model model){

        return "users/another";
    }

}

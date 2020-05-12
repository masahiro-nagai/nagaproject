package com.example.myproject.top;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.myproject.constants.Constants;
import com.example.myproject.login.LoginForm;

@Controller
@RequestMapping(value = "/loginUser")
public class LoginUserController {

    @Autowired
    private HttpSession session;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String init(Model model) {

        LoginForm form = (LoginForm) session.getAttribute("form");

        model.addAttribute("session", form.getUid());
        model.addAttribute("message", "before user");
        return Constants.PAGE_INDEX;
    }

    @RequestMapping(params = "back", method = RequestMethod.POST)
    public String back(Model model) {
        // message に文字を代入
        model.addAttribute("message", "before user");
        return Constants.PAGE_INDEX;
    }
}

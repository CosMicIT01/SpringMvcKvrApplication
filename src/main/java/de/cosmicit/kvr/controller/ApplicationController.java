package de.cosmicit.kvr.controller;

import de.cosmicit.kvr.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class ApplicationController {


    @Autowired
    MessageSource messageSource;


    @RequestMapping(value = {"/", "/list"}, method = RequestMethod.GET)
    public String listUsers(ModelMap model) {

        List<User> users = new ArrayList<>();
        model.addAttribute("users", users);
        return "userslist";
    }

}

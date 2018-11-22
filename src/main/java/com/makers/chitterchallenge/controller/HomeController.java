package com.makers.chitterchallenge.controller;

import com.makers.chitterchallenge.model.Chitter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("/api")
public class HomeController {

    @RequestMapping(value = "/")
    public String index() {
        return "index";
    }


}
package com.realaicy.tna.demos.webshowcase.demo.sa;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

/**
 * Created by realaicy on 16/3/11.
 */
@Controller
@RequestMapping("/sa")
public class SAIndexController {
    /**
     * Index string.
     *
     * @param model the model
     * @return the string
     */
    @RequestMapping("/dashboard")
    public String dashboard(Model model) {

        return "sa/ajax/dashboard";
    }

    /**
     * Index string.
     *
     * @param model the model
     * @return the string
     */
    @RequestMapping("/")
    public String index(Model model) {

        return "sa/index";
    }
}

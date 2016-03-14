package com.realaicy.tna.demos.webshowcase.modules.company.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by realaicy on 2016/3/14.
 */
@Controller
@RequestMapping("/sa/company")
public class DemoSACompanyController {
    /**
     * Greeting string.
     *
     * @param name  the name
     * @param model the model
     * @return the string
     */
    @RequestMapping("/baseinfo")
    public String greeting(@RequestParam(value = "name", required = false, defaultValue = "World")
                           String name, Model model) {
        model.addAttribute("name", name);
        return "sa/realaicy/company/baseinfo";
    }
    @RequestMapping("/xukezhengview")
    public String xukezheng(@RequestParam(value = "name", required = false, defaultValue = "World")
                           String name, Model model) {
        model.addAttribute("name", name);
        return "sa/realaicy/company/xkz";
    }
}

package com.realaicy.tna.demos.webshowcase.modules.drug.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by realaicy on 2016/3/14.
 */
@Controller
@RequestMapping("/sa/drug")
public class DemoSADrugController {
    /**
     * Greeting string.
     *
     * @param name  the name
     * @param model the model
     * @return the string
     */
    @RequestMapping("/cpinfo")
    public String cpinfo(@RequestParam(value = "name", required = false, defaultValue = "World")
                           String name, Model model) {
        model.addAttribute("name", name);
        return "sa/realaicy/drug/cp";
    }
}

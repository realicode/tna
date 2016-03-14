package com.realaicy.tna.demos.webshowcase.modules.system.myfav.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * The type Demo controller.
 */
@Controller
@RequestMapping("/myfav")
public class MyFavController {


    /**
     * Greeting string.
     *
     * @param name  the name
     * @param model the model
     * @return the string
     */
    @RequestMapping("/baseui")
    public String greeting(@RequestParam(value = "name", required = false, defaultValue = "World")
                           String name, Model model) {
        model.addAttribute("name", name);
        return "demo/baseui";
    }

    /**
     * Greeting string.
     *
     * @param name  the name
     * @param model the model
     * @return the string
     */
    @RequestMapping("/elements")
    public String showElements(@RequestParam(value = "name", required = false, defaultValue = "World")
                               String name, Model model) {
        model.addAttribute("name", name);
        return "demo/elements";
    }

    /**
     * Greeting string.
     *
     * @param name  the name
     * @param model the model
     * @return the string
     */
    @RequestMapping("/tables")
    public String showTables(@RequestParam(value = "name", required = false, defaultValue = "World")
                               String name, Model model) {
        model.addAttribute("name", name);
        return "demo/tables";
    }
    /**
     * Greeting string.
     *
     * @param name  the name
     * @param model the model
     * @return the string
     */
    @RequestMapping("/jqgrid")
    public String showTables2(@RequestParam(value = "name", required = false, defaultValue = "World")
                             String name, Model model) {
        model.addAttribute("name", name);
        return "demo/jqgrid";
    }

}

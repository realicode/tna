package com.realaicy.tna.demos.webshowcase.demo.sa;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * The type Demo controller.
 */
@Controller
@RequestMapping("/sa/demopage")
public class DemoPageController {


    /**
     * Greeting string.
     *
     * @param name  the name
     * @param model the model
     * @return the string
     */
    @RequestMapping("/login")
    public String greeting(@RequestParam(value = "name", required = false, defaultValue = "World")
                           String name, Model model) {
        model.addAttribute("name", name);
        return "sa/realaicy/demopage/login";
    }

    @RequestMapping("/timeline")
    public String timeline(@RequestParam(value = "name", required = false, defaultValue = "World")
                           String name, Model model) {
        model.addAttribute("name", name);
        return "sa/realaicy/demopage/timeline";
    }
    @RequestMapping("/ca")
    public String ca(@RequestParam(value = "name", required = false, defaultValue = "World")
                           String name, Model model) {
        model.addAttribute("name", name);
        return "sa/realaicy/demopage/calendar";
    }
    @RequestMapping("/checklist")
    public String checkList(@RequestParam(value = "name", required = false, defaultValue = "World")
                     String name, Model model) {
        model.addAttribute("name", name);
        return "sa/realaicy/demopage/checklist";
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

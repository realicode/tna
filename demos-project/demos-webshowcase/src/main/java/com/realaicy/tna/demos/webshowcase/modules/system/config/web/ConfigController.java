package com.realaicy.tna.demos.webshowcase.modules.system.config.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * The type Menu controller.
 */
@Controller
@RequestMapping("/sysm/config")
public class ConfigController {


    /**
     * Greeting string.
     *
     * @param name  the name
     * @param model the model
     * @return the string
     */
    @RequestMapping("/show")
    public String showMenus(@RequestParam(value = "name", required = false, defaultValue = "World")
                            String name, Model model) {
        model.addAttribute("name", name);
        return "sysm/menu/menu";
    }


}

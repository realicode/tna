package com.realaicy.tna.demos.webshowcase.demo;

import com.realaicy.tna.demos.webshowcase.modules.system.menu.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

/**
 * The  Index controller.
 */
@Controller
public class IndexController {

    /**
     * The Menu service.
     */
    @Autowired
    private MenuService menuService;

    /**
     * Index string.
     *
     * @param model the model
     * @return the string
     */
    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("realversion", new Date());
        model.addAttribute("realmenus", menuService.getTopMenus());
        return "index";
    }

    /**
     * Readme string.
     *
     * @param model the model
     * @return the string
     */
    @RequestMapping("index/readme")
    public String readme(Model model) {
        model.addAttribute("realversion", new Date());
        return "readme";
    }

}

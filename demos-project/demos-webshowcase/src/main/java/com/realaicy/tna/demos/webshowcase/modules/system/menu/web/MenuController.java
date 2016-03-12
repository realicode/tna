package com.realaicy.tna.demos.webshowcase.modules.system.menu.web;

import com.realaicy.tna.demos.webshowcase.modules.system.menu.model.Menu;
import com.realaicy.tna.demos.webshowcase.modules.system.menu.service.MenuService;
import com.realaicy.tna.modules.core.mapper.JsonMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * The type Menu controller.
 */
@Controller
@RequestMapping("/sysm/menu")
public class MenuController {

    /**
     * The Menu service.
     */
    @Autowired
    private MenuService menuService;
    /**
     * The Menu service.
     */
    private static JsonMapper mapper = JsonMapper.nonDefaultMapper();


    /**
     * {@inheritDoc}
     */
    private Logger logger = LoggerFactory.getLogger(MenuController.class);

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

    /**
     * Greeting string.
     *
     * @param name  the name
     * @param model the model
     * @return the string
     */
    @RequestMapping(value = "/api/menus", produces = "application/json")
    @ResponseBody
    public List<Menu> ajaxgetMenus(@RequestParam(value = "name", required = false, defaultValue = "World")
                                   String name, Model model) {
        return null;
    }

    /**
     * Greeting string.
     *
     * @param name  the name
     * @param model the model
     * @return the string
     */
    @RequestMapping(value = "/api/menus2")
    @ResponseBody
    public String ajaxgetMenus2(@RequestParam(value = "name", required = false, defaultValue = "World")
                                String name, Model model) {

        List<Menu> menuList = menuService.getAllMenus();

        String listString = mapper.toJson(menuList);

        return listString;
    }


}

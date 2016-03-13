package com.realaicy.tna.demos.webshowcase.demo;

import com.realaicy.tna.demos.webshowcase.modules.system.resource.service.SysResourceService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
     * The Resource service.
     */
    @Autowired
    private SysResourceService sysResourceService;

    /**
     * Index string.
     *
     * @param model the model
     * @return the string
     */
    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("realversion", new Date());
       // model.addAttribute("realmenus", menuService.getTopMenus());
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        if(userDetails.getUsername().equals("admin"))
            model.addAttribute("realmenus", sysResourceService.findAllMenus());
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

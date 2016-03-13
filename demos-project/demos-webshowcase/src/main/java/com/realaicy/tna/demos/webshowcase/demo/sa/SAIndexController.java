package com.realaicy.tna.demos.webshowcase.demo.sa;

import com.realaicy.tna.demos.webshowcase.modules.system.resource.service.SysResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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

        model.addAttribute("realversion", new Date());
        // model.addAttribute("realmenus", menuService.getTopMenus());
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        if(userDetails.getUsername().equals("admin"))
            model.addAttribute("realmenus", sysResourceService.findAllMenus());

        return "sa/index";
    }
}

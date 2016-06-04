package com.realaicy.tna.demos.webshowcase.modules.checkwork.web;

import com.realaicy.tna.demos.webshowcase.common.web.BaseCRUDController;
import com.realaicy.tna.demos.webshowcase.modules.checkwork.model.CheckItem;
import com.realaicy.tna.demos.webshowcase.modules.checkwork.service.CheckItemService;
import com.realaicy.tna.demos.webshowcase.modules.system.resource.service.SysResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by realaicy on 2016/3/14.
 */
@Controller
@RequestMapping("/sa/checkitem")
public class SACheckItemController extends BaseCRUDController<CheckItem, Long> {
    @Autowired
    private CheckItemService checkItemService;

    {
        editView = "/sa/realaicy/checkitem/edit";
        listView = "/sa/realaicy/checkitem/list";
        showView = "/sa/realaicy/checkitem/show";
    }

    /**
     * Greeting string.
     *
     * @param name  the name
     * @param model the model
     * @return the string
     */
    @RequestMapping("/list")
    public String list(@RequestParam(value = "name", required = false, defaultValue = "World")
                       String name, Model model) {
        model.addAttribute("name", name);
        return "sa/realaicy/checkitem/list";
    }

    /**
     * Greeting string.
     *
     * @param name  the name
     * @param model the model
     * @return the string
     */
    @RequestMapping(value = "/api/top", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<CheckItem> getTop(@RequestParam(value = "name", required = false, defaultValue = "World")
                         String name, Model model) {
        model.addAttribute("name", name);
        return checkItemService.getAll();
    }
}

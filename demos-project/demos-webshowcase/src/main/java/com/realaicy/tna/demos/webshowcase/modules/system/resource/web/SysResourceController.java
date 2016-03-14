package com.realaicy.tna.demos.webshowcase.modules.system.resource.web;

import com.realaicy.tna.demos.webshowcase.common.web.BaseCRUDController;
import com.realaicy.tna.demos.webshowcase.modules.system.organization.entity.Organization;
import com.realaicy.tna.demos.webshowcase.modules.system.resource.model.SysResource;
import com.realaicy.tna.demos.webshowcase.modules.system.resource.service.SysResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * Created by realaicy on 2016/3/14.
 */
@Controller
@RequestMapping(value = "/sa/sys/resource")
public class SysResourceController extends BaseCRUDController<SysResource, Long> {

    @Autowired
    private SysResourceService realService;
    {
        editView = "/sa/realaicy/sys/resource/edit";
        listView = "/sa/realaicy/sys/resource/list";
        showView = "/sa/realaicy/sys/resource/show";
    }


    /**
     * Readme string.
     *
     * @return the string
     */
    @RequestMapping(value = "/api/all2", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<SysResource> ListAll2() {
        return realService.getAll();
    }

}

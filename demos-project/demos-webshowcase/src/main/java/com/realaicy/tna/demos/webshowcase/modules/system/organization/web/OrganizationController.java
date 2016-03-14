package com.realaicy.tna.demos.webshowcase.modules.system.organization.web;

import com.realaicy.tna.demos.webshowcase.common.web.BaseCRUDController;
import com.realaicy.tna.demos.webshowcase.common.web.BaseController;
import com.realaicy.tna.demos.webshowcase.modules.system.organization.entity.Organization;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by realaicy on 2016/3/14.
 */
@Controller
@RequestMapping(value = "/sa/sys/organization")
public class OrganizationController extends BaseCRUDController<Organization, Long> {
    {
        editView = "/sa/realaicy/sys/organization/edit";
        listView = "/sa/realaicy/sys/organization/list";
        showView = "/sa/realaicy/sys/organization/show";
    }




}

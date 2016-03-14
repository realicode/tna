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
@RequestMapping(value = "/sys/organization")
public class OrganizationController extends BaseCRUDController<Organization, Long> {
    {
        editView = "/sys/organization/edit";
        listView = "/sys/organization/list";
        showView = "/sys/organization/show";
    }

}

package com.realaicy.tna.demos.webshowcase.modules.system.resource.Service;

import com.realaicy.tna.demos.webshowcase.modules.system.resource.model.SysResource;
import com.realaicy.tna.modules.core.service.BaseService;

import java.util.List;

/**
 * Created by realaicy on 2016/3/14.
 */
public interface SysResourceService{

    public List<SysResource> findAllMenus();
}

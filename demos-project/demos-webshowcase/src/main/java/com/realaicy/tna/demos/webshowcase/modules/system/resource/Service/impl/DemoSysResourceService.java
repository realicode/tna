package com.realaicy.tna.demos.webshowcase.modules.system.resource.Service.impl;

import com.realaicy.tna.demos.webshowcase.modules.system.resource.Service.SysResourceService;
import com.realaicy.tna.demos.webshowcase.modules.system.resource.model.SysResource;
import com.realaicy.tna.demos.webshowcase.modules.system.resource.repos.SysResourceRepos;
import com.realaicy.tna.modules.core.service.DefaultServiceImpl;

import java.util.List;

/**
 * Created by realaicy on 2016/3/14.
 */
public class DemoSysResourceService extends DefaultServiceImpl<SysResource, Long> implements SysResourceService {
    @Override
    public List<SysResource> findAllMenus() {
        return ((SysResourceRepos)baseRepository).findAllMenus();
    }
}

package com.realaicy.tna.demos.webshowcase.modules.system.resource.service.impl;

import com.realaicy.tna.demos.webshowcase.modules.system.resource.model.SysResource;
import com.realaicy.tna.demos.webshowcase.modules.system.resource.repos.SysResourceRepos;
import com.realaicy.tna.demos.webshowcase.modules.system.resource.service.SysResourceService;
import com.realaicy.tna.modules.core.service.DefaultServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by realaicy on 16/3/14.
 */
@Service
public class DemoSysResourceService extends DefaultServiceImpl<SysResource, Long>
        implements SysResourceService {
    @Override
    public List<SysResource> findAllMenus() {
        return  ((SysResourceRepos) baseRepository).findAllMenus();
    }
}

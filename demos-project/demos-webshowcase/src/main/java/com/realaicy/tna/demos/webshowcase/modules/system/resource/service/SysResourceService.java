package com.realaicy.tna.demos.webshowcase.modules.system.resource.service;

import com.realaicy.tna.demos.webshowcase.modules.system.resource.model.SysResource;
import com.realaicy.tna.modules.core.service.BaseService;

import java.util.List;

/**
 * Created by realaicy on 16/3/14.
 */
public interface SysResourceService extends BaseService<SysResource, Long> {
    List<SysResource> findAllMenus();
}

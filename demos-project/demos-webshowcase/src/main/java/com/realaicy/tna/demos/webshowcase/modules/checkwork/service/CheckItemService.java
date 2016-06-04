package com.realaicy.tna.demos.webshowcase.modules.checkwork.service;

import com.realaicy.tna.demos.webshowcase.modules.checkwork.model.CheckItem;
import com.realaicy.tna.demos.webshowcase.modules.system.resource.model.SysResource;
import com.realaicy.tna.modules.core.service.BaseService;
import com.sun.tools.javac.comp.Check;

import java.util.List;

/**
 * Created by realaicy on 16/3/14.
 */
public interface CheckItemService extends BaseService<CheckItem, Long> {
    List<CheckItem> findAllCheckItemExceptRoot();
}

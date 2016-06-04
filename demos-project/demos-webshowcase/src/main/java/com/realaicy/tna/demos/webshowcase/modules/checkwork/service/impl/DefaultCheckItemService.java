package com.realaicy.tna.demos.webshowcase.modules.checkwork.service.impl;

import com.realaicy.tna.demos.webshowcase.modules.checkwork.model.CheckItem;
import com.realaicy.tna.demos.webshowcase.modules.checkwork.repos.CheckItemRepos;
import com.realaicy.tna.demos.webshowcase.modules.checkwork.service.CheckItemService;
import com.realaicy.tna.modules.core.service.DefaultServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by realaicy on 16/3/14.
 */
@Service
public class DefaultCheckItemService extends DefaultServiceImpl<CheckItem, Long>
        implements CheckItemService {

    @Override
    public List<CheckItem> findAllCheckItemExceptRoot() {
        return ((CheckItemRepos) baseRepository).findTopCheckItemExceptRoot();
    }
}

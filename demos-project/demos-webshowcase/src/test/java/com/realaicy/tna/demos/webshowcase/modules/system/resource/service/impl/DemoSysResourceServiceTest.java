package com.realaicy.tna.demos.webshowcase.modules.system.resource.service.impl;

import com.realaicy.tna.demos.webshowcase.Application;
import com.realaicy.tna.demos.webshowcase.modules.system.resource.repos.SysResourceRepos;
import com.realaicy.tna.demos.webshowcase.modules.system.resource.service.SysResourceService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by realaicy on 2016/3/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class DemoSysResourceServiceTest {

    @Autowired
    private SysResourceService sysResourceService;

    @Test
    public void testFindAllMenus() throws Exception {
        System.out.println(sysResourceService.findAllMenus().size());
    }
}
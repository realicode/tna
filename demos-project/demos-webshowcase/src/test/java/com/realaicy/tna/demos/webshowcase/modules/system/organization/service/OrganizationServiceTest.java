package com.realaicy.tna.demos.webshowcase.modules.system.organization.service;

import com.realaicy.tna.demos.webshowcase.Application;
import com.realaicy.tna.demos.webshowcase.modules.system.resource.service.SysResourceService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by realaicy on 16/3/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class OrganizationServiceTest {

    @Autowired
    private OrganizationService organizationService;
    @Test
    public void testFindAll() throws Exception {
        System.out.println(organizationService.getAll().size());
    }
}
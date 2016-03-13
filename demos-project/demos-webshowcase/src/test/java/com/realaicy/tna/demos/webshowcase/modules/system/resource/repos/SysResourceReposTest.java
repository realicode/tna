package com.realaicy.tna.demos.webshowcase.modules.system.resource.repos;

import com.realaicy.tna.demos.webshowcase.Application;
import com.realaicy.tna.demos.webshowcase.modules.system.resource.model.SysResource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by realaicy on 2016/3/13.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class SysResourceReposTest {


    @Autowired
    private  SysResourceRepos sysResourceRepos;

    @Test
    public void testFindAllMenus() throws Exception {

        List<SysResource> sysResources = sysResourceRepos.findAllMenus();
        System.out.println(sysResources.size());

        for (SysResource sysResource:sysResources){
            System.out.println(sysResource.getResName());
            System.out.println(sysResource.getChildren().size());
        }
    }

    @Test
    public void testFindAll() throws Exception {

        System.out.println(sysResourceRepos.findAll().size());
    }



}
package com.realaicy.tna.demos.webshowcase.modules.checkwork.repos;

import com.realaicy.tna.demos.webshowcase.Application;
import com.realaicy.tna.demos.webshowcase.modules.system.resource.model.SysResource;
import com.realaicy.tna.demos.webshowcase.modules.system.resource.repos.SysResourceRepos;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by realaicy on 2016/3/13.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class CheckItemReposTest {


    @Autowired
    private  CheckItemRepos checkItemRepos;


    @Test
    public void testFindAll() throws Exception {

        System.out.println(checkItemRepos.findAll().size());
    }



}
package com.realaicy.tna.demos.webshowcase.modules.system.organization.repos;

import com.realaicy.tna.demos.webshowcase.Application;
import com.realaicy.tna.demos.webshowcase.modules.system.organization.entity.Organization;
import com.realaicy.tna.demos.webshowcase.modules.system.organization.repository.OrganizationRepository;
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
public class OrganizationReposTest {


    @Autowired
    private OrganizationRepository organizationRepository;

    @Test
    public void testFindAllMenus() throws Exception {


    }

    @Test
    public void testFindAll() throws Exception {

        List<Organization> organizations = organizationRepository.findAll();
        System.out.println(organizations.size());

        for (Organization organization:organizations){
            System.out.println(organization.getName());
        }
    }



}
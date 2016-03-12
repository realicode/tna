package com.realaicy.tna.demos.webshowcase.modules.system.menu.service.impl;



import com.realaicy.tna.demos.webshowcase.modules.system.menu.model.Menu;
import com.realaicy.tna.demos.webshowcase.modules.system.menu.repos.MenuRepos;
import com.realaicy.tna.demos.webshowcase.modules.system.menu.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Dummy menu service.
 */
public class DummyMenuService implements MenuService {

    /**
     * {@inheritDoc}
     */
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * {@inheritDoc}
     */
    @Autowired
    private MenuRepos menuRepos;

    /**
     * {@inheritDoc}
     */
    @Transactional
    @Override
    public List<Menu> getMenus() {

        int countOfActorsNamedJoe = this.jdbcTemplate.queryForObject(
                "select count(*) from sys_user ", Integer.class);
        System.out.println("count: " + countOfActorsNamedJoe);
//        System.out.println("menu parent id: " + menuRepos.findOne(3).getParentid());
        System.out.println("menu parent id: " + menuRepos.findOne(DUMMYNUM).getParent().getId());
        System.out.println("menu child size: " + menuRepos.findOne(DUMMYNUM).getChildren().size());


        System.out.println("custom test: " + menuRepos.count(""));


    /*    System.out.println("SpringContextUtil: ");
        String[] beanNames = SpringContextUtil.getApplicationContext().getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }*/

        Menu aMenu = new Menu();
        aMenu.setName("测试目录1");
        Menu bMenu = new Menu();
        bMenu.setName("测试目录2");
        Menu cMenu = new Menu();
        cMenu.setName("测试目录3");
        List<Menu> result = new ArrayList<>();
        result.add(aMenu);
        result.add(bMenu);
        result.add(cMenu);
        return result;
    }

    @Override
    public List<Menu> getTopMenus() {
        return null;
    }

    @Override
    public List<Menu> getAllMenus() {
        return null;
    }

    @Override
    public List<Menu> getMenusByUser() {
        return null;
    }

    @Override
    public List<Menu> getMenusByUserNative() {
        return null;
    }

    @Override
    public Boolean hasChild(int id) {
        return null;
    }

    /**
     * xxx
     */
    private static final int DUMMYNUM = 3;
}

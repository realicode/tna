package com.realaicy.tna.demos.webshowcase.modules.system.menu.service.impl;



import com.realaicy.tna.demos.webshowcase.modules.system.menu.model.Menu;
import com.realaicy.tna.demos.webshowcase.modules.system.menu.repos.MenuRepos;
import com.realaicy.tna.demos.webshowcase.modules.system.menu.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * The type Dummy menu service.
 */
@Service
public class DefaultMenuService implements MenuService {

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


        List<Menu> menus = menuRepos.findTopMenus();

     /*   System.out.println("menu parent id: " + menuRepos.findOne(3).getParentid());
        System.out.println("menu parent id: " + menuRepos.findOne(3).getParent().getId());
        System.out.println("menu child size: " + menuRepos.findOne(3).getChildren().size());

        System.out.println("custom test: " + menuRepos.count(""));

        Menu aMenu = new Menu();
        aMenu.setName("测试目录1");
        Menu bMenu = new Menu();
        bMenu.setName("测试目录2");
        Menu cMenu = new Menu();
        cMenu.setName("测试目录3v2");
        List<Menu> result = new ArrayList<>();
        result.add(aMenu);
        result.add(bMenu);
        result.add(cMenu);
        return result;*/

        return menus;

    }

    @Override
    public List<Menu> getTopMenus() {
        return menuRepos.findTopMenus();
    }

    @Override
    @Transactional
    public List<Menu> getAllMenus() {
        return menuRepos.findAll();
    }

    @Override
    @Transactional
    public List<Menu> getMenusByUser() {
        return menuRepos.findMenusByUser();
    }

    @Override
    public List<Menu> getMenusByUserNative() {
        return menuRepos.findMenusByUserNative();
    }

    @Override
    public Boolean hasChild(int id) {
        return null;
    }
}

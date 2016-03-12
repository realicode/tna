package com.realaicy.tna.demos.webshowcase.modules.system.menu.service;


import com.realaicy.tna.demos.webshowcase.modules.system.menu.model.Menu;

import java.util.List;

/**
 * The interface Menu service.
 */
public interface MenuService {
    /**
     * Gets menus.
     *
     * @return the menus
     */
    List<Menu> getMenus();

    /**
     * Gets menus.
     *
     * @return the menus
     */
    List<Menu> getTopMenus();

    /**
     * 获取所有的菜单项
     *
     * @return the menus
     */
    List<Menu> getAllMenus();


    /**
     * 获取所有的菜单项
     *
     * @return the menus
     */
    List<Menu> getMenusByUser();

    /**
     * 获取所有的菜单项
     *
     * @return the menus
     */
    List<Menu> getMenusByUserNative();

    /**
     * 判断一个给定的菜单项是否有子菜单
     *
     * @param id the id
     * @return ture 如果有
     */
    Boolean hasChild(int id);

}

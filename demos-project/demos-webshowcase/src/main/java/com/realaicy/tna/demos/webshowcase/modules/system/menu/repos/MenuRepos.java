package com.realaicy.tna.demos.webshowcase.modules.system.menu.repos;

import com.realaicy.tna.demos.webshowcase.modules.system.menu.model.Menu;
import com.realaicy.tna.modules.core.orm.jpa.BaseRepository;

import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by Realaicy on 2015/5/14.
 * XXX
 */
public interface MenuRepos extends BaseRepository<Menu, Integer> {

    /**
     * Find menus by user.
     *
     * @return the list
     */
    @Query(value = "SELECT menu FROM Menu menu WHERE parent.id = 0")
    List<Menu> findMenusByUser();

    /**
     * Find menus by user.
     *
     * @return the list
     */
    @Query(value = "SELECT * FROM sys_menu WHERE parent_id = 0", nativeQuery = true)
    List<Menu> findMenusByUserNative();

    /**
     * Find menus by user.
     *
     * @return the list
     */
    @Query(value = "SELECT menu FROM Menu menu WHERE parent.id = 0 and id!=0 ORDER BY menu.realsort  ")
    List<Menu> findTopMenus();

}
package com.realaicy.tna.demos.webshowcase.modules.system.user.repos;

import com.realaicy.tna.demos.webshowcase.modules.system.user.model.User;
import com.realaicy.tna.modules.core.orm.jpa.BaseRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by realaicy on 2016/3/13.
 */
public interface SysResourceRepos extends BaseRepository<User, Long> {
    /**
     * Find menus by user.
     *
     * @return the list
     */
    @Query(value = "SELECT sysResource FROM SysResource sysResource WHERE parent.id=1 and sysResource.resType = 'menu'")
    List<User> findAllMenus();
}

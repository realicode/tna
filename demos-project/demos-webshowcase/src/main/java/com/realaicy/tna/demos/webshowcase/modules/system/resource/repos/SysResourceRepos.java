package com.realaicy.tna.demos.webshowcase.modules.system.resource.repos;

import com.realaicy.tna.demos.webshowcase.modules.system.resource.model.SysResource;
import com.realaicy.tna.modules.core.orm.jpa.BaseRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by realaicy on 2016/3/13.
 */
public interface SysResourceRepos extends BaseRepository<SysResource, Long> {
    /**
     * Find menus by user.
     *
     * @return the list
     */
    @Query(value = "SELECT sysResource FROM SysResource sysResource WHERE parent.id=1 and sysResource.resType = 'menu'")
    List<SysResource> findAllMenus();
}

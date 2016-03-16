package com.realaicy.tna.demos.webshowcase.modules.checkwork.repos;

import com.realaicy.tna.demos.webshowcase.modules.checkwork.model.CheckItem;
import com.realaicy.tna.demos.webshowcase.modules.system.resource.model.SysResource;
import com.realaicy.tna.modules.core.orm.jpa.BaseRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by realaicy on 2016/3/13.
 */
public interface CheckItemRepos extends BaseRepository<CheckItem, Long> {
    /**
     * Find menus by user.
     *
     * @return the list
     */
    @Query(value = "SELECT checkItem FROM CheckItem checkItem" +
            " WHERE checkItem.parentid=0 and checkItem.id!=0 and show = 1 ORDER By checkItem.id ")
    List<CheckItem> findAll();
}

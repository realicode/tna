package com.realaicy.tna.modules.core.orm.jpa;

import com.realaicy.tna.modules.core.orm.jpa.search.Searchable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * Created by Realaicy on 2015/5/14.
 *
 * @param <T>  the type parameter
 * @param <ID> the type parameter
 */
@NoRepositoryBean
public interface BaseRepository<T, ID extends Serializable>
        extends JpaRepository<T, ID> {

    /**
     * 根据主键删除
     *
     * @param ids xxx
     */
    void delete(ID[] ids);


    /**
     * 根据条件查询所有
     * 条件 + 分页 + 排序
     *
     * @param searchable xxx
     * @return xxx
     */
    Page<T> findAll(Searchable searchable);


    /**
     * 根据条件统计所有记录数
     *
     * @param searchable xxx
     * @return xxx
     */
    long count(Searchable searchable);

    /**
     * 根据条件统计所有记录数
     *
     * @param temp XXX
     * @return XXX
     */
    int count(String temp);
}
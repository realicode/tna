package com.realaicy.tna.modules.core.service;

import com.fasterxml.jackson.databind.ser.PropertyFilter;

import com.realaicy.tna.modules.core.orm.AbstractEntity;
import com.realaicy.tna.modules.core.orm.jpa.search.Searchable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * <p>抽象service层基类 提供一些简便方法
 * <p/>
 * <p>泛型 ： M 表示实体类型；ID表示主键类型
 * <p/>
 * <p>User: Zhang Kaitao
 * <p>Date: 13-1-12 下午4:43
 * <p>Version: 1.0
 *
 * @param <M>  the type parameter
 * @param <ID> the type parameter
 */
public interface BaseService<M extends AbstractEntity, ID extends Serializable> {

    /**
     * 根据ID获得单个对象
     *
     * @param id 主键
     * @return 实体 m
     */
    M get(ID id);

    /**
     * 根据ID集合查询
     *
     * @param ids the ids
     * @return list list
     */
    List<M> get(final Collection<ID> ids);

    /**
     * 获得对象所有集合
     *
     * @return all all
     */
    List<M> getAll();


    /**
     * 实体是否存在
     *
     * @param id 主键
     * @return 存在 返回true，否则false
     */
    boolean exists(ID id);

    /**
     * 统计实体总数
     *
     * @return 实体总数 long
     */
    long count();

    /**
     * 保存对象
     *
     * @param o the o
     */
    void save(M o);

    /**
     * 保存对象
     *
     * @param mList the m list
     */
    void save(List<M> mList);

    /**
     * 保存对象
     *
     * @param o the o
     */
    void saveAndFlush(M o);

    /**
     * 更新对象
     *
     * @param o the o
     */
    void update(M o);

    /**
     * 删除对象
     *
     * @param o the o
     */
    void remove(M o);

    /**
     * 根据ID删除对象
     *
     * @param id the id
     */
    void removeById(ID id);

    /**
     * 批量删除
     *
     * @param ids the ids
     */
    void removeByIds(ID[] ids);


    /**
     * 分页及排序查询实体
     *
     * @param pageable 分页及排序数据
     * @return page page
     */
    Page<M> findAll(Pageable pageable);

    /**
     * 按条件不分页不排序查询实体
     *
     * @param searchable 条件
     * @return XXX list
     */
    List<M> findAllWithNoPageNoSort(Searchable searchable);

    /**
     * 按条件排序查询实体(不分页)
     *
     * @param searchable 条件
     * @return XXX list
     */
    List<M> findAllWithSort(Searchable searchable);


    /**
     * 按条件分页并排序统计实体数量
     *
     * @param searchable 条件
     * @return XXX long
     */
    Long count(Searchable searchable);


    /**
     * 分页查询
     *
     * @param pageRequest the page request
     * @param hql         the hql
     * @param values      the values
     * @return page page
     */
    Page<M> findPage(final PageRequest pageRequest, String hql, final Object... values);

    /**
     * 分页查询
     *
     * @param pageRequest the page request
     * @param hql         the hql
     * @param values      the values
     * @return page page
     */
    Page<M> findPage(final PageRequest pageRequest, String hql, final Map<String, ?> values);

    /**
     * 按照属性条件封装类查询
     *
     * @param pageRequest the page request
     * @param filters     the filters
     * @return page page
     */
    Page<M> findPage(final PageRequest pageRequest, final List<PropertyFilter> filters);

    /**
     * 添加orfilters
     *
     * @param pageRequest the page request
     * @param filters     the filters
     * @param orfilters   the orfilters
     * @return page page
     */
    Page<M> findPage(final PageRequest pageRequest, final List<PropertyFilter> filters,
                     final List<PropertyFilter> orfilters);

    /**
     * 根据属性值查找唯一对象
     *
     * @param propertyName the property name
     * @param value        the value
     * @return t m
     */
    M findUniqueBy(final String propertyName, final Object value);

    /**
     * 按照属性条件封装类查询 不分页
     *
     * @param filters the filters
     * @return list list
     */
    List<M> find(List<PropertyFilter> filters);

    /**
     * 按一个属性查询
     *
     * @param propertyName the property name
     * @param value        the value
     * @return list list
     */
    List<M> findBy(final String propertyName, final Object value);

    /**
     * 按属性查询,并按某个属性排序
     *
     * @param propertyName    the property name
     * @param value           the value
     * @param orderByProperty the order by property
     * @param isAsc           the is asc
     * @return list list
     */
    List<M> findBy(final String propertyName, final Object value, String orderByProperty, boolean isAsc);


}

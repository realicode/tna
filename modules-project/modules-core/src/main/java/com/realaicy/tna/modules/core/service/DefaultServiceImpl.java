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
 * Created by Realaicy on 2015/6/2.
 * XXX
 *
 * @param <M>  the type parameter
 * @param <ID> the type parameter
 */
public class DefaultServiceImpl<M extends AbstractEntity, ID extends Serializable>
        extends ABBaseServiceImpl<M, ID> {

    @Override
    public M get(ID id) {
        return null;
    }

    @Override
    public List<M> get(Collection<ID> ids) {
        return null;
    }

    @Override
    public List<M> getAll() {
        return baseRepository.findAll();
    }

    @Override
    public boolean exists(ID id) {
        return false;
    }

    @Override
    public long count() {

        return baseRepository.count();
    }

    @Override
    public void save(M o) {
        baseRepository.save(o);
    }

    @Override
    public void save(List<M> mList) {
        baseRepository.save(mList);
    }

    @Override
    public void saveAndFlush(M o) {

    }

    @Override
    public void update(M o) {

    }

    @Override
    public void remove(M o) {

    }

    @Override
    public void removeById(ID id) {

    }

    @Override
    public void removeByIds(ID[] ids) {

    }

    @Override
    public Page<M> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<M> findAllWithNoPageNoSort(Searchable searchable) {
        return null;
    }

    @Override
    public List<M> findAllWithSort(Searchable searchable) {
        return null;
    }

    @Override
    public Long count(Searchable searchable) {
        return null;
    }

    @Override
    public Page<M> findPage(PageRequest pageRequest, String hql, Object... values) {
        return null;
    }

    @Override
    public Page<M> findPage(PageRequest pageRequest, String hql, Map<String, ?> values) {
        return null;
    }

    @Override
    public Page<M> findPage(PageRequest pageRequest, List<PropertyFilter> filters) {
        return null;
    }

    @Override
    public Page<M> findPage(PageRequest pageRequest, List<PropertyFilter> filters, List<PropertyFilter> orfilters) {
        return null;
    }

    @Override
    public M findUniqueBy(String propertyName, Object value) {
        return null;
    }

    @Override
    public List<M> find(List<PropertyFilter> filters) {
        return null;
    }

    @Override
    public List<M> findBy(String propertyName, Object value) {
        return null;
    }

    @Override
    public List<M> findBy(String propertyName, Object value, String orderByProperty, boolean isAsc) {
        return null;
    }
}

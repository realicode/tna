package com.realaicy.tna.demos.webshowcase.modules.system.menu.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * The type Menu.
 *
 * @author 模块实体类　（一对多）
 *         　JPA中一对多和多对一双向关系中，多的一方为关系维护端。
 *         关系维护端负责外键纪录的更新，关系被维护端是没有权力更新外键纪录的。
 */
@Entity
@Table(name = "sys_menu")
public class Menu implements Serializable {

    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    /**
     * 菜单名称
     */
    @Column
    private String name;
    /**
     * 菜单url
     */
    @Column
    private String uri;
    /**
     * 菜单排序权值
     */
    @Column
    private Short realsort;

    /**
     * Getter for property 'parentid'.
     *
     * @return Value for property 'parentid'.
     */
    public Integer getParentid() {
        return parentid;
    }

    /**
     * Setter for property 'parentid'.
     *
     * @param parentid Value to set for property 'parentid'.
     */
    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    /**
     * 父亲菜单对象ID
     */
    @Column(name = "parentid", unique = false, nullable = true, insertable = false, updatable = false)
    private Integer parentid;
    /**
     * 父亲菜单对象
     */
    @ManyToOne
    @JoinColumn(name = "parentid")
    @JsonIgnore
    private Menu parent;
    /**
     * 孩子菜单对象
     */
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "parent")
    @OrderBy("realsort")
    @JsonIgnore
    private List<Menu> children = new ArrayList<>();


    /**
     * Getter for property 'id'.
     *
     * @return Value for property 'id'.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Setter for property 'id'.
     *
     * @param id Value to set for property 'id'.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Getter for property 'name'.
     *
     * @return Value for property 'name'.
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for property 'name'.
     *
     * @param name Value to set for property 'name'.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for property 'uri'.
     *
     * @return Value for property 'uri'.
     */
    public String getUri() {
        return uri;
    }

    /**
     * Setter for property 'uri'.
     *
     * @param uri Value to set for property 'uri'.
     */
    public void setUri(String uri) {
        this.uri = uri;
    }


    /**
     * Getter for property 'realsort'.
     *
     * @return Value for property 'realsort'.
     */
    public Short getRealsort() {
        return realsort;
    }

    /**
     * Setter for property 'realsort'.
     *
     * @param realsort Value to set for property 'realsort'.
     */
    public void setRealsort(Short realsort) {
        this.realsort = realsort;
    }



    /*public Menu getParent() {
        return parent;
    }

    public void setParent(Menu parent) {
        this.parent = parent;
    }

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Menu parent;*/


    /**
     * Getter for property 'parent'.
     *
     * @return Value for property 'parent'.
     */
    public Menu getParent() {
        return parent;
    }

    /**
     * Setter for property 'parent'.
     *
     * @param parent Value to set for property 'parent'.
     */
    public void setParent(Menu parent) {
        this.parent = parent;
    }

    /**
     * Getter for property 'children'.
     *
     * @return Value for property 'children'.
     */
    public List<Menu> getChildren() {
        return children;
    }

    /**
     * Setter for property 'children'.
     *
     * @param children Value to set for property 'children'.
     */
    public void setChildren(List<Menu> children) {
        this.children = children;
    }




/*
    // 父级模块
    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.REMOVE}, optional = true)
    @JoinColumn(name = "parent_id")
    // optional关联字段是否可以为空
    private Menu parent;
    // 子级模块
    @OneToMany(cascade = {CascadeType.REFRESH, CascadeType.REMOVE}, fetch = FetchType.LAZY, mappedBy = "parent")
    private List<Menu> children;*/
}

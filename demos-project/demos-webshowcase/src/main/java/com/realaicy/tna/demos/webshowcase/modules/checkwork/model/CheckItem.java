package com.realaicy.tna.demos.webshowcase.modules.checkwork.model;

/**
 * Created by realaicy on 16/3/16.
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.realaicy.tna.modules.core.orm.jpa.BaseEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The type CheckItem.
 *
 * @author 检查项实体类　（一对多）
 *
 */
@Entity
@Table(name = "CHK_ITEM")
public class CheckItem extends BaseEntity<Long> {


    /**
     * 检查项名称
     */
    @Column(name = "NAME")
    private String itemName;
    /**
     * 检查项内容
     */
    @Column(name = "CONTENT")

    private String itemContent;
    /**
     * 检查项图标
     */
    @Column(name = "ICON")
    private Short itemIcon;
    /**
     * 检查项排序权值
     */
    @Column(name = "WEIGHT")
    private Short itemWeight;
    /**
     * 是否显示
     */
    @Column(name = "IS_SHOW")
    private Boolean show = Boolean.FALSE;
    /**
     * 父亲菜单对象ID
     */
    @Column(name = "pid", unique = false, nullable = true, insertable = false, updatable = false)
    private Long parentid;
    /**
     * 父亲菜单对象
     */
    @ManyToOne
    @JoinColumn(name = "pid")
    @JsonIgnore
    private CheckItem parent;
    /**
     * 孩子菜单对象
     */
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "parent")
    @OrderBy("id")
    @JsonIgnore
    private List<CheckItem> children = new ArrayList<>();

    public Long getParentid() {
        return parentid;
    }

    public void setParentid(Long parentid) {
        this.parentid = parentid;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemContent() {
        return itemContent;
    }

    public void setItemContent(String itemContent) {
        this.itemContent = itemContent;
    }

    public Short getItemIcon() {
        return itemIcon;
    }

    public void setItemIcon(Short itemIcon) {
        this.itemIcon = itemIcon;
    }

    public Short getItemWeight() {
        return itemWeight;
    }

    public void setItemWeight(Short itemWeight) {
        this.itemWeight = itemWeight;
    }

    public Boolean getShow() {
        return show;
    }

    public void setShow(Boolean show) {
        this.show = show;
    }

    public CheckItem getParent() {
        return parent;
    }

    public void setParent(CheckItem parent) {
        this.parent = parent;
    }

    public List<CheckItem> getChildren() {
        return children;
    }

    public void setChildren(List<CheckItem> children) {
        this.children = children;
    }




    /*public Resource getParent() {
        return parent;
    }

    public void setParent(Resource parent) {
        this.parent = parent;
    }

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Resource parent;*/




/*
    // 父级模块
    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.REMOVE}, optional = true)
    @JoinColumn(name = "parent_id")
    // optional关联字段是否可以为空
    private Resource parent;
    // 子级模块
    @OneToMany(cascade = {CascadeType.REFRESH, CascadeType.REMOVE}, fetch = FetchType.LAZY, mappedBy = "parent")
    private List<Resource> children;*/
}

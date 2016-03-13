package com.realaicy.tna.demos.webshowcase.modules.system.resource.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.realaicy.tna.modules.core.orm.jpa.BaseEntity;

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
 * The type Resource.
 *
 * @author 模块实体类　（一对多）
 *         　JPA中一对多和多对一双向关系中，多的一方为关系维护端。
 *         关系维护端负责外键纪录的更新，关系被维护端是没有权力更新外键纪录的。
 */
@Entity
@Table(name = "sys_resource")
public class SysResource extends BaseEntity<Long> {


    public Long getParentid() {
        return parentid;
    }

    public void setParentid(Long parentid) {
        this.parentid = parentid;
    }

    /**
     * 资源名称
     */
    @Column(name = "name")

    private String resName;


    /**
     * 资源种类
     */
    @Column(name = "type")
    private String resType;
    /**
     * 资源标识符 用于权限匹配的 如sys:resource
     */
    @Column(name = "identity")
    private String resIdentity;
    /**
     * 资源URI
     */
    @Column(name = "uri")
    private String resUri;

    /**
     * 资源图标
     */
    @Column(name = "icon")
    private Short resIcon;
    /**
     * 资源排序权值
     */
    @Column(name = "weight")
    private Short resWeight;

    /**
     * 是否显示
     */
    @Column(name = "IS_SHOW")
    private Boolean show = Boolean.FALSE;


    /**
     * 父亲菜单对象ID
     */
    @Column(name = "parent_id", unique = false, nullable = true, insertable = false, updatable = false)
    private Long parentid;
    /**
     * 父亲菜单对象
     */
    @ManyToOne
    @JoinColumn(name = "parent_id")
    @JsonIgnore
    private SysResource parent;
    /**
     * 孩子菜单对象
     */
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "parent")
    @OrderBy("resWeight")
    @JsonIgnore
    private List<SysResource> children = new ArrayList<>();


    public String getResName() {
        return resName;
    }

    public void setResName(String resName) {
        this.resName = resName;
    }

    public String getResType() {
        return resType;
    }

    public void setResType(String resType) {
        this.resType = resType;
    }

    public String getResIdentity() {
        return resIdentity;
    }

    public void setResIdentity(String resIdentity) {
        this.resIdentity = resIdentity;
    }

    public String getResUri() {
        return resUri;
    }

    public void setResUri(String resUri) {
        this.resUri = resUri;
    }

    public Short getResIcon() {
        return resIcon;
    }

    public void setResIcon(Short resIcon) {
        this.resIcon = resIcon;
    }

    public Short getResWeight() {
        return resWeight;
    }

    public void setResWeight(Short resWeight) {
        this.resWeight = resWeight;
    }

    public Boolean getShow() {
        return show;
    }

    public void setShow(Boolean show) {
        this.show = show;
    }

    public SysResource getParent() {
        return parent;
    }

    public void setParent(SysResource parent) {
        this.parent = parent;
    }

    public List<SysResource> getChildren() {
        return children;
    }

    public void setChildren(List<SysResource> children) {
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

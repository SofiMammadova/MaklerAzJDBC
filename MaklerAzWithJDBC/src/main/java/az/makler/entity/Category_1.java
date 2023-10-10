/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package az.makler.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author sofiya.mammadova
 */
@Entity
@Table(name = "category")
@NamedQueries({
    @NamedQuery(name = "Category_1.findAll", query = "SELECT c FROM Category_1 c"),
    @NamedQuery(name = "Category_1.findByCategoryId", query = "SELECT c FROM Category_1 c WHERE c.categoryId = :categoryId"),
    @NamedQuery(name = "Category_1.findByCategoryName", query = "SELECT c FROM Category_1 c WHERE c.categoryName = :categoryName")})
public class Category_1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "category_id")
    private Integer categoryId;
    @Column(name = "category_name")
    private String categoryName;
    @OneToMany(mappedBy = "categoryId")
    private List<Elan_1> elanList;

    public Category_1() {
    }

    public Category_1(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<Elan_1> getElanList() {
        return elanList;
    }

    public void setElanList(List<Elan_1> elanList) {
        this.elanList = elanList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (categoryId != null ? categoryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Category_1)) {
            return false;
        }
        Category_1 other = (Category_1) object;
        if ((this.categoryId == null && other.categoryId != null) || (this.categoryId != null && !this.categoryId.equals(other.categoryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "az.makler.entity.Category_1[ categoryId=" + categoryId + " ]";
    }
    
}

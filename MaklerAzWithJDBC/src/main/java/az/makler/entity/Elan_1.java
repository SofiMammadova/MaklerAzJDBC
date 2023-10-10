/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package az.makler.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author sofiya.mammadova
 */
@Entity
@Table(name = "elan")
@NamedQueries({
    @NamedQuery(name = "Elan_1.findAll", query = "SELECT e FROM Elan_1 e"),
    @NamedQuery(name = "Elan_1.findByElanId", query = "SELECT e FROM Elan_1 e WHERE e.elanId = :elanId"),
    @NamedQuery(name = "Elan_1.findByTip", query = "SELECT e FROM Elan_1 e WHERE e.tip = :tip"),
    @NamedQuery(name = "Elan_1.findByMertebe", query = "SELECT e FROM Elan_1 e WHERE e.mertebe = :mertebe"),
    @NamedQuery(name = "Elan_1.findBySahe", query = "SELECT e FROM Elan_1 e WHERE e.sahe = :sahe"),
    @NamedQuery(name = "Elan_1.findByUnvan", query = "SELECT e FROM Elan_1 e WHERE e.unvan = :unvan")})
public class Elan_1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "elan_id")
    private Integer elanId;
    @Column(name = "tip")
    private String tip;
    @Column(name = "mertebe")
    private Short mertebe;
    @Column(name = "sahe")
    private Short sahe;
    @Column(name = "unvan")
    private String unvan;
    @JoinColumn(name = "agent_id", referencedColumnName = "agent_id")
    @ManyToOne
    private Agentlik_1 agentId;
    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    @ManyToOne
    private Category_1 categoryId;

    public Elan_1() {
    }

    public Elan_1(Integer elanId) {
        this.elanId = elanId;
    }

    public Integer getElanId() {
        return elanId;
    }

    public void setElanId(Integer elanId) {
        this.elanId = elanId;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public Short getMertebe() {
        return mertebe;
    }

    public void setMertebe(Short mertebe) {
        this.mertebe = mertebe;
    }

    public Short getSahe() {
        return sahe;
    }

    public void setSahe(Short sahe) {
        this.sahe = sahe;
    }

    public String getUnvan() {
        return unvan;
    }

    public void setUnvan(String unvan) {
        this.unvan = unvan;
    }

    public Agentlik_1 getAgentId() {
        return agentId;
    }

    public void setAgentId(Agentlik_1 agentId) {
        this.agentId = agentId;
    }

    public Category_1 getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Category_1 categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (elanId != null ? elanId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Elan_1)) {
            return false;
        }
        Elan_1 other = (Elan_1) object;
        if ((this.elanId == null && other.elanId != null) || (this.elanId != null && !this.elanId.equals(other.elanId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "az.makler.entity.Elan_1[ elanId=" + elanId + " ]";
    }
    
}

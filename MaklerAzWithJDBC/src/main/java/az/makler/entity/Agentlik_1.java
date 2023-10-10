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
@Table(name = "agentlik")
@NamedQueries({
    @NamedQuery(name = "Agentlik_1.findAll", query = "SELECT a FROM Agentlik_1 a"),
    @NamedQuery(name = "Agentlik_1.findByAgentId", query = "SELECT a FROM Agentlik_1 a WHERE a.agentId = :agentId"),
    @NamedQuery(name = "Agentlik_1.findByAgentName", query = "SELECT a FROM Agentlik_1 a WHERE a.agentName = :agentName"),
    @NamedQuery(name = "Agentlik_1.findByContact", query = "SELECT a FROM Agentlik_1 a WHERE a.contact = :contact")})
public class Agentlik_1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "agent_id")
    private Integer agentId;
    @Column(name = "agent_name")
    private String agentName;
    @Column(name = "contact")
    private String contact;
    @OneToMany(mappedBy = "agentId")
    private List<Elan_1> elanList;

    public Agentlik_1() {
    }

    public Agentlik_1(Integer agentId) {
        this.agentId = agentId;
    }

    public Integer getAgentId() {
        return agentId;
    }

    public void setAgentId(Integer agentId) {
        this.agentId = agentId;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
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
        hash += (agentId != null ? agentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Agentlik_1)) {
            return false;
        }
        Agentlik_1 other = (Agentlik_1) object;
        if ((this.agentId == null && other.agentId != null) || (this.agentId != null && !this.agentId.equals(other.agentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "az.makler.entity.Agentlik_1[ agentId=" + agentId + " ]";
    }
    
}

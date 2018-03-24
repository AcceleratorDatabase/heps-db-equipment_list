/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heps.db.equipment_list.entity;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Paul
 */
@Entity
@Table(name = "re_equipment_status")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ReEquipmentStatus.findAll", query = "SELECT r FROM ReEquipmentStatus r")
    , @NamedQuery(name = "ReEquipmentStatus.findById", query = "SELECT r FROM ReEquipmentStatus r WHERE r.id = :id")
    , @NamedQuery(name = "ReEquipmentStatus.findByNumber", query = "SELECT r FROM ReEquipmentStatus r WHERE r.number = :number")})
public class ReEquipmentStatus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Column(name = "Number")
    private Integer number;
    @JoinColumn(name = "EquipmentId", referencedColumnName = "Id")
    @ManyToOne
    private Equipment equipmentId;
    @JoinColumn(name = "StatusId", referencedColumnName = "Id")
    @ManyToOne
    private Status statusId;

    public ReEquipmentStatus() {
    }

    public ReEquipmentStatus(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Equipment getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(Equipment equipmentId) {
        this.equipmentId = equipmentId;
    }

    public Status getStatusId() {
        return statusId;
    }

    public void setStatusId(Status statusId) {
        this.statusId = statusId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReEquipmentStatus)) {
            return false;
        }
        ReEquipmentStatus other = (ReEquipmentStatus) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "heps.db.equipment_list.entity.ReEquipmentStatus[ id=" + id + " ]";
    }
    
}

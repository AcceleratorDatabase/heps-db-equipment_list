/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heps.db.equipment_list.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Paul
 */
@Entity
@Table(name = "equipment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Equipment.findAll", query = "SELECT e FROM Equipment e")
    , @NamedQuery(name = "Equipment.findById", query = "SELECT e FROM Equipment e WHERE e.id = :id")
    , @NamedQuery(name = "Equipment.findByName", query = "SELECT e FROM Equipment e WHERE e.name = :name")
    , @NamedQuery(name = "Equipment.findByLabel", query = "SELECT e FROM Equipment e WHERE e.label = :label")
    , @NamedQuery(name = "Equipment.findByCreatedDate", query = "SELECT e FROM Equipment e WHERE e.createdDate = :createdDate")
    , @NamedQuery(name = "Equipment.findByCommissioningDate", query = "SELECT e FROM Equipment e WHERE e.commissioningDate = :commissioningDate")
    , @NamedQuery(name = "Equipment.findByCurrentCost", query = "SELECT e FROM Equipment e WHERE e.currentCost = :currentCost")
    , @NamedQuery(name = "Equipment.findByOriginalValue", query = "SELECT e FROM Equipment e WHERE e.originalValue = :originalValue")
    , @NamedQuery(name = "Equipment.findByInUseNum", query = "SELECT e FROM Equipment e WHERE e.inUseNum = :inUseNum")
    , @NamedQuery(name = "Equipment.findByInStockNum", query = "SELECT e FROM Equipment e WHERE e.inStockNum = :inStockNum")
    , @NamedQuery(name = "Equipment.findByLifeSpan", query = "SELECT e FROM Equipment e WHERE e.lifeSpan = :lifeSpan")
    , @NamedQuery(name = "Equipment.findByMaintenance", query = "SELECT e FROM Equipment e WHERE e.maintenance = :maintenance")
    , @NamedQuery(name = "Equipment.findByOwner", query = "SELECT e FROM Equipment e WHERE e.owner = :owner")})
public class Equipment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "Name")
    private String name;
    @Size(max = 45)
    @Column(name = "Label")
    private String label;
    @Column(name = "CreatedDate")
    @Temporal(TemporalType.DATE)
    private Date createdDate;
    @Column(name = "CommissioningDate")
    @Temporal(TemporalType.DATE)
    private Date commissioningDate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "CurrentCost")
    private Double currentCost;
    @Column(name = "OriginalValue")
    private Double originalValue;
    @Column(name = "InUseNum")
    private Integer inUseNum;
    @Column(name = "InStockNum")
    private Integer inStockNum;
    @Size(max = 45)
    @Column(name = "LifeSpan")
    private String lifeSpan;
    @Size(max = 45)
    @Column(name = "Maintenance")
    private String maintenance;
    @Size(max = 45)
    @Column(name = "Owner")
    private String owner;
    @OneToMany(mappedBy = "equipmentId")
    private Collection<ReEquipmentStatus> reEquipmentStatusCollection;
    @JoinColumn(name = "LocationId", referencedColumnName = "Id")
    @ManyToOne
    private Location locationId;
    @JoinColumn(name = "DealerId", referencedColumnName = "Id")
    @ManyToOne
    private Dealer dealerId;
    @JoinColumn(name = "BusinessUnitId", referencedColumnName = "Id")
    @ManyToOne
    private BusinessUnit businessUnitId;
    @JoinColumn(name = "ProjectId", referencedColumnName = "Id")
    @ManyToOne
    private Project projectId;
    @JoinColumn(name = "ManufacturerId", referencedColumnName = "model_id")
    @ManyToOne
    private ManufactureModel manufacturerId;

    public Equipment() {
    }

    public Equipment(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getCommissioningDate() {
        return commissioningDate;
    }

    public void setCommissioningDate(Date commissioningDate) {
        this.commissioningDate = commissioningDate;
    }

    public Double getCurrentCost() {
        return currentCost;
    }

    public void setCurrentCost(Double currentCost) {
        this.currentCost = currentCost;
    }

    public Double getOriginalValue() {
        return originalValue;
    }

    public void setOriginalValue(Double originalValue) {
        this.originalValue = originalValue;
    }

    public Integer getInUseNum() {
        return inUseNum;
    }

    public void setInUseNum(Integer inUseNum) {
        this.inUseNum = inUseNum;
    }

    public Integer getInStockNum() {
        return inStockNum;
    }

    public void setInStockNum(Integer inStockNum) {
        this.inStockNum = inStockNum;
    }

    public String getLifeSpan() {
        return lifeSpan;
    }

    public void setLifeSpan(String lifeSpan) {
        this.lifeSpan = lifeSpan;
    }

    public String getMaintenance() {
        return maintenance;
    }

    public void setMaintenance(String maintenance) {
        this.maintenance = maintenance;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @XmlTransient
    public Collection<ReEquipmentStatus> getReEquipmentStatusCollection() {
        return reEquipmentStatusCollection;
    }

    public void setReEquipmentStatusCollection(Collection<ReEquipmentStatus> reEquipmentStatusCollection) {
        this.reEquipmentStatusCollection = reEquipmentStatusCollection;
    }

    public Location getLocationId() {
        return locationId;
    }

    public void setLocationId(Location locationId) {
        this.locationId = locationId;
    }

    public Dealer getDealerId() {
        return dealerId;
    }

    public void setDealerId(Dealer dealerId) {
        this.dealerId = dealerId;
    }

    public BusinessUnit getBusinessUnitId() {
        return businessUnitId;
    }

    public void setBusinessUnitId(BusinessUnit businessUnitId) {
        this.businessUnitId = businessUnitId;
    }

    public Project getProjectId() {
        return projectId;
    }

    public void setProjectId(Project projectId) {
        this.projectId = projectId;
    }

    public ManufactureModel getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(ManufactureModel manufacturerId) {
        this.manufacturerId = manufacturerId;
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
        if (!(object instanceof Equipment)) {
            return false;
        }
        Equipment other = (Equipment) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "heps.db.equipment_list.entity.Equipment[ id=" + id + " ]";
    }
    
}

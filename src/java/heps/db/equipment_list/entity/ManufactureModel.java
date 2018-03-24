/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heps.db.equipment_list.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Paul
 */
@Entity
@Table(name = "manufacture model")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ManufactureModel.findAll", query = "SELECT m FROM ManufactureModel m")
    , @NamedQuery(name = "ManufactureModel.findByModelId", query = "SELECT m FROM ManufactureModel m WHERE m.modelId = :modelId")
    , @NamedQuery(name = "ManufactureModel.findByParameterName", query = "SELECT m FROM ManufactureModel m WHERE m.parameterName = :parameterName")
    , @NamedQuery(name = "ManufactureModel.findByParameterValue", query = "SELECT m FROM ManufactureModel m WHERE m.parameterValue = :parameterValue")})
public class ManufactureModel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "model_id")
    private Integer modelId;
    @Size(max = 45)
    @Column(name = "parameter_name")
    private String parameterName;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "parameter_value")
    private Double parameterValue;
    @JoinColumn(name = "manufacturer_id", referencedColumnName = "Id")
    @ManyToOne
    private Manufacturer manufacturerId;
    @OneToMany(mappedBy = "manufacturerId")
    private Collection<Equipment> equipmentCollection;

    public ManufactureModel() {
    }

    public ManufactureModel(Integer modelId) {
        this.modelId = modelId;
    }

    public Integer getModelId() {
        return modelId;
    }

    public void setModelId(Integer modelId) {
        this.modelId = modelId;
    }

    public String getParameterName() {
        return parameterName;
    }

    public void setParameterName(String parameterName) {
        this.parameterName = parameterName;
    }

    public Double getParameterValue() {
        return parameterValue;
    }

    public void setParameterValue(Double parameterValue) {
        this.parameterValue = parameterValue;
    }

    public Manufacturer getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(Manufacturer manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    @XmlTransient
    public Collection<Equipment> getEquipmentCollection() {
        return equipmentCollection;
    }

    public void setEquipmentCollection(Collection<Equipment> equipmentCollection) {
        this.equipmentCollection = equipmentCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (modelId != null ? modelId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ManufactureModel)) {
            return false;
        }
        ManufactureModel other = (ManufactureModel) object;
        if ((this.modelId == null && other.modelId != null) || (this.modelId != null && !this.modelId.equals(other.modelId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "heps.db.equipment_list.entity.ManufactureModel[ modelId=" + modelId + " ]";
    }
    
}

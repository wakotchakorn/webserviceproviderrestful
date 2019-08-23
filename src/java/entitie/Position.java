/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitie;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
 * @author 8402-01
 */
@Entity
@Table(name = "position")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Position.findAll", query = "SELECT p FROM Position p")
    , @NamedQuery(name = "Position.findByPositionID", query = "SELECT p FROM Position p WHERE p.positionID = :positionID")
    , @NamedQuery(name = "Position.findByPositionName", query = "SELECT p FROM Position p WHERE p.positionName = :positionName")})
public class Position implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PositionID")
    private Integer positionID;
    @Size(max = 50)
    @Column(name = "PositionName")
    private String positionName;
    @OneToMany(mappedBy = "positionID")
    private Collection<Employee> employeeCollection;

    public Position() {
    }

    public Position(Integer positionID) {
        this.positionID = positionID;
    }

    public Integer getPositionID() {
        return positionID;
    }

    public void setPositionID(Integer positionID) {
        this.positionID = positionID;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    @XmlTransient
    public Collection<Employee> getEmployeeCollection() {
        return employeeCollection;
    }

    public void setEmployeeCollection(Collection<Employee> employeeCollection) {
        this.employeeCollection = employeeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (positionID != null ? positionID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Position)) {
            return false;
        }
        Position other = (Position) object;
        if ((this.positionID == null && other.positionID != null) || (this.positionID != null && !this.positionID.equals(other.positionID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitie.Position[ positionID=" + positionID + " ]";
    }
    
}

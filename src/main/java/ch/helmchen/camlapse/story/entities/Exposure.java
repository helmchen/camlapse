/*
 * File: Exposure.java, created at 06.04.2012
 * $Id$
 * Copyright 2012 Helmut Gehrer <helmut.gehrer@helmchen.ch>
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ch.helmchen.camlapse.story.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
/**
 * @todo Klasse Exposure dokumentieren.
 *
 * @author Helmut Gehrer <helmut.gehrer@helmchen.ch>
 * @since  06.04.2012
 */
@Entity
@Table(name = "Exposure")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Exposure.findAll", query = "SELECT e FROM Exposure e"),
    @NamedQuery(name = "Exposure.findByExposureId", query =
    "SELECT e FROM Exposure e WHERE e.exposureId = :exposureId"),
    @NamedQuery(name = "Exposure.findByProjectId", query = "SELECT e FROM Exposure e WHERE e.projectId = :projectId"),
    @NamedQuery(name = "Exposure.findByTakenAt", query = "SELECT e FROM Exposure e WHERE e.takenAt = :takenAt"),
    @NamedQuery(name = "Exposure.findByFilename", query = "SELECT e FROM Exposure e WHERE e.filename = :filename"),
    @NamedQuery(name = "Exposure.findBySuccessfull", query =
    "SELECT e FROM Exposure e WHERE e.successfull = :successfull")})
public class Exposure implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "exposureId", nullable = false)
    private Integer exposureId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "projectId", nullable = false)
    private int projectId;
    @Column(name = "takenAt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date takenAt;
    @Size(max = 64)
    @Column(name = "filename", length = 64)
    private String filename;
    @Column(name = "successfull")
    private Boolean successfull;

    public Exposure() {
    }

    public Exposure(Integer exposureId) {
        this.exposureId = exposureId;
    }

    public Exposure(Integer exposureId, int projectId) {
        this.exposureId = exposureId;
        this.projectId = projectId;
    }

    public Integer getExposureId() {
        return exposureId;
    }

    public void setExposureId(Integer exposureId) {
        this.exposureId = exposureId;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public Date getTakenAt() {
        return takenAt;
    }

    public void setTakenAt(Date takenAt) {
        this.takenAt = takenAt;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Boolean getSuccessfull() {
        return successfull;
    }

    public void setSuccessfull(Boolean successfull) {
        this.successfull = successfull;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (exposureId != null ? exposureId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Exposure)) {
            return false;
        }
        Exposure other = (Exposure) object;
        if ((this.exposureId == null && other.exposureId != null) ||
                (this.exposureId != null && !this.exposureId.equals(other.exposureId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ch.helmchen.camlapse.capture.entities.Exposure[ exposureId=" + exposureId + " ]";
    }

}

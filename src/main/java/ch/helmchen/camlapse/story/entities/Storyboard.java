/*
 * File: Storyboard.java, created at 06.04.2012
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
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @todo Klasse Storyboard dokumentieren.
 * <p/>
 * @author Helmut Gehrer <helmut.gehrer@helmchen.ch>
 * @since 06.04.2012
 */
@Entity
@Table (name = "Storyboard")
@XmlRootElement
@NamedQueries ({
    @NamedQuery (name = Storyboard.QUERY_FIND_ALL,
                 query = "SELECT p FROM Storyboard p"),
    @NamedQuery (name = Storyboard.QUERY_FIND_BY_STORYBOARD_ID,
                 query = "SELECT p FROM Storyboard p WHERE p.storyboardId = :" + Storyboard.PARAM_PROJECT_ID),
    @NamedQuery (name = Storyboard.QUERY_FIND_BY_NAME,
                 query = "SELECT p FROM Storyboard p WHERE p.name = :" + Storyboard.PARAM_NAME),
    @NamedQuery (name = Storyboard.QUERY_FIND_BY_OWNER,
                 query = "SELECT p FROM Storyboard p WHERE p.ownerFk = :" + Storyboard.PARAM_OWNER),
    @NamedQuery (name = "Storyboard.findByWebcamFk",
                 query = "SELECT p FROM Storyboard p WHERE p.webcamFk = :webcamFk")
})
public class Storyboard implements Serializable {
    public static final String QUERY_FIND_ALL = Storyboard.BEAN_PREFIX + "findAll";
    public static final String QUERY_FIND_BY_STORYBOARD_ID = Storyboard.BEAN_PREFIX + "findByStoryboardId";
    public static final String QUERY_FIND_BY_NAME = Storyboard.BEAN_PREFIX + "findByName";
    public static final String QUERY_FIND_BY_OWNER = Storyboard.BEAN_PREFIX + "findByOwner";
    
    public static final String PARAM_PROJECT_ID = "aStoryboardId";
    public static final String PARAM_NAME = "aName";
    public static final String PARAM_OWNER = "anOwnerFk";
    
    private static final String BEAN_PREFIX = "ch.helmchen.camlapse.story.entities.Storyboard.";
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Basic (optional = false)
    @NotNull
    @Column (name = "storyboardId", nullable = false)
    private Integer storyboardId;
    @Basic (optional = false)
    @NotNull
    @Size (min = 1, max = 240)
    @Column (name = "name", nullable = false, length = 240)
    private String name;
    @Basic (optional = false)
    @NotNull
    @Column (name = "createdAt", nullable = false)
    @Temporal (TemporalType.TIMESTAMP)
    private Date createdAt;
    @Basic (optional = false)
    @NotNull
    @Column (name = "captureBegin", nullable = false)
    @Temporal (TemporalType.TIMESTAMP)
    private Date captureBegin;
    @Basic (optional = false)
    @NotNull
    @Column (name = "captureEnd", nullable = false)
    @Temporal (TemporalType.TIMESTAMP)
    private Date captureEnd;
    @Basic (optional = false)
    @NotNull
    @Column (name = "captureInterval", nullable = false)
    private int captureInterval;
    @Column (name = "ownerFk")
    private Integer ownerFk;
    @Basic (optional = false)
    @NotNull
    @Column (name = "webcamFk", nullable = false)
    private int webcamFk;
    @Basic (optional = false)
    @NotNull
    @Size (min = 1, max = 64)
    @Column (name = "pathName", nullable = false, length = 64)
    private String pathName;

    public Storyboard() {
    }

    public Storyboard(Integer projectId) {
        this.storyboardId = projectId;
    }

    public Storyboard(Integer projectId, String name, Date captureBegin, Date captureEnd, int captureInterval,
            int webcamFk,
            String pathName) {
        this.storyboardId = projectId;
        this.name = name;
        this.captureBegin = captureBegin;
        this.captureEnd = captureEnd;
        this.captureInterval = captureInterval;
        this.webcamFk = webcamFk;
        this.pathName = pathName;
    }

    public Integer getStoryboardId() {
        return storyboardId;
    }

    public void setStoryboardId(Integer projectId) {
        this.storyboardId = projectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getCaptureBegin() {
        return captureBegin;
    }

    public void setCaptureBegin(Date captureBegin) {
        this.captureBegin = captureBegin;
    }

    public Date getCaptureEnd() {
        return captureEnd;
    }

    public void setCaptureEnd(Date captureEnd) {
        this.captureEnd = captureEnd;
    }

    public int getCaptureInterval() {
        return captureInterval;
    }

    public void setCaptureInterval(int captureInterval) {
        this.captureInterval = captureInterval;
    }

    public Integer getOwnerFk() {
        return ownerFk;
    }

    public void setOwnerFk(Integer ownerFk) {
        this.ownerFk = ownerFk;
    }

    public int getWebcamFk() {
        return webcamFk;
    }

    public void setWebcamFk(int webcamFk) {
        this.webcamFk = webcamFk;
    }

    public String getPathName() {
        return pathName;
    }

    public void setPathName(String pathName) {
        this.pathName = pathName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (storyboardId != null ? storyboardId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Storyboard)) {
            return false;
        }
        Storyboard other = (Storyboard) object;
        if ((this.storyboardId == null && other.storyboardId != null) || (this.storyboardId != null
                && !this.storyboardId.equals(other.storyboardId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ch.helmchen.camlapse.capture.entities.Storyboard[ projectId=" + storyboardId + " ]";
    }
}

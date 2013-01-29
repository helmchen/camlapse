/*
 * File: Webcam.java, created at 06.04.2012
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
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
/**
 * @todo Klasse Webcam dokumentieren.
 *
 * @author Helmut Gehrer <helmut.gehrer@helmchen.ch>
 * @since  06.04.2012
 */
@Entity
@Table(name = "Webcam")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Webcam.findAll", query = "SELECT w FROM Webcam w"),
    @NamedQuery(name = "Webcam.findByWebcamId", query = "SELECT w FROM Webcam w WHERE w.webcamId = :webcamId"),
    @NamedQuery(name = "Webcam.findByName", query = "SELECT w FROM Webcam w WHERE w.name = :name"),
    @NamedQuery(name = "Webcam.findByHomepageUrl", query =
    "SELECT w FROM Webcam w WHERE w.homepageUrl = :homepageUrl"),
    @NamedQuery(name = "Webcam.findByImageUrl", query = "SELECT w FROM Webcam w WHERE w.imageUrl = :imageUrl"),
    @NamedQuery(name = "Webcam.findByLongitude", query = "SELECT w FROM Webcam w WHERE w.longitude = :longitude"),
    @NamedQuery(name = "Webcam.findByLatitude", query = "SELECT w FROM Webcam w WHERE w.latitude = :latitude")})
public class Webcam implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "webcamId", nullable = false)
    private Integer webcamId;
    @Size(max = 240)
    @Column(name = "name", length = 240)
    private String name;
    @Size(max = 240)
    @Column(name = "homepageUrl", length = 240)
    private String homepageUrl;
    @Size(max = 240)
    @Column(name = "imageUrl", length = 240)
    private String imageUrl;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "longitude", precision = 22)
    private Double longitude;
    @Column(name = "latitude", precision = 22)
    private Double latitude;

    public Webcam() {
    }

    public Webcam(Integer webcamId) {
        this.webcamId = webcamId;
    }

    public Integer getWebcamId() {
        return webcamId;
    }

    public void setWebcamId(Integer webcamId) {
        this.webcamId = webcamId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHomepageUrl() {
        return homepageUrl;
    }

    public void setHomepageUrl(String homepageUrl) {
        this.homepageUrl = homepageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (webcamId != null ? webcamId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Webcam)) {
            return false;
        }
        Webcam other = (Webcam) object;
        if ((this.webcamId == null && other.webcamId != null) ||
                (this.webcamId != null && !this.webcamId.equals(other.webcamId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ch.helmchen.camlapse.capture.entities.Webcam[ webcamId=" + webcamId + " ]";
    }

}
// EOF

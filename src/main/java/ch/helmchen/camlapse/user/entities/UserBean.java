/*
 * File: UserBean.java, created at 06.04.2012
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

package ch.helmchen.camlapse.user.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
/**
 * @todo Klasse UserBean dokumentieren.
 *
 * @author Helmut Gehrer <helmut.gehrer@helmchen.ch>
 * @since  06.04.2012
 */
@Entity
@Table(name = "User")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserBean.findAll", query = "SELECT u FROM UserBean u"),
    @NamedQuery(name = "UserBean.findByUserId", query = "SELECT u FROM UserBean u WHERE u.userId = :userId"),
    @NamedQuery(name = "UserBean.findByLoginName", query = "SELECT u FROM UserBean u WHERE u.loginName = :loginName"),
    @NamedQuery(name = "UserBean.findByEmailAddress", query =
    "SELECT u FROM UserBean u WHERE u.emailAddress = :emailAddress")})
public class UserBean implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "userId", nullable = false)
    private Integer userId;
    @Size(max = 250)
    @Column(name = "loginName", length = 250)
    private String loginName;
    @Size(max = 240)
    @Column(name = "emailAddress", length = 240)
    private String emailAddress;

    public UserBean() {
    }

    public UserBean(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserBean)) {
            return false;
        }
        UserBean other = (UserBean) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ch.helmchen.camlapse.user.entities.UserBean[ userId=" + userId + " ]";
    }

}

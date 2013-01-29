/*
 * File: MultiLingualDescription.java, created at 01.01.2013
 * $Id$
 * Copyright 2013 Helmut Gehrer <helmut.gehrer@helmchen.ch>
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

import java.util.Locale;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Size;

/**
 * @todo Klasse MultiLingualDescription dokumentieren.
 * <p/>
 * @author Helmut Gehrer <helmut.gehrer@helmchen.ch>
 * @since 01.01.2013
 */
@Embeddable
public class MultiLingualDescription {
    @Size(max = 64)
    @Column(name = "description", length = 64)
    private String standard;
    @Size(max = 64)
    @Column(name = "description_en", length = 64)
    private String english;
    @Size(max = 64)
    @Column(name = "description_de", length = 64)
    private String german;
    @Size(max = 64)
    @Column(name = "description_fr", length = 64)
    private String french;
    @Size(max = 64)
    @Column(name = "description_it", length = 64)
    private String italian;

    public String get(Locale locale) {
        String language = locale.getLanguage();
        switch (language) {
        case "de":
            return getGerman();
        case "en":
            return getEnglish();
        case "fr":
            return getFrench();
        case "it":
            return getItalian();
        default:
            return getStandard();
        }
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public String getGerman() {
        return german;
    }

    public void setGerman(String german) {
        this.german = german;
    }

    public String getFrench() {
        return french;
    }

    public void setFrench(String french) {
        this.french = french;
    }

    public String getItalian() {
        return italian;
    }

    public void setItalian(String italian) {
        this.italian = italian;
    }
}

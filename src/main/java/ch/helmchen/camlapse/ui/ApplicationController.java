/*
 * File: ApplicationController.java, created at 17.05.2012
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
package ch.helmchen.camlapse.ui;

import ch.helmchen.camlapse.MetaInfo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import javax.annotation.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Helmut Gehrer <helmut.gehrer@helmchen.ch>
 */
@Named("applicationController")
@ApplicationScoped
public class ApplicationController {
    /**
     * Creates a new instance of ApplicationController
     */
    public ApplicationController() {
        Logger logger = LoggerFactory.getLogger(ApplicationController.class);
        for (String splashLine : MetaInfo.getSplashScreen()) {
            logger.info(splashLine);
        }
        logger.info(MetaInfo.buildMessage(MetaInfo.SYSTEM, "beanLoaded", ApplicationController.class.getSimpleName()));
    }

    /**
     * Liefert eine Liste aller unterstützten Sprachen zurück. Diese wird anhand der Konfiguration in der
     * Faces-Konfig-Datei ermittelt.
     * <p/>
     * @return
     */
    public List<Locale> getSupportedLanguages() {
        List<Locale> result = new ArrayList<Locale>();
        FacesContext context = FacesContext.getCurrentInstance();
        if (context != null) {
            Iterator<Locale> locales = context.getApplication().getSupportedLocales();
            while (locales.hasNext()) {
                result.add(locales.next());
            }
        } else {
            LoggerFactory.getLogger(ApplicationController.class).warn(
                    MetaInfo.buildMessage(MetaInfo.SYSTEM, "missingFacesContext", "getSupportedLanguages()"));
            result.add(Locale.ENGLISH);
        }
        return result;
    }

    public static ApplicationController getInstance() {
        return findBean("applicationController");
    }
    /**
     * Liefert eine Managed-Bean zum aktuellen Kontext zurück.
     * <p/>
     * @param <T>      Gewünschter Typ
     * @param beanName Name der Bean
     * @return Bean zum aktuellen Context oder <tt>null</tt>, falls nichts gefunden wird.
     */
    @SuppressWarnings ("unchecked")
    public static <T> T findBean(String beanName) {
        FacesContext context = FacesContext.getCurrentInstance();
        if (context == null || context.getApplication() == null) {
            LoggerFactory.getLogger(ApplicationController.class).warn(
                    MetaInfo.buildMessage(MetaInfo.SYSTEM, "missingFacesContext", "findBean(" + beanName + ")"));
            return null;
        }
        return (T) context.getApplication().evaluateExpressionGet(context, "#{" + beanName + "}", Object.class);
    }
}

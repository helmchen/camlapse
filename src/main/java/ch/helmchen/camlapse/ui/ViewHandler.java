/*
 * File: ViewHandler.java, created at 01.01.2013
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

package ch.helmchen.camlapse.ui;

import java.util.Locale;

import javax.faces.application.ViewHandlerWrapper;
import javax.faces.context.FacesContext;
/**
 * @todo Klasse ViewHandler dokumentieren.
 *
 * @author Helmut Gehrer <helmut.gehrer@helmchen.ch>
 * @since  01.01.2013
 */
public abstract class ViewHandler extends ViewHandlerWrapper {

    @Override
    public Locale calculateLocale(FacesContext context) {
        // Default-Sprache aus JSF übernehmen
        Locale result = super.calculateLocale(context);
        // Wird diese in der Session überschrieben?
        SessionController session = ApplicationController.findBean(SessionController.BEAN_NAME);
        if (session != null && session.getLocale() != null) {
            result = session.getLocale();
        }
        return result;
    }
}

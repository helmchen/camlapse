/*
 * File: SessionController.java, created at 01.01.2013
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

import ch.helmchen.camlapse.story.boundary.StoryboardService;
import ch.helmchen.camlapse.story.boundary.StoryboardSort;
import ch.helmchen.camlapse.story.entities.Storyboard;
import ch.helmchen.camlapse.user.boundary.UserService;

import java.util.List;
import java.util.Locale;
import javax.ejb.EJB;
import javax.inject.Named;

/**
 * @todo Klasse SessionController dokumentieren.
 * <p/>
 * @author Helmut Gehrer <helmut.gehrer@helmchen.ch>
 * @since 01.01.2013
 */
@Named (value = SessionController.BEAN_NAME)
public class SessionController {
    public static final String BEAN_NAME = "sessionController";
    @EJB
    private UserService userService;
    @EJB
    private StoryboardService storyboardService;
    private Locale locale;
    private StoryboardSort storyboardSortOrder;

    public boolean isAnonymious() {
        return true;
    }

    public boolean login() {
        return true;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public StoryboardSort getStoryboardSortOrder() {
        return storyboardSortOrder;
    }

    public void setStoryboardSortOrder(StoryboardSort storyboardSortOrder) {
        this.storyboardSortOrder = storyboardSortOrder;
    }

    public List<Storyboard> getStoryboards() {
        return null;
    }
}

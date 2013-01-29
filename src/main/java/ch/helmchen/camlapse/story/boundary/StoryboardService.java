/*
 * File: StoryboardService.java, created at 30.03.2012
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
package ch.helmchen.camlapse.story.boundary;

import ch.helmchen.camlapse.story.entities.Storyboard;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author Helmut Gehrer <helmut.gehrer@helmchen.ch>
 */
@Stateless
@LocalBean
public class StoryboardService {
    public void register(Storyboard aWebcam) {
    }
    public void update(Storyboard aWebcam) {
    }

    public void remove(Storyboard aWebcam) {
    }
 
    public Storyboard getMetadata(String aWebcamId) {
        return null;
    }

    public Storyboard getData(String aWebcamId) {
        return null;
    }
    
    
}

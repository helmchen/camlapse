/*
 * File: StoryboardSort.java, created at 01.01.2013
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
package ch.helmchen.camlapse.story.boundary;

/**
 * Die Sortierung des Storyboards in der Anzeige. Dient der Defintion von Sortierkriterien für die Anzeige.
 * @author Helmut Gehrer <helmut.gehrer@helmchen.ch>
 */
public enum StoryboardSort {
    /** 
     * Nach Datum.
     */ 
    DATE,
    /**
     * Nach Anzahl Detailanzeigen.
     */
    VIEWS, 
    /**
     * Nach dem Rating der User.
     */
    RATING
}

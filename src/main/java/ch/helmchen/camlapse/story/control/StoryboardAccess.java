/*
 * File: StoryboardAccess.java, created at 27.04.2012
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

package ch.helmchen.camlapse.story.control;

import ch.helmchen.camlapse.story.entities.Storyboard;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import static ch.helmchen.camlapse.story.entities.Storyboard.*;
/**
 * @todo Klasse StoryboardAccess dokumentieren.
 *
 * @author Helmut Gehrer <helmut.gehrer@helmchen.ch>
 * @since  27.04.2012
 */
@Stateless
public class StoryboardAccess extends AbstractAccess<Storyboard> {
    @PersistenceContext (unitName = "ch.helmchen_camlapse_war_1.0.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public StoryboardAccess() {
        super(Storyboard.class);
    }
    
    public Storyboard findById(Integer anId) {
        Query query = em.createNamedQuery(QUERY_FIND_BY_STORYBOARD_ID);
        query.setParameter(PARAM_PROJECT_ID, anId);
        return (Storyboard) query.getSingleResult();
    }

}

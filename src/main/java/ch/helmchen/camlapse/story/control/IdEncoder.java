/*
 * File: IdEncoder.java, created at 06.04.2012
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

/**
 * This Utility is used to en- and decode Id's of the database. While the ID on the database is stored
 * as long, the external represenation is in a shorter form. To shorten the value a base36-Endocing
 * will be used. This encoding is based on hexadecimal notation and consists of the values in the
 * range of 0-9 and a-z. so, for instance 10 will be encoded as 'a', 10'000 as '7ps'.
 *
 * @see http://en.wikipedia.org/wiki/Base_36
 *
 * @author Helmut Gehrer <helmut.gehrer@helmchen.ch>
 */
public class IdEncoder {

    /**
     * the encoding base. 
     */
    public static int ENCODING_BASE = 36;

    /**
     * Encodes the DatabaseId into the shorter external Id.
     * @param aDbId Datenbank-Id
     * @return Base-32-encodierter Wert.
     * @throws IllegalArgumentException
     */
    public static String encode(long aDbId) throws IllegalArgumentException {
        if (aDbId < 0) {
            throw new IllegalArgumentException("long value < 0 is not allowed.");
        }
        return Long.toString(aDbId, ENCODING_BASE).toLowerCase();
    }

    /**
     * Decodes the external Id to Database Id.
     * @param anExternalId
     * @return
     * @throws IllegalArgumentException
     */
    public static long decode(String anExternalId) throws IllegalArgumentException {
        if (anExternalId == null) {
            throw new IllegalArgumentException("Id to decode cant be null");
        }
        return Long.parseLong(anExternalId.toUpperCase(), ENCODING_BASE);
    }
}

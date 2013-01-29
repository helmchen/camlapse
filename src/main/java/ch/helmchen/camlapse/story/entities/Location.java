/*
 * File: Location.java, created at 06.04.2012
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

/**
 * @todo Klasse Location dokumentieren.
 *
 * @author Helmut Gehrer <helmut.gehrer@helmchen.ch>
 * @since  06.04.2012
 */
public class Location {
    
    private double longitude;
    private double latitude;

    public Location(double aLongitude, double aLatitude) {
       longitude = aLongitude;
        latitude = aLatitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double aLatitude) {
        latitude = aLatitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double aLongitude) {
        longitude = aLongitude;
    }
    

}
// EOF

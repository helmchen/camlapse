/*
 * File: MetaInfo.java, created at 30.03.2012
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
package ch.helmchen.camlapse;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

/**
 * @todo Klasse MetaInfo dokumentieren.
 *
 * @author Helmut Gehrer <helmut.gehrer@helmchen.ch>
 * @since 30.03.2012
 */
public class MetaInfo {
    public static final Marker SYSTEM = MarkerFactory.getMarker("SYSTEM");
    public static final Marker SECURITY = MarkerFactory.getMarker("SECURITY");
    public static final Marker TEST = MarkerFactory.getMarker("TEST");
    private static final String MESSAGE_BUNDLE_PATH = "ch/helmchen/camlapse/Messages";
    private static ResourceBundle DEFAULT_MESSAGE_BUNDLE;
    private static Locale locale;

    static {
        DEFAULT_MESSAGE_BUNDLE = ResourceBundle.getBundle(MESSAGE_BUNDLE_PATH);
        locale = Locale.getDefault();
    }

    public static void setLocale(Locale aLocale) {
        if (aLocale==null) {
            throw new IllegalArgumentException("null is not an allowed argument for setLocale");
        }
        locale = aLocale;
        // Default Resource-Bundle in der gewünschten Sprache neu laden.
        DEFAULT_MESSAGE_BUNDLE = getBundle(locale);
    }

    public static String buildMessage(final Marker aMsgType, final String aMsgKey) {
        return buildMessage(DEFAULT_MESSAGE_BUNDLE, aMsgType, aMsgKey, null);
    }

    public static String buildMessage(final Marker aMsgType, final String aMsgKey, final Object... someParams) {
        return buildMessage(DEFAULT_MESSAGE_BUNDLE, aMsgType, aMsgKey, someParams);
    }

    public static String buildMessage(final Locale aLocale, final Marker aMsgType, final String aMsgKey) {
        return buildMessage(getBundle(aLocale), aMsgType, aMsgKey, null);
    }

    public static String buildMessage(final Locale aLocale, final Marker aMsgType, final String aMsgKey,
            final Object... someParams) {
        return buildMessage(getBundle(aLocale), aMsgType, aMsgKey, someParams);
    }

    public static List<String> getSplashScreen() {
        List<String> result = new ArrayList<String>();
        result.add(buildMessage(SYSTEM, "splashDelim"));
        result.add(buildMessage(SYSTEM, "splashEmpty"));
        for (int i = 0; i < 10; i++) {
            result.add(buildMessage(SYSTEM, "splash" + i));
        }
        result.add(buildMessage(SYSTEM, "splashEmpty"));
        result.add(buildMessage(SYSTEM, "copyright"));
        result.add(buildMessage(SYSTEM, "license"));
        result.add(buildMessage(SYSTEM, "licenseUrl"));
        result.add(buildMessage(SYSTEM, "splashEmpty"));
        result.add(buildMessage(SYSTEM, "splashDelim"));

        return result;
    }

    private static String buildMessage(final ResourceBundle aBundle, final Marker aMsgType, final String aMsgKey,
            final Object... someParams) {
        String strMessage = aBundle.getString(aMsgType.getName() + "." + aMsgKey);
        if (someParams == null) {
            return strMessage;
        }
        MessageFormat template = new MessageFormat(strMessage);
        return template.format(someParams);
    }

    private static ResourceBundle getBundle(Locale aLocale) {
        return ResourceBundle.getBundle(MESSAGE_BUNDLE_PATH, aLocale);
    }
}

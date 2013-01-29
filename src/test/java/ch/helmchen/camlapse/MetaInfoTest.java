/*
 * File: MetaInfoTest.java, created at 06.04.2012
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

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.junit.*;
import static org.junit.Assert.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Helmut Gehrer <helmut.gehrer@helmchen.ch>
 */
public class MetaInfoTest {
    private static final Logger logger;
    private static final String TESTKEY = "language";
    private static final String TESTKEY_VARARGS = "vararg";

    static {
        logger = LoggerFactory.getLogger(MetaInfoTest.class);
    }

    public MetaInfoTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getSplashScreen method, of class MetaInfo.
     */
    @Test
    public void testGetSplashScreen() {
        logger.info(MetaInfo.TEST, "testGetSplashScreen");
        List<String> result = MetaInfo.getSplashScreen();
        for (String line : result) {
            logger.info(line);
        }
        assertEquals(18, result.size());
    }

    /**
     * Test of setLocale method, of class MetaInfo.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetLocaleNull() {
        logger.info(MetaInfo.TEST, "testSetLocaleNull");
        Locale aLocale = null;
        MetaInfo.setLocale(null);
    }

    /**
     * Test of setLocale method, of class MetaInfo.
     */
    @Test
    public void testSetLocale() {
        logger.info(MetaInfo.TEST, "testSetLocale");
        MetaInfo.setLocale(Locale.GERMAN);
        String strLanguage = MetaInfo.buildMessage(MetaInfo.TEST, TESTKEY);
        assertEquals("deutsch", strLanguage);
        MetaInfo.setLocale(Locale.FRENCH);
        strLanguage = MetaInfo.buildMessage(MetaInfo.TEST, TESTKEY);
        assertEquals("français", strLanguage);
        MetaInfo.setLocale(Locale.ENGLISH);
        strLanguage = MetaInfo.buildMessage(MetaInfo.TEST, TESTKEY);
        assertEquals("english", strLanguage);
    }

    /**
     * Test of buildMessage method, of class MetaInfo.
     */
    @Test
    public void testBuildDefaultMessage() {
        logger.info(MetaInfo.TEST, "testBuildDefaultMessage");
        MetaInfo.setLocale(Locale.GERMAN);
        String result = MetaInfo.buildMessage(MetaInfo.TEST, TESTKEY);
        assertEquals("deutsch", result);
    }

    /**
     * Test of buildMessage method, of class MetaInfo.
     */
    @Test
    public void testBuildDefaultLocalizedMessage() {
        logger.info(MetaInfo.TEST, "testBuildDefaultLocalizedMessage");
        String result = MetaInfo.buildMessage(Locale.FRENCH, MetaInfo.TEST, TESTKEY);
        assertEquals("français", result);
    }

    /**
     * Test of buildMessage method, of class MetaInfo.
     */
    @Test
    public void testBuildDefaultMessageWithArguments() {
        logger.info(MetaInfo.TEST, "testBuildDefaultMessageWithArguments");
        MetaInfo.setLocale(Locale.GERMAN);
        Date now = Calendar.getInstance().getTime();
        DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.GERMAN);
        String result = MetaInfo.buildMessage(MetaInfo.TEST, TESTKEY_VARARGS, "deutsch", now);
        logger.debug(MetaInfo.TEST, result);
        assertEquals("Dieser Test in deutsch wurde am " + df.format(now) + " ausgeführt.", result);
    }

    /**
     * Test of buildMessage method, of class MetaInfo.
     */
    @Test
    public void testBuildDefaultLocalizedMessageWithArguments() {
        logger.info(MetaInfo.TEST, "testBuildDefaultLocalizedMessageWithArguments");
        Date now = Calendar.getInstance().getTime();
        DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT); // ???, Locale.FRENCH);
        String result = MetaInfo.buildMessage(Locale.FRENCH, MetaInfo.TEST, TESTKEY_VARARGS, "français", now);
        logger.debug(MetaInfo.TEST, result);
        assertEquals("En français la teste à été examine à " + df.format(now) + ".", result);
    }
}

/*
 * File: AuthenticatorTest.java, created at 06.04.2012
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
package ch.helmchen.camlapse.user.control;

import ch.helmchen.camlapse.MetaInfo;
import java.net.URL;
import org.junit.*;
import static org.junit.Assert.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Helmut Gehrer <helmut.gehrer@helmchen.ch>
 */
public class AuthenticatorTest {
    private static Logger logger;
    private static Authenticator testee;

    static {
        logger = LoggerFactory.getLogger(AuthenticatorTest.class);
    }

    public AuthenticatorTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        if (testee == null) {
            logger.info(MetaInfo.TEST, "Setting up test.");
            testee = new Authenticator("L76KsFkIx6GmIsCCRBUmg", "1wqPmvCxvHE0KCVrguh2m1Ta5TaEFMMPEyT1B6g962Q");
        }
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getAuthenticationUrl method, of class Authenticator.
     */
    @Test
    public void testGetAuthenticationUrl() throws Exception {
        logger.info(MetaInfo.TEST, "testGetAuthenticationUrl");
        URL expResult = new URL("https://api.twitter.com/oauth/authorize");
        URL result = testee.getAuthenticationUrl();
        logger.info(MetaInfo.TEST, "Authentication URL is " + result);
        assertEquals(expResult.getProtocol(), result.getProtocol());
        assertEquals(expResult.getHost(), result.getHost());
        assertEquals(expResult.getPath(), result.getPath());
    }

    /**
     * Test of verifyAuthentication method, of class Authenticator.
     */
   // @Test
    public void testVerifyAuthentication() {
        logger.info(MetaInfo.TEST, "testVerifyAuthentication");
        String aToken = "67413792-t35Wpboi6wkCLZle3vc9lzEy6ZS3H9ETc1w1SBwpP";
        boolean expResult = true;
        //boolean result = testee.verifyAuthentication(aToken);
        //assertEquals(expResult, result);
    }
}

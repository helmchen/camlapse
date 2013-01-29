/*
 * File: EncryptionTest.java, created at 06.04.2012
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
import org.junit.*;
import static org.junit.Assert.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Helmut Gehrer <helmut.gehrer@helmchen.ch>
 */
public class EncryptionTest {
    private static Logger logger;
    private static final String ORIGINAL = "Dies hier ist geheim";
    private static final String ENCRYPTED = "St7iubWrENJNHZCULQNkc+1NwuBwUtiX";

    public EncryptionTest() {
    }

    static {
        logger = LoggerFactory.getLogger(EncryptionTest.class);
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
     * Test of encrypt method, of class Encryption.
     */
    @Test
    public void testEncrypt() throws Exception {
        logger.info(MetaInfo.TEST, "testEncrypt");
        assertEquals(ENCRYPTED, Encryption.encrypt(ORIGINAL));
    }

    /**
     * Test of decrypt method, of class Encryption.
     */
    @Test
    public void testDecrypt() throws Exception {
        logger.info(MetaInfo.TEST, "testDecrypt");
        assertEquals(ORIGINAL, Encryption.decrypt(ENCRYPTED));
    }

    /**
     * Test of decrypt method, of class Encryption.
     */
    @Test
    public void testBidirektional() throws Exception {
        logger.info(MetaInfo.TEST, "testDecrypt");
        String testString="helmut.gehrer@helmchen.ch";
        String strEncrypted = Encryption.encrypt(testString);
        assertEquals(testString, Encryption.decrypt(strEncrypted));
    }
}

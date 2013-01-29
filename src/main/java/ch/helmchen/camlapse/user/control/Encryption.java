/*
 * File: Encryption.java, created at 06.04.2012
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


import java.io.IOException;
import java.security.GeneralSecurityException;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import org.apache.commons.codec.binary.Base64;


/**
 * Diese Klasse behandelt das symetrische Verschlüsseln von String..
 *
 * @author Helmut Gehrer <helmut.gehrer@helmchen.ch>
 * @since  06.04.2012
 */
public class Encryption {

    private static final char[] PASSWORD = "dadids5bnlsnk!lksdugz".toCharArray();
    private static final byte[] SALT = {
        (byte) 0xde, (byte) 0x33, (byte) 0x10, (byte) 0x12,
        (byte) 0xde, (byte) 0x33, (byte) 0x10, (byte) 0x12,
    };

/**
 * Verschlüsselt den übergebenen String.
 * 
 * @param aString zu verschlüsselnder String.
 */
  public static String encrypt(final String aString) throws GeneralSecurityException {
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBEWithMD5AndDES");
        SecretKey key = keyFactory.generateSecret(new PBEKeySpec(PASSWORD));
        Cipher pbeCipher = Cipher.getInstance("PBEWithMD5AndDES");
        pbeCipher.init(Cipher.ENCRYPT_MODE, key, new PBEParameterSpec(SALT, 20));
        return base64Encode(pbeCipher.doFinal(aString.getBytes()));
    }

    private static String base64Encode(byte[] bytes) {
       return new String(Base64.encodeBase64(bytes));
    }

    public static String decrypt(String aBase64String) throws GeneralSecurityException, IOException {
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBEWithMD5AndDES");
        SecretKey key = keyFactory.generateSecret(new PBEKeySpec(PASSWORD));
        Cipher pbeCipher = Cipher.getInstance("PBEWithMD5AndDES");
        pbeCipher.init(Cipher.DECRYPT_MODE, key, new PBEParameterSpec(SALT, 20));
        return new String(pbeCipher.doFinal(base64Decode(aBase64String)));
    }

    private static byte[] base64Decode(String property) throws IOException {
        return Base64.decodeBase64(property);
    }
}

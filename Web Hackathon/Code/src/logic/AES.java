/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;


import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

import sun.misc.*;

/**
 *
 * @author Admin
 */
public class AES {


     private static final String ALGO = "AES";
    private static final byte[] keyValue = 
        new byte[] { 'T', 'h', 'e', 'B', 'e', 's', 't',
'S', 'e', 'c', 'r','e', 't', 'K', 'e', 'y' };

public static String encrypt(String Data)  {
        
        String encryptedValue="";
        Cipher c;
		try {
			Key key = generateKey();
			c = Cipher.getInstance(ALGO);
			c.init(Cipher.ENCRYPT_MODE, key);
		    byte[] encVal = c.doFinal(Data.getBytes());
		    encryptedValue = new String(Base64.encodeBase64(encVal));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
        return encryptedValue;
    }

    public static String decrypt(String encryptedData) throws Exception {
        Key key = generateKey();
        Cipher c = Cipher.getInstance(ALGO);
        c.init(Cipher.DECRYPT_MODE, key);
        byte[] decordedValue = Base64.decodeBase64(encryptedData);
        byte[] decValue = c.doFinal(decordedValue);
        String decryptedValue = new String(decValue);
        return decryptedValue;
    }
    private static Key generateKey() throws Exception {
        Key key = new SecretKeySpec(keyValue, ALGO);
        return key;
}
    
    public static void main(String args[])
    {
         try {
             String uuid = UUID.randomUUID().toString();
             System.out.println("uuid = " + uuid);
             long curr = System.currentTimeMillis();
             String s = encrypt(uuid);
             System.out.println(s+" "+(System.currentTimeMillis()-curr));
         } catch (Exception ex) {
             Logger.getLogger(AES.class.getName()).log(Level.SEVERE, null, ex);
         }
        
        
    }
    

}


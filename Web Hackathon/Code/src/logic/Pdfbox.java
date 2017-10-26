/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.awt.Desktop;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.AccessPermission;
import org.apache.pdfbox.pdmodel.encryption.StandardProtectionPolicy;


/**
 *
 * @author Admin
 */
public class Pdfbox {

    /**
     * @param args the command line arguments
     */
    
    public static String encrypt()
    {
    	String viewp="";
        try {
           
            Desktop des = Desktop.getDesktop();
            File file =new File("M:\\Career\\Internships\\Wooqer\\wooqer_idea.pdf");
            PDDocument doc = PDDocument.load(file);
            int keyLength = 128;
            String editp = "fbi007";
             viewp = RandomStringUtils.randomAlphanumeric(8);
            AccessPermission ap = new AccessPermission();
            ap.setCanModify(false);
            StandardProtectionPolicy spp = new StandardProtectionPolicy(editp, viewp, ap);
            spp.setEncryptionKeyLength(keyLength);
            spp.setPermissions(ap);
            doc.protect(spp);
            
            doc.save(file.getName());
            doc.close();
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Pdfbox.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Pdfbox.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return viewp;
    }
    
}

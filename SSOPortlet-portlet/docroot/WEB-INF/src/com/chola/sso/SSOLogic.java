package com.chola.sso;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import org.bouncycastle.crypto.engines.RijndaelEngine;
import org.bouncycastle.crypto.modes.CBCBlockCipher;
import org.bouncycastle.crypto.paddings.PKCS7Padding;
import org.bouncycastle.crypto.paddings.PaddedBufferedBlockCipher;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

public class SSOLogic extends MVCPortlet {
	private static Log logger = LogFactoryUtil.getLog(SSOLogic.class);
	public String encryptPeoplePower(String plaintext)
	{
		String data="";
		
		try
		{
			 byte[] sessionKey = "asfuyjkdhfcholae".getBytes("UTF-8"); 
   		 	 byte[] iv = "42309842389462374623784692423642".getBytes("UTF-8");
		 	
		 	logger.info("Emp ID for SSO : "+plaintext);
		 	
			byte [] dataBytes = plaintext.getBytes();

		 	PaddedBufferedBlockCipher cipher = new PaddedBufferedBlockCipher(
		 	    new CBCBlockCipher(new RijndaelEngine(256)), new PKCS7Padding());
		 	cipher.init(true, new ParametersWithIV(new KeyParameter(sessionKey), iv));
		 	
		 	byte[] encrypted  = new byte[cipher.getOutputSize(dataBytes.length)];
			int oLen = cipher.processBytes(dataBytes, 0, dataBytes.length, encrypted, 16);
			cipher.doFinal(encrypted, oLen);   
			data = Base64.getEncoder().encodeToString(encrypted);
		 	
		} catch (Exception e) {
		   logger.error("Error",e);
		  }
		return data; 
	}
	
	public static String encryptMediassist(String PLAIN_TEXT) {
		
        String encryptedData = "";
        try {
        	 String Key = "0070070072017018";
             String iV = "MediBuddy2017/18";
            String EmployeeCode = PLAIN_TEXT;
            byte[] keyByte=Key.getBytes();
            SecretKey key = new SecretKeySpec(keyByte, "AES");
            IvParameterSpec iv = new IvParameterSpec(iV.getBytes());
 
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, key, iv);
            byte[] encoded = cipher.doFinal(EmployeeCode.getBytes());
            encryptedData = DatatypeConverter.printBase64Binary(encoded);
            //logger.info("encryptedData:" + encryptedData);
 
        } catch (Exception ex) {
 
            logger.info("Exception Ex:" ,ex);
        }
        return encryptedData.replace("+","_");
    }

	
}

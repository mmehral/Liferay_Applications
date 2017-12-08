package com.ssologic;

import org.bouncycastle.crypto.engines.RijndaelEngine;
import org.bouncycastle.crypto.modes.CBCBlockCipher;
import org.bouncycastle.crypto.paddings.PKCS7Padding;
import org.bouncycastle.crypto.paddings.PaddedBufferedBlockCipher;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import java.util.Base64;

public class SSOLogic {
	private static Log logger = LogFactoryUtil.getLog(SSOLogic.class);
	
	public static String encryptPeoplePower(String plaintext)
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
	
}

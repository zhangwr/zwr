/*
 * @Copyright:  银联商务有限公司  Copyright 2016, All rights reserved
 */
package com.monitor.test.sign;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import com.monitor.test.sign.utils.Base64Utils;

/*
 * @author:  lzli
 * @description: POS通插件签名验签样例
 */
public class QppSignService {
	
	
	public static String sign(byte[] data, String privateKey) throws Exception {
    	byte[] keyBytes = Base64Utils.decode(privateKey);
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PrivateKey privateK = keyFactory.generatePrivate(pkcs8KeySpec);
        Signature signature = Signature.getInstance("SHA1withRSA");
        signature.initSign(privateK);
        signature.update(data);
        return new String(Base64Utils.encode(signature.sign()));
    }
	
	public static boolean verify(byte[] data, String publicKey, String sign)
            throws Exception {
        byte[] keyBytes = Base64Utils.decode(publicKey);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PublicKey publicK = keyFactory.generatePublic(keySpec);
        Signature signature = Signature.getInstance("SHA1withRSA");
        signature.initVerify(publicK);
        signature.update(data);
        return signature.verify(Base64Utils.decode(sign));
    }
    
    public static void main(String args[]) throws Exception{
    	String privateKey = "MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBALJKJjq9H9jmfia2gEilqPQXZjN+MsivoX9BC2UU80hDhCGN1j8rDysnJlLWMue1HxTJJf8DV2hBfNmqBHqmBMQoEsZ+ITdNsYn/wqLpvPXHFV57/bIIEI2JD72DOx6ZDWgbrp6BXoWVycEvUJ0JJJr+DCCt9LTEyfDXurIUqgZpAgMBAAECgYBkgx8IUGTq8A7AnnS2AAa/DY4Fi6jvsOwYBMB6zRPWcpHEJOVbGVhk2J5nZvCt5lNOcZQlL2oQkZLkV1BNINlgFq7MigGYSQ1V4/YQXjleatR90ABC0QGyfJQaXwmcVAONSkSCaao6uTAex1kwdQP7J+QkK4XDLBCfKBLgVpq1vQJBAOv//5z9UP4c49OD1/m+pnby7L7zQvlfPadIRQXMZnfvmkGlkY/In3IMWcDpUcyvkhE9hDHSOxrEmK9FYXCxfN8CQQDBZiEbs69cU099rihighsYi4la/0JEekljQSCuBIZ3TFfR8aBYwi20akrzUdm4MH5ZWi97j17/CERNVVXla523AkATvpA5JyxehjY9XPt1xpCQxRQviZSh3mj/FNnJeWddQ2uJcHu0JtnIJeZgcGTKlinHTXlA3dDaFXacu1ZCombLAkBrs8WCWNmyr86X7jIdUdlnHOYcYAT2f6d4998MKgb8Tu6lQ0uJwnGThJJC2PVHhvIGLpw80kYT/vWSn5BbWEgXAkA9o7HuOCRtfPz1PW+r32uw+LAc+Kt3cKNSiFgqSlqhUlntOZDHBRxwUkMfRFm5iApFN941uLl+kwvjpFNXX1rT";
    	String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCySiY6vR/Y5n4mtoBIpaj0F2YzfjLIr6F/QQtlFPNIQ4QhjdY/Kw8rJyZS1jLntR8UySX/A1doQXzZqgR6pgTEKBLGfiE3TbGJ/8Ki6bz1xxVee/2yCBCNiQ+9gzsemQ1oG66egV6FlcnBL1CdCSSa/gwgrfS0xMnw17qyFKoGaQIDAQAB";
    	System.out.println("privateKey = "+privateKey);
    	System.out.println("publicKey = "+publicKey);
    	String str = "amount=1&merOrderId=2016110933734&merchantId=898310048164164&merchantUserId=17&mobile=15005970603&mode=2&notifyUrl=http://114.215.204.136:8080/appService/interface/pay/ylPayNotify.action";
    	String signData = sign(str.getBytes(), privateKey);

    	System.out.println("signData = "+signData);
    	System.out.println(verify(str.getBytes(), publicKey, signData) + "");
    	
    }
}

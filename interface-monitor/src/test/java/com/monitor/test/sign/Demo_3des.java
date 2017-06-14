/**
 * 银联商务有限公司 2016
 */
package com.monitor.test.sign;

import java.nio.ByteBuffer;
import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;

/*
 * 3DES解密示例
 * lzli@chinaums.com
 */
public class Demo_3des {

	public static void main(String[] args) throws Exception {

		final String desKey = "ea8bf888c1cf552fe69831f46bca1e7b";// DES密钥
		String encryptdStr = "C37CEE18614C626ABE3550134E646C070E6957DFFAF450AE1EF4C78172F6FCB1F32CAD4AE0DAAA6C75D64F8A7D7044B1DAFADCA0D874D12120D2B6262FA725489082F7D4FD419502C37776A9F73F456926207D4587863791A1D43080970E8A4D1BAEDA089BDAF4C57062C995917CA2F052221251E9114E1DB352A6C81CC0D10481381F117EDE84A97D0C1C26F99B74E81BEC9FB9D460D830F963EC2AAFBD1AF6C8A866DC53ABA8ED810AE68646018FAB94C0D57F9C55595A5FDD1ACB3FF4B8BC3FF7E47A31A4CEAEA151CA17CCC78F3CD49C85809531235279E83F1BFE132760DA1B8761A362A76413FF1EC58666A84D36B526F582E1C1B1BBD659D2751174849FB5AACD3142D392B031B5C4454E1DBAF051C04D5E2E458709233F321F89C93FD6754186E1894947EA8DC88C0BC98A8A";// 加密字符串

		byte[] desByte = desEdeEcbPkcs5Decrypt(hexString2ByteArray(encryptdStr), hexString2ByteArray(desKey));
		System.out.println("3DES解密：" + new String(desByte, "UTF-8"));
	}

	public static byte[] desEdeEcbPkcs5Decrypt(byte[] data, byte[] keyData) throws Exception {
		if (keyData.length < 24)
			keyData = make3DesKey(keyData);
		Key localKey = makeDesKey(keyData);
		Cipher localCipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
		localCipher.init(Cipher.DECRYPT_MODE, localKey);
		return localCipher.doFinal(data);
	}

	public static byte[] make3DesKey(byte[] keyData) {
		byte[] key3 = null;
		byte[] key1 = new byte[8];
		ByteBuffer buf = ByteBuffer.wrap(keyData);
		buf.get(key1);
		buf.clear();
		buf = ByteBuffer.allocate(24);
		buf.put(keyData);
		buf.put(key1);
		buf.flip();
		key3 = buf.array();
		buf.clear();
		return key3;
	}

	private static final Key makeDesKey(byte[] keyData) throws Exception {
		DESedeKeySpec keySpec = new DESedeKeySpec(keyData);
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DESede");
		return keyFactory.generateSecret(keySpec);
	}

	/**
	 * Hex字符串转换成byte数组
	 * 
	 * @param hexStr
	 * @return
	 */
	public static byte[] hexString2ByteArray(String hexStr) {
		if (hexStr == null)
			return null;
		if (hexStr.length() % 2 != 0) {
			return null;
		}
		byte[] data = new byte[hexStr.length() / 2];
		for (int i = 0; i < hexStr.length() / 2; i++) {
			char hc = hexStr.charAt(2 * i);
			char lc = hexStr.charAt(2 * i + 1);
			byte hb = hexChar2Byte(hc);
			byte lb = hexChar2Byte(lc);
			if (hb < 0 || lb < 0) {
				return null;
			}
			int n = hb << 4;
			data[i] = (byte) (n + lb);
		}
		return data;
	}

	public static byte hexChar2Byte(char c) {
		if (c >= '0' && c <= '9')
			return (byte) (c - '0');
		if (c >= 'a' && c <= 'f')
			return (byte) (c - 'a' + 10);
		if (c >= 'A' && c <= 'F')
			return (byte) (c - 'A' + 10);
		return -1;
	}

}

package domain.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Criptografia {

	private static final String secretKey = "iéié";
	
	public static String criptografar(String senha){
		String senhaCripto = null;
		senha = senha + secretKey;
		try {
			MessageDigest cripto = MessageDigest.getInstance("SHA-256");
			byte senhaDigest[] = cripto.digest(senha.getBytes());
			
			StringBuilder hexString = new StringBuilder();
			for (byte b : senhaDigest) {
			  hexString.append(String.format("%02X", 0xFF & b));
			}
			
			senhaCripto = hexString.toString();
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		
		
		
		return senhaCripto;
	}

}

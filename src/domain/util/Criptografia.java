package domain.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.primefaces.util.Base64;

public class Criptografia {

	private static final String secretKey = "iéié";
	

	public static String criptoStrings(String string){
		string = string + " - " + secretKey;
		string = Base64.encodeToString(string.getBytes(), false);
		return string;
	}
	
	public static String decriptoStrings(String string){
		byte[] bytes = Base64.decode(string.getBytes());
		String stringDecode = new String(bytes);
		stringDecode = stringDecode.replace(" - " + secretKey, "");
		return stringDecode;
	}
	
	
	
	
	public static String criptografarSenhas(String senha){
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

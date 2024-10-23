package basics;

import static javax.crypto.Cipher.ENCRYPT_MODE;

import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Scanner;

import javax.crypto.Cipher;

public class RSA_ENCRYPTION {

	private static final String RSA = "RSA";
	public static PublicKey publicKey;
	private static PrivateKey privateKey;

	// Generating the asymmetric key pair using SecureRandom class functions and RSA
	// algorithm.
	public static void Generate_RSA_KeyPair() throws Exception {
		SecureRandom secureRandom = new SecureRandom();
		KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(RSA);
		keyPairGenerator.initialize(2048, secureRandom);
		KeyPair keyPair = keyPairGenerator.generateKeyPair();
		publicKey = keyPair.getPublic();
		privateKey = keyPair.getPrivate();

	}

//    public static Cipher createCipher ( KeyPair publicKey) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
//        Cipher encryptCipher = Cipher.getInstance(RSA);
//        encryptCipher.init(publicKey, ENCRYPT_MODE);
//        return  encryptCipher;
//    }

	public String encrypt(String message, PublicKey publicKey) throws Exception {
		Cipher encryptCipher = Cipher.getInstance("RSA");
		try {
			encryptCipher.init(ENCRYPT_MODE, publicKey);
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		}

		byte[] messageBytes = message.getBytes(StandardCharsets.UTF_8);
		byte[] encryptedMessageBytes = encryptCipher.doFinal(messageBytes);

		String encodedMessage = Base64.getEncoder().encodeToString(encryptedMessageBytes);

		return encodedMessage;
	}

	public String decrypt(String encryptedData) throws Exception {

		Cipher decryptCipher = Cipher.getInstance(RSA);
		try {
			decryptCipher.init(Cipher.DECRYPT_MODE, privateKey);
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		}

		byte[] encryptedMessageBytes = Base64.getDecoder().decode(encryptedData);
		byte[] decryptedMessageBytes = decryptCipher.doFinal(encryptedMessageBytes);
		String decryptedMessage = new String(decryptedMessageBytes, StandardCharsets.UTF_8);
		return decryptedMessage;
	}

	public static void main(String[] args) throws Exception {
		System.out.println("RSA Encryption");
		Scanner sc = new Scanner(System.in);
		RSA_ENCRYPTION rsa_encryption = new RSA_ENCRYPTION();

		System.out.println("Enter the Message : ");
		String message = sc.nextLine();

		try {
			RSA_ENCRYPTION.Generate_RSA_KeyPair();
		} catch (Exception e) {
			e.printStackTrace();
		}

		String encryptedMessage = rsa_encryption.encrypt(message, publicKey);
		String decyptedMessage = rsa_encryption.decrypt(encryptedMessage);
		System.out.println("Decrpted Message : " + decyptedMessage);
	}
}

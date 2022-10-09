/*
 * Class: CMSC203 
 * Instructor: Grigoriy Grinberg
 * Description: cryptoManager encrypts and decrypts a message. cryptomanagerteststudent tests cryptomanager
 * Due: 10/10/2022
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Rowan Wiles
*/



/**
 * This is a utility class that encrypts and decrypts a phrase using two
 * different approaches. The first approach is called the Caesar Cipher and is a
 * simple �substitution cipher� where characters in a message are replaced by a
 * substitute character. The second approach, due to Giovan Battista Bellaso,
 * uses a key word, where each character in the word specifies the offset for
 * the corresponding character in the message, with the key word wrapping around
 * as needed.
 * 
 * @author Farnaz Eivazi
 * @version 7/16/2022
 */
public class CryptoManager {
	
	private static final char LOWER_RANGE = ' ';
	private static final char UPPER_RANGE = '_';
	private static final int RANGE = UPPER_RANGE - LOWER_RANGE + 1;
	
	private static final String outOfBoundsMessage = "The selected string is not in bounds, Try again.";

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_RANGE and UPPER_RANGE characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	public static boolean isStringInBounds (String plainText) {
		for (int i = 0; i < plainText.length(); i++) { //loop through every character in plaintext and see if they're in range
			if (plainText.charAt(i) > UPPER_RANGE || plainText.charAt(i) < LOWER_RANGE) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String caesarEncryption(String plainText, int key) {
		//check if plaintext is in range
		if (!isStringInBounds(plainText)) 
			return outOfBoundsMessage;
		
		//loop through every character in plaintext and add key to each and return the composition of those characters
		String encryptedText = "";
		char plainChar;
		for (int i = 0; i < plainText.length(); i++) {
			plainChar = plainText.charAt(i);
			plainChar += key;
			while (!isStringInBounds(""+plainChar)) {
				plainChar -= RANGE;
			}
			encryptedText+=plainChar;
		}
		return encryptedText;
	}
	
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	public static String bellasoEncryption (String plainText, String bellasoStr) {
		//make variables
		String encryptedText = "";
		char plainChar;
		int j;
		for (int i = 0; i < plainText.length(); i++) { //loop through every char in plaintext
			plainChar = plainText.charAt(i);
			j = i;
			
			//make a version of the index for plaintext that will work for the key
			while (j >= bellasoStr.length()) {
				j -= bellasoStr.length();
			}
			
			//change all the characters based on the key and return their combination
			plainChar += bellasoStr.charAt(j);
			while (!isStringInBounds(""+plainChar))
				plainChar -= RANGE;
			encryptedText += plainChar;
		}
		return encryptedText;
	}
	
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String caesarDecryption (String encryptedText, int key) {
		//make variables
		String plainText = "";
		char encryptedChar;
		
		//loop through each char in encryptedText
		for (int i = 0; i < encryptedText.length(); i++) {
			encryptedChar = encryptedText.charAt(i);
			
			//adjust each char based on the key
			encryptedChar -= key;
			
			//make sure the chars are in range and correct if not
			while (!isStringInBounds(""+encryptedChar))
				encryptedChar += RANGE;
			
			//combine the chars
			plainText += encryptedChar;
		}
		return plainText;
	}
	
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String bellasoDecryption(String encryptedText, String bellasoStr) {
		//make variables
		String plainText = "";
		char encryptedChar;
		int j;
		
		//loop through each character in encryptedtext
		for (int i = 0; i < encryptedText.length(); i++) {
			encryptedChar = encryptedText.charAt(i);
			
			//make an index that will work for the key
			j = i;
			while (j >= bellasoStr.length()) {
				j -= bellasoStr.length();
			}
			
			//adjust each character and add them to make the encrypted string
			encryptedChar -= bellasoStr.charAt(j);
			while (!isStringInBounds(""+encryptedChar))
				encryptedChar += RANGE;
			plainText += encryptedChar;
		}
		return plainText;
	}
}

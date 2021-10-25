/*
 * CMSC203 CRN 24307
 Program: Assignment 3 Design
 Instructor: Proffesor Tsai
 Summary of Description: Encryption program
 Due Date: 10/10/2021 
	Student: Aryan Anwar

 */

public class CryptoManager {
	
	private static final char LOWER_BOUND = ' ';
	private static final char UPPER_BOUND = '_';
	private static final int RANGE = UPPER_BOUND - LOWER_BOUND + 1;

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_BOUND and UPPER_BOUND characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	//loops through each character in the text to see if it is within the lower and uppre bounds
	public static boolean stringInBounds (String plainText) {
		//for loop thorugh the entire text
		for (int i =0; i <= plainText.length() -1; i++)
		{
			// if a character is outside of the range return false
			if (plainText.charAt(i) < LOWER_BOUND || plainText.charAt(i) > UPPER_BOUND)
			{
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
	
	//loops through every character in  plainText, adds whatever the key is to the char at i then appends that char to a string and returns the string
	public static String encryptCaesar(String plainText, int key) {
		String str= "";
	
		//loops thorugh the text adding the key value to each character
		for (int i =0; i< plainText.length(); i++)
		{
            int x = (int) plainText.charAt(i) + key;
            //if the value of the key and the character is larger than UPPER_BOUND subtract range (64) until it is below UPPER_BOUND
            while (x > (int) UPPER_BOUND)
            {
                x-=RANGE;
            }
            str+=(char)x;
		}
		
		return str;
	}
	
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	
	// loops thorugh plainText and adds whatever the ASCII value of the character is to the ASCII value of the corresponding character in bellasoStr
	public static String encryptBellaso(String plainText, String bellasoStr) {
		
		String key = bellasoStr;
		String str = "";
		
		//  if bellasoStr is shorter than plainText keep adding  bellasoStr to key until they are the same length
		while(key.length()<plainText.length())
		{
			key+=bellasoStr;
		}

		//if bellasoStr is larger than the plain text, find the num of extra characters, then append the characters that indices are less than the value of extra to key
		if (plainText.length() < bellasoStr.length())
		{
		    key = "";
			int extra = bellasoStr.length() - plainText.length();
			for (int i =0; i<=extra; i++)
			{
				 char x = bellasoStr.charAt(i);
				 key += x;
			}
		}
		
		// loops thorugh the plainText adding the ascii value of the ith character in plainText to the ascii value of the ith character in key
		for (int i = 0; i< plainText.length(); i++)
		{
			int k = (int) plainText.charAt(i) + (int) key.charAt(i);
			
			//if the value of plainText plus the key is greater than the upper bound, keep subtracting range until it is within range
			while (k > (int) UPPER_BOUND)
			{
				k-=RANGE;
			}
			str += (char) k;
		}
		return str;
		/*
		int extra = plainText.length() - bellasoStr.length();
	    for (int i = 0; i < extra; i++)
	    {
	        bellasoStr+=bellasoStr.charAt(i);
	    }
		
		for (int i = 0; i<= plainText.length() -1; i++)
		{
			
			char og = plainText.charAt(i);
			char a = bellasoStr.charAt(i);
			int k = (int) og + (int) a;
			if (k > (int) UPPER_BOUND)
			{
				k-=RANGE;
			}
			str += (char) k;
		}
		*/
		
	}
	
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	
	//loops thorugh encryptedText and subtracts whatever the key is from each character
	public static String decryptCaesar(String encryptedText, int key) {
		String str = "";
		
		//loops thorugh encryptedText then subtracts the value of the key from the ith character
		for (int i =0; i< encryptedText.length(); i++)
			{
	            int x = (int) encryptedText.charAt(i) - key;
	            // if the value of the ith character - key is less than the lower bound, keep adding RANGE until it is greater than the lower bound
	            while(x < LOWER_BOUND)
	            {
	                x+=RANGE;
	            }
	            str+=(char)x;
			}
		return str;
	}
	
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	// loops thorugh encryptedText and subtracts the value of the character from the corresponding character in bellasoSTR
	public static String decryptBellaso(String encryptedText, String bellasoStr) {
		String key = bellasoStr;
		String str = "";
		
		// if bellasoStr is shorter than encryptedText keep adding  bellasoStr to key until they are the same length
		while(key.length()<encryptedText.length())
		{
			key+=bellasoStr;
		}
			
		//if bellasoStr is larger than the plain text, find the num of extra characters, then append the characters that indices are less than the value of extra to key
		if (encryptedText.length() < bellasoStr.length())
		{
		    key = "";
			int extra = bellasoStr.length() - encryptedText.length();
			for (int i =0; i<extra; i++)
			{
				 char x = bellasoStr.charAt(i);
				 key += x;
			}
		}
		//loops thorugh the encryptedeText subtracting the ascii value of key from the encryptedText character
		for (int i = 0; i<= encryptedText.length() -1; i++)
		{
			int k = (int) encryptedText.charAt(i) - (int) key.charAt(i);
			
			//if the value of the encryptedText character is smaller then LOWER_BOUND keep adding RANGE until it is greater than the value of LOWER_BOUND
			while (k < (int) LOWER_BOUND)
			{
				k+=RANGE;
			}
			str += (char) k;
		}
		return str;
	}
}

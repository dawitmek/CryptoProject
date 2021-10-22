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
  public static boolean stringInBounds(String plainText) {
    for (int i = 0; i < plainText.length(); i++)
    {
      if (plainText.charAt(i) <= UPPER_BOUND && plainText.charAt(i)>= LOWER_BOUND ) //If out of bounds return false
      {
        return true;
      } else 
    	  return false;
    }
    return false;
  }

  /**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */

  public static String encryptCaesar(String plainText, int key)
  {
    String cypher = ""; // encrypted string

    if (stringInBounds(plainText) == true) { // if plainText is in bounds then run

      for (int i = 0; i < plainText.length(); i++)
      {
        char charVar = plainText.charAt(i); 

        int charCypher = ((int) charVar + key); // plainText at i moving up by key

        while (charCypher > UPPER_BOUND) // while loop to get charCypher in bounds
        {
        	charCypher -= RANGE;
        }
        cypher += (char) charCypher; // Building char values on each other 

      }
    }
    return cypher;
  }
  /**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */

  public static String encryptBellaso(String plainText, String bellasoStr)
  {
    String cypher = ""; // encrypted string

    for (int i = 0; i < plainText.length(); i++)
    {
      char charVar = plainText.charAt(i);
      int charCypher = ((int) charVar + (int) bellasoStr.charAt(i % bellasoStr.length())); // encryption

      while (charCypher > (int) UPPER_BOUND) // makes sure the charCypher is in bounds
      {
    	  charCypher -= RANGE;
      }
      cypher += (char) charCypher;

    }
    return cypher;
  }
  /**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */

  public static String decryptCaesar(String encryptedText, int key)
  {
    String decryptCypher = ""; // decrypted string

    for (int i = 0; i < encryptedText.length(); i++) // run for encryptedText's length
    {
      char charVar = encryptedText.charAt(i);
      int decryptCharCypher = ((int) charVar - key); 

      while (decryptCharCypher < LOWER_BOUND) //decryption
      {
    	  decryptCharCypher += RANGE;
      }
      decryptCypher += (char) decryptCharCypher;

    }

    return decryptCypher;
  }
  /**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */

  public static String decryptBellaso(String encryptedText, String bellasoStr)
  {
    String decryptCypher = ""; // decrypted string

    for (int i = 0;i < encryptedText.length(); i++) // run for encryptedText's length
    {
      char charVar = encryptedText.charAt(i);

      int decryptCharCypher = ((int) charVar - (int) bellasoStr.charAt(i % bellasoStr.length()));
      while (decryptCharCypher < (int) LOWER_BOUND) //decryption
      {
    	  decryptCharCypher += RANGE;
      }
      decryptCypher += (char) decryptCharCypher;
    }
    return decryptCypher;
  }

}
/**
 * Class for RSA Algortihm
 *
 * @WolfDroid
 * @version 29/02/2020
 */

// External Library
import java.security.KeyPair;                       // Java Library for Processing Key Pair
import java.security.KeyPairGenerator;              // Java Library for Generating Key Pair
import java.security.PrivateKey;                    // Java Library for Processing Private Key
import java.security.PublicKey;                     // Java Library for Processing Public Key
import java.util.Base64;                            // Java Library for encoder and decoder
import javax.crypto.Cipher;                         // Java Library for cryptographic cipher function 

// RSA Algorithm Function
public class rsaEncryptDecrypt
{
    // Input Text 
    static String inputText = "Man is a slow, sloppy, and brilliant thinker; computer are fast, accurate, and stupid.";
    
    //Public Key Function
    public static byte[] encrypt (String inputText,PublicKey publicKey ) throws Exception
    {
        //Get Cipher Instance RSA With ECB Mode and OAEPWITHSHA-512ANDMGF1PADDING Padding
        Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWITHSHA-512ANDMGF1PADDING");
        
        //Initialize Cipher for ENCRYPT_MODE
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        
        //Perform Encryption
        byte[] cipherText = cipher.doFinal(inputText.getBytes()) ;

        return cipherText;
    }
    
    //Private Key Function
    public static String decrypt (byte[] cipherTextArray, PrivateKey privateKey) throws Exception
    {
        //Get Cipher Instance RSA With ECB Mode and OAEPWITHSHA-512ANDMGF1PADDING Padding
        Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWITHSHA-512ANDMGF1PADDING");
        
        //Initialize Cipher for DECRYPT_MODE
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        
        //Perform Decryption
        byte[] decryptedTextArray = cipher.doFinal(cipherTextArray);
        
        return new String(decryptedTextArray);
    }
    
    // Main Function
    public static void main(String[] args) throws Exception {
        // Key generator Instances
        KeyPairGenerator KPG = KeyPairGenerator.getInstance("RSA");
        KPG.initialize(4096);
        
        // Generating the KeyPair from key Generator Instances
        KeyPair keyP = KPG.generateKeyPair();
        
        // Setting the public and private key
        PublicKey publicKey = keyP.getPublic();         //Get Public Key
        PrivateKey privateKey = keyP.getPrivate();      //Get Private Key
        
        //Printing the input text
        System.out.println(" Input Text  : "+inputText);
        
        // Printing Encrypted Text
        byte[] cipherTextArray = encrypt(inputText, publicKey);                             //Converting an Input text into array of byte with public key
        String encryptedText = Base64.getEncoder().encodeToString(cipherTextArray);         //Encrypting the input text with Base 64 Encoder
        System.out.println("\n Encrypted Text : "+encryptedText);                           //Printing the Encrypted Output
        
        // Printing Decryted Text
        String decryptedText = decrypt(cipherTextArray, privateKey);                        //Decrypting the Encrypted text
        System.out.println("\n DeCrypted Text : "+decryptedText);                           //Printing the Decrypted Text
    }
}
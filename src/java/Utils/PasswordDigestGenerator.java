package Utils;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author Lars Mortensen
 */
public class PasswordDigestGenerator {

  public static String getEncoded(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
     
    MessageDigest md = MessageDigest.getInstance("SHA-256");
    md.update(str.getBytes("UTF-8")); 
    byte[] digest = md.digest();
    BigInteger bigInt = new BigInteger(1, digest);
    return bigInt.toString(16);
  }
  
  public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
    System.out.println("test: "+getEncoded("test"));
    System.out.println("a1234: "+getEncoded("a1234"));
  }
}

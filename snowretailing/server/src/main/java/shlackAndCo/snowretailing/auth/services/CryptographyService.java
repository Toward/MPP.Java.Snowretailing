package shlackAndCo.snowretailing.auth.services;

import org.apache.commons.codec.binary.Base64;
import shlackAndCo.snowretailing.auth.contracts.services.ICryptographyService;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

public class CryptographyService implements ICryptographyService {
    private final SecretKeySpec key;
    private final IvParameterSpec iv;
    private final Cipher cipher;

    public CryptographyService(String key, String initVector)
            throws UnsupportedEncodingException, NoSuchPaddingException, NoSuchAlgorithmException {
        if(key == null || key.isEmpty())
            throw new IllegalArgumentException("Key is empty");
        if(initVector == null || initVector.isEmpty())
            throw new IllegalArgumentException("InitVector is empty");

        this.key = new SecretKeySpec(key.getBytes("UTF-8"),"AES");
        this.iv = new IvParameterSpec(key.getBytes("UTF-8"));
        cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
    }

    public String encrypt(String data) {
        if(data == null || data.isEmpty())
            throw new IllegalArgumentException("Data is empty");

        try{
            cipher.init(Cipher.ENCRYPT_MODE, key, iv);
            byte[] encrypted = cipher.doFinal(data.getBytes());
            return Base64.encodeBase64String(encrypted);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public String decrypt(String data) {
        if(data == null || data.isEmpty())
            throw new IllegalArgumentException("Data is empty");

        try{
            cipher.init(Cipher.DECRYPT_MODE, key, iv);
            byte []original = cipher.doFinal(Base64.decodeBase64(data));
            return new String(original);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}

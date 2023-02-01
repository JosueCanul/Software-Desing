package org.example.encryption;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author david
 */

//Sacado de https://medium.com/el-acordeon-del-programador/encriptaci%C3%B3n-aes-en-java-ebb81ddf82b#:~:text=El%20primer%20paso%20para%20encriptar,el%20constructor%20de%20la%20clase
public class Descifrado implements Encriptar, Desencriptar{

    private final String secretKeyUs ="bufferScanner";
    private SecretKeySpec crearClave(String clave) {
        try {
            byte[] claveEncriptacion = clave.getBytes("UTF-8");

            MessageDigest sha = MessageDigest.getInstance("SHA-1");

            claveEncriptacion = sha.digest(claveEncriptacion);
            claveEncriptacion = Arrays.copyOf(claveEncriptacion, 16);

            SecretKeySpec secretKey = new SecretKeySpec(claveEncriptacion, "AES");

            return secretKey;
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {
            System.out.println(e);
        }

        return null;
    }

    public String encriptar(String datos) {
        String claveSecreta = this.secretKeyUs;
        try {
            SecretKeySpec secretKey = this.crearClave(claveSecreta);

            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);

            byte[] datosEncriptar = datos.getBytes("UTF-8");
            byte[] bytesEncriptados = cipher.doFinal(datosEncriptar);
            String encriptado = Base64.getEncoder().encodeToString(bytesEncriptados);

            return encriptado;
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException |
                 UnsupportedEncodingException |
                 IllegalBlockSizeException | BadPaddingException ex) {
            Logger.getLogger(Descifrado.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public String desencriptar(String datosEncriptados) {
        String claveSecreta = this.secretKeyUs;
        try {
            SecretKeySpec secretKey = this.crearClave(claveSecreta);

            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);

            byte[] bytesEncriptados = Base64.getDecoder().decode(datosEncriptados);
            byte[] datosDesencriptados = cipher.doFinal(bytesEncriptados);
            String datos = new String(datosDesencriptados);

            return datos;
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException |
                 BadPaddingException ex) {
            Logger.getLogger(Descifrado.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

}

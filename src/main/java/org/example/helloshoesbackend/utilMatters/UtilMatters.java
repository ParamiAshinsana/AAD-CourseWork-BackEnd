package org.example.helloshoesbackend.utilMatters;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;

public class UtilMatters {
    public static String convertBase64(MultipartFile data) {
        try {
            return Base64.getEncoder().encodeToString(data.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

//    public static byte[] convertBase64ToBytes11(String data) {
//        try {
//            return Base64.getDecoder().decode(data);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
}

package com.bhavy.projectmgr;

import android.content.Context;

import java.io.RandomAccessFile;
import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class ProjectManager {
    public Context con;
    public ProjectManager(Context context)
    {
        con = context;
    }
    /*Code by Neon Sketchcode Owner*/
    public static boolean Encode (String string, String path) {
        try {
            Cipher cipher = Cipher.getInstance((String)"AES/CBC/PKCS5Padding");
            byte[] arrby = "sketchwaresecure".getBytes();
            cipher.init(1, (Key)new SecretKeySpec(arrby, "AES"), (AlgorithmParameterSpec)new IvParameterSpec(arrby));
            byte[] arrby2 = cipher.doFinal(string.getBytes());
            RandomAccessFile randomAccessFile = new RandomAccessFile(path, "rw");
            randomAccessFile.setLength(0L);
            randomAccessFile.write(arrby2);
            return true;
        }
        catch (Exception exception) {
            return false;
        }
    }
    /*Decrypt Encoded Sketchware project's file*/
    public static String Decode (String path) {
        try{
            Cipher cipher = Cipher.getInstance((String)"AES/CBC/PKCS5Padding");
            byte[] arrby = "sketchwaresecure".getBytes();
            cipher.init(2, (Key)new SecretKeySpec(arrby, "AES"), (AlgorithmParameterSpec) new IvParameterSpec(arrby));
            RandomAccessFile randomAccessFile = new RandomAccessFile(path, "r");
            byte[] arrby2 = new byte[(int)randomAccessFile.length()];
            randomAccessFile.readFully(arrby2);
            return new String(cipher.doFinal(arrby2));
        } catch (Exception e){
            throw new RuntimeException("Error at " + path + ". Invalid project. Exception: " + e.getMessage());
        }
    }
    public static void Projects(){

    }
}

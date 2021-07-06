package com.bhavy.projectmgr;

import android.content.Context;
import android.net.Uri;

import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class ProjectManager {
    public Context con;
    private static final ArrayList<String> filedir = new ArrayList<>();
    private static final ArrayList<HashMap<String, Object>> project_list = new ArrayList<>();

    public ProjectManager(Context context)
    {
        con = context;
    }
    /*Code by Neon Sketchcode Owner*/
    public static boolean Encode(String string, String path) {
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            byte[] arrby = "sketchwaresecure".getBytes();
            cipher.init(1, new SecretKeySpec(arrby, "AES"), new IvParameterSpec(arrby));
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
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            byte[] arrby = "sketchwaresecure".getBytes();
            cipher.init(2, new SecretKeySpec(arrby, "AES"), new IvParameterSpec(arrby));
            RandomAccessFile randomAccessFile = new RandomAccessFile(path, "r");
            byte[] arrby2 = new byte[(int)randomAccessFile.length()];
            randomAccessFile.readFully(arrby2);
            return new String(cipher.doFinal(arrby2));
        } catch (Exception e){
            throw new RuntimeException("Error at " + path + ". Invalid project. Exception: " + e.getMessage());
        }
    }

    /* Retun project list details in json ArrayList */
    public static String Projects() {
        FileUtil.listDir(FileUtil.getExternalStorageDir().concat("/.sketchware/mysc/list/"), filedir);
        double count = 0;
        for(int _repeat18 = 0; _repeat18 < filedir.size(); _repeat18++) {
            HashMap<String, Object> map_decode;
            try {
                String decrypted = Decode(FileUtil.getExternalStorageDir().concat("/.sketchware/mysc/list/".concat(Uri.parse(filedir.get((int) (count))).getLastPathSegment().concat("/project"))));
                map_decode = new Gson().fromJson(decrypted, new TypeToken<HashMap<String, Object>>(){}.getType());
                project_list.add(map_decode);
            } catch(Exception ignored) {

            }
            count++;
        }
        return new Gson().toJson(project_list);
    }
}

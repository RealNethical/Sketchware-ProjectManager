package com.bhavy.projectmgr;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class MoreBlock {

    public static String list(){
        HashMap<String,Object> map;
        ArrayList<HashMap<String,Object>> lmap = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(FileUtil.getExternalStorageDir().concat("/.sketchware/collection/more_block/list")))));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                if (readLine.trim().length() > 0) {
                    map = new Gson().fromJson(readLine, new TypeToken<HashMap<String, Object>>(){}.getType());
                    map.put("code", readLine);
                    lmap.add(map);
                }
            }
            bufferedReader.close();
        } catch(IOException e) {
            lmap = null;
        }
    return new Gson().toJson(lmap);
    }

    /*public static String Share(){
    return null;
    }

    public static String Delete(){

    return null;
    }*/
}

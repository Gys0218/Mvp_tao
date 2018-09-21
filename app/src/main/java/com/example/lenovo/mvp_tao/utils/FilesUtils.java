package com.example.lenovo.mvp_tao.utils;

import android.text.TextUtils;

import com.example.lenovo.mvp_tao.bean.DownListNews;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/*
 * created by taofu on 2018/9/12
 **/
public class FilesUtils {


    public static void writeNewsDataToFile(DownListNews data, File file) {
        if(file == null){
            return;
        }

        Gson gson = new Gson();
        String json = gson.toJson(data);
        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(file);
            outputStream.write(json.getBytes("UTF-8"));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static DownListNews getNewsFromFile( File file) {

        if(file == null){
            return null;
        }
        FileInputStream fileInputStream = null;


        try {
            fileInputStream = new FileInputStream(file);
            byte bytes[] = new byte[1024];
            int len = -1;
            StringBuilder builder = new StringBuilder();
            while ((len = fileInputStream.read(bytes)) != -1) {
                builder.append(new String(bytes, 0, len, "UTF-8"));
            }

            String json = builder.toString();

            if (!TextUtils.isEmpty(json)) {
                Gson gson = new Gson();
                DownListNews data = gson.fromJson(json, DownListNews.class);
                return data;

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return null;
    }


    public static class ParameterizedTypeImpl implements ParameterizedType {
        private final Class raw;
        private final Type[] args;

        public ParameterizedTypeImpl(Class raw, Type[] args) {
            this.raw = raw;
            this.args = args != null ? args : new Type[0];
        }

        @Override
        public Type[] getActualTypeArguments() {
            return args;
        }

        @Override
        public Type getRawType() {
            return raw;
        }

        @Override
        public Type getOwnerType() {
            return null;
        }
    }


}



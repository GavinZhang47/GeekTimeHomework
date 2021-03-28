package com.week01.tm2;

import java.io.*;
import java.lang.reflect.Method;

public class HelloClassLoader extends ClassLoader {


    public static void main(String[] args) {

        try {
            Class<?> aClass = new HelloClassLoader().findClass("src/main/java/com/week01/tm2/Hello.xlass");
            Object instance = aClass.newInstance();
            Method hello = aClass.getDeclaredMethod("hello", null);
            hello.invoke(instance);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Class<?> findClass(String name)  {
        try {
            File file = new File(name);
            FileInputStream in = new FileInputStream(file);
            int available = in.available();
            ByteArrayOutputStream out=new ByteArrayOutputStream();
            byte[] bytes = new byte[available];
            byte[] buff = new byte[available];
            in.read(bytes);
            for(int i=0;i<bytes.length;i++){
                int a=255-bytes[i];
                buff[i]= (byte) a;
            }
            return defineClass(null, buff, 0, buff.length);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

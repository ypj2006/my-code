package com.ityefan.demo1recursion;

import java.io.File;
import java.io.IOException;

public class FileSearchTest1 {
    public static void main(String[] args) {
        File dir = new File("D:\\");
        try {
            searchFile(dir, "stone-maze 2.0.exe");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void searchFile(File dir, String filename) throws IOException {
        if(dir == null || !dir.exists() || dir.isFile()){
            return;
        }
        File[] files = dir.listFiles();
        if(files!=null && files.length>0){
            for (File file : files) {
                if(file.isFile()){
                    if(file.getName().contains(filename)){
                        System.out.println("找到文件："+file.getAbsolutePath());
                        Runtime runtime = Runtime.getRuntime();
                        runtime.exec(file.getAbsolutePath());
                    }
                }else{
                    searchFile(file, filename);
                }
            }
        }

    }
}

package com.accp.util;

import java.io.*;

/**
 * Created by Sall on 2019-2-18.
 */
public class FileIO {
    /**
     * 读取文件
     * @param path 路径
     * @return 返回的字符串
     */
    public String readerFile(String path){
        String str="";
        FileReader reader=null;BufferedReader bf=null;
        try {
            reader=new FileReader(path);
            bf=new BufferedReader(reader);
            String line=bf.readLine();
            str+=line;
            while (line!=null){
                line=bf.readLine();
                str+=line;
            }
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                bf.close();
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return  str;
    }

    /**
     * 写
     * @param path 路径
     * @param str 要写入的内容
     */
    public void writerFile(String path,String str){
        //创建FileWriter对象
        Writer fw=null;
        try {
            fw=new FileWriter(path);
            fw.write(str);
            fw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

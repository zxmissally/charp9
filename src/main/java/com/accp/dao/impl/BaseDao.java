package com.accp.dao.impl;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * Created by Sall on 2019-2-18.
 */
public class BaseDao {
    private static String driver="";
    private static String url="";
    private static String user="";
    private static String pwd="";

    static {
        init();
    }
    public static void init(){
        Properties properties=new Properties();
        String config="database.properties";
        InputStream is= BaseDao.class.getClassLoader().getResourceAsStream(config);
        try {
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        driver=properties.getProperty("driver");
        url=properties.getProperty("url");
        user=properties.getProperty("user");
        pwd=properties.getProperty("pwd");
        //加载
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    Connection conn=null;
    PreparedStatement pstmt=null;
    ResultSet rs=null;
    //得到连接
    public Connection getConnect(){
        try {
           conn= DriverManager.getConnection(url,user,pwd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  conn;
    }
    //关闭
    public  void close(){
        try{
            if(rs!=null){
                rs.close();
            }
            if(pstmt!=null){
                pstmt.close();
            }
            if(conn!=null){
                conn.close();
            }
        }catch (Exception e){

        }
    }
    //增加，修改，删除
    public int executeUpdate(String sql,Object[] objs){
        int num=0;
        conn=getConnect();
        try {
           pstmt= conn.prepareStatement(sql);
           for (int i=0;i<objs.length;i++){
               pstmt.setObject(i+1,objs[i]);
           }
           num=pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close();
        }
        return num;
    }


}

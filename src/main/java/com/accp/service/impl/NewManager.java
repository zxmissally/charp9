package com.accp.service.impl;

import com.accp.entity.New;
import com.accp.service.NewService;
import com.accp.util.FileIO;

import java.util.List;

/**
 * Created by Sall on 2019-2-18.
 */
public class NewManager {
    public void toHtml(){
        //1.读取模板文件内容返回文件内容字符串
        FileIO fileio=new FileIO();
        String tempfile=fileio.readerFile("src/one.html");
        //2.读取数据库表，获取新闻类别
        NewService newservice=new NewServiceImpl();
        List<New> list= newservice.selectAll();
        for (int i=0;i<list.size();i++){
            //读取一条新闻
            New n=list.get(i);
            //使用该条信息替换对应占位符
            String replacestr=new String();
            replacestr=tempfile;
            replacestr=replacestr.replace("{title}",n.getTitle());
            replacestr=replacestr.replace("{author}",n.getAuthor());
            replacestr=replacestr.replace("{createTime}",n.getCreateTime().toString());
            replacestr=replacestr.replace("{content}",n.getContent());
            //把该条信息生成html文件
            String filepath=i+".html";
            fileio.writerFile(filepath,replacestr);

        }
    }
}

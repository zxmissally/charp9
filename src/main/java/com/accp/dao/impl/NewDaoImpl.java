package com.accp.dao.impl;

import com.accp.dao.NewDao;
import com.accp.entity.New;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sall on 2019-2-18.
 */
public class NewDaoImpl extends BaseDao implements NewDao {
    public List<New> selectAll() {
        List<New> list=new ArrayList<New>();
        getConnect();
        String sql="select id,title,author,createTime,content from new";
        try {
            pstmt= conn.prepareStatement(sql);
            rs=pstmt.executeQuery();
            while (rs.next()){
                New n=new New();
                n.setId(rs.getInt("id"));
                n.setTitle(rs.getString("title"));
                n.setAuthor(rs.getString("author"));
                n.setCreateTime(rs.getDate("createTime"));
                n.setContent(rs.getString("content"));
                list.add(n);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}

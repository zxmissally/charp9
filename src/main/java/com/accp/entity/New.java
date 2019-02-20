package com.accp.entity;

import java.io.Serializable;
import java.sql.Date;

/**新闻信息
 * Created by Sall on 2019-2-18.
 */
public class New implements Serializable {
    private int id;
    private String title;
    private String author;
    private Date createTime;
    private String content;

    public New(int id, String title, String author, Date createTime, String content) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.createTime = createTime;
        this.content = content;
    }

    public New() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "New{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", createTime=" + createTime +
                ", content='" + content + '\'' +
                '}';
    }
}

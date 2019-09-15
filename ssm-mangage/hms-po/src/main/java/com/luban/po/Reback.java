package com.luban.po;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
public class Reback {
    private Integer id;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createtime;

    private Integer howlong;
@DateTimeFormat(pattern="yyyy-MM-dd")
    private Date backtime;

    private Integer state;

    private Integer cid;

    private String cname;

    private Integer uid;

    private String uname;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getHowlong() {
        return howlong;
    }

    public void setHowlong(Integer howlong) {
        this.howlong = howlong;
    }

    public Date getBacktime() {
        return backtime;
    }

    public void setBacktime(Date backtime) {
        this.backtime = backtime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname == null ? null : cname.trim();
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname == null ? null : uname.trim();
    }
}
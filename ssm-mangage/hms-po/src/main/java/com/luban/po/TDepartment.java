package com.luban.po;

import java.io.Serializable;
import java.util.List;

public class TDepartment implements  Serializable{
    private Integer id;//学院编号

    private String name;//学院名称
    
    private List<TMajor> tMajors; //专业列表

    public List<TMajor> gettMajors() {
		return tMajors;
	}

	public void settMajors(List<TMajor> tMajors) {
		this.tMajors = tMajors;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}
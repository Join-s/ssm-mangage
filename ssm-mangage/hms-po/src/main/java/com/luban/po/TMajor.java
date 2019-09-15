package com.luban.po;

import java.io.Serializable;
import java.util.List;

public class TMajor implements  Serializable{
    private Integer id;//专业编号

    private Integer depid;//学院编号

    private String name;//专业名称
//学院
    private List<TGrade> tGrades;//班级列表
    
    
    private TDepartment tDepartment;//院系
    
    public List<TGrade> gettGrades() {
		return tGrades;
	}

	public void settGrades(List<TGrade> tGrades) {
		this.tGrades = tGrades;
	}

	public TDepartment gettDepartment() {
		return tDepartment;
	}

	public void settDepartment(TDepartment tDepartment) {
		this.tDepartment = tDepartment;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDepid() {
        return depid;
    }

    public void setDepid(Integer depid) {
        this.depid = depid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}
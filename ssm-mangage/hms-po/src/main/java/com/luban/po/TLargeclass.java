package com.luban.po;

import java.io.Serializable;
import java.util.List;

public class TLargeclass implements  Serializable{
	private Integer id;//元件大类编号

	private String name;//元件大类名称
	//一对多 元件小类
	private List<TSubclass> tSubclassList;

	@Override
	public String toString() {
		return "TLargeclass [id=" + id + ", name=" + name + ", tSubclassList=" + tSubclassList + "]";
	}

	public List<TSubclass> gettSubclassList() {
		return tSubclassList;
	}

	public void settSubclassList(List<TSubclass> tSubclassList) {
		this.tSubclassList = tSubclassList;
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
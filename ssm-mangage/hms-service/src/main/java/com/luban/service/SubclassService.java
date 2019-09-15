package com.luban.service;

import com.luban.po.TSubclass;
import com.luban.po.TSubclassExample;

import java.util.List;

public interface SubclassService {
	int insert(TSubclass ts);
	List<TSubclass> selectByExample(TSubclassExample example);
	int selectMaxId();
	List<TSubclass> selectByName(String name);
}

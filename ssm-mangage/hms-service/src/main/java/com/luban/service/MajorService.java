package com.luban.service;

import java.util.List;

import com.luban.mapper.TMajorMapper;
import com.luban.po.TMajor;
import com.luban.po.TMajorExample;

public interface MajorService {
	List<TMajor> selectName(String name);

	int selectMaxId();

	int countByExample(TMajorExample example);

	int deleteByExample(TMajorExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(TMajor record);

	int insertSelective(TMajor record);

	List<TMajor> selectByExample(TMajorExample example);

	TMajor selectByPrimaryKey(Integer id);

	int updateByExampleSelective(TMajor record, TMajorExample example);

	int updateByExample(TMajor record, TMajorExample example);

	int updateByPrimaryKeySelective(TMajor record);

	int updateByPrimaryKey(TMajor record);
	
}

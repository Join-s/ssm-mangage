package com.luban.service.impl;

import com.luban.mapper.TSubclassMapper;
import com.luban.po.TSubclass;
import com.luban.po.TSubclassExample;
import com.luban.service.SubclassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class SubClassServiceImpl implements SubclassService {
	@Autowired

	private TSubclassMapper tSubclassMapper;
	public int insert(TSubclass ts) {
		return tSubclassMapper.insert(ts);
	}
	public List<TSubclass> selectByExample(TSubclassExample example) {
		return tSubclassMapper.selectByExample(example);
	}

	public int selectMaxId() {
		return tSubclassMapper.selectMaxId();
	}

	public List<TSubclass> selectByName(String name) {

		TSubclassExample example=new TSubclassExample();
		TSubclassExample.Criteria c=example.createCriteria();
		c.andNameEqualTo(name);
		return tSubclassMapper.selectByExample(example);
	}
}

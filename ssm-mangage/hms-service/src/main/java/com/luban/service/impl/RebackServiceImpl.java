package com.luban.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luban.mapper.RebackMapper;
import com.luban.po.Reback;
import com.luban.po.RebackExample;
import com.luban.service.RebackService;

@Service
@Transactional
public class RebackServiceImpl implements RebackService {
	@Autowired
	private RebackMapper rebackMapper;
	public int deleteByPrimaryKey(Integer id) {
		return rebackMapper.deleteByPrimaryKey(id);
	}
	public int insert(Reback record) {
		return rebackMapper.insert(record);
	}
	public List<Reback> selectByExample(RebackExample example) {
		return rebackMapper.selectByExample(example);
	}
	public Reback selectByPrimaryKey(Integer id) {
		return rebackMapper.selectByPrimaryKey(id);
	}
	public int updateByPrimaryKeySelective(Reback record) {
		return rebackMapper.updateByPrimaryKeySelective(record);
	}
	

}

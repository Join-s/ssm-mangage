package com.luban.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luban.mapper.TMajorMapper;
import com.luban.po.TGrade;
import com.luban.po.TGradeExample;
import com.luban.po.TMajor;
import com.luban.po.TMajorExample;
import com.luban.service.MajorService;

@Service
@Transactional
public class MajorServiceImpl implements MajorService {
	@Autowired
	private TMajorMapper tMajorMapper;

	public int countByExample(TMajorExample example) {
		return tMajorMapper.countByExample(example);
	}

	public int deleteByExample(TMajorExample example) {
		return tMajorMapper.deleteByExample(example);
	}

	public int deleteByPrimaryKey(Integer id) {
		return tMajorMapper.deleteByPrimaryKey(id);
	}

	public int insert(TMajor record) {
		return tMajorMapper.insert(record);
	}

	public int insertSelective(TMajor record) {
		return tMajorMapper.insertSelective(record);
	}

	public List<TMajor> selectByExample(TMajorExample example) {
		return null;
	}

	public TMajor selectByPrimaryKey(Integer id) {
		return null;
	}

	public int updateByExampleSelective(TMajor record, TMajorExample example) {
		return tMajorMapper.updateByExampleSelective(record, example);
	}

	public int updateByExample(TMajor record, TMajorExample example) {
		return tMajorMapper.updateByExample(record, example);
	}

	public int updateByPrimaryKeySelective(TMajor record) {
		return tMajorMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(TMajor record) {
		return tMajorMapper.updateByPrimaryKey(record);
	}

	public int selectMaxId() {
		return tMajorMapper.selectMaxId();
	}

	public List<TMajor> selectName(String name) {
			TMajorExample example=new TMajorExample();
			
			com.luban.po.TMajorExample.Criteria c=example.createCriteria();
			c.andNameEqualTo(name);
			
			return tMajorMapper.selectByExample(example);
		}
	}


package com.luban.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luban.mapper.TDepartmentMapper;
import com.luban.po.TDepartment;
import com.luban.po.TDepartmentExample;
import com.luban.po.TUserExample.Criteria;

@Service
@Transactional
public class DepServiceImpl implements com.luban.service.DepService {
	@Autowired
	private TDepartmentMapper tDepartmentMapper;

	public int selectMaxId() {
		return tDepartmentMapper.selectMaxId();
	}
	
	public List<TDepartment> selectAllgra() {
		return tDepartmentMapper.selectAllgra();
	}

	public int countByExample(TDepartmentExample example) {
		return 0;
	}

	public int deleteByExample(TDepartmentExample example) {
		return 0;
	}

	public int deleteByPrimaryKey(Integer id) {
		return tDepartmentMapper.deleteByPrimaryKey(id);
	}

	public int insert(TDepartment record) {
		return tDepartmentMapper.insert(record);
	}

	public int insertSelective(TDepartment record) {
		return 0;
	}

	public List<TDepartment> selectByExample(TDepartmentExample example) {
		return tDepartmentMapper.selectByExample(example);
	}

	public TDepartment selectByPrimaryKey(Integer id) {
		return tDepartmentMapper.selectByPrimaryKey(id);
	}

	public int updateByExampleSelective(TDepartment record, TDepartmentExample example) {
		return tDepartmentMapper.updateByExampleSelective(record, example);
	}

	public int updateByExample(TDepartment record, TDepartmentExample example) {
		return tDepartmentMapper.updateByExample(record, example);
	}

	public int updateByPrimaryKeySelective(TDepartment record) {
		return tDepartmentMapper.updateByPrimaryKeySelective(record) ;
	}

	public int updateByPrimaryKey(TDepartment record) {
		return tDepartmentMapper.updateByPrimaryKey(record);
	}

	public List<TDepartment> selectName(String name) {
		
		TDepartmentExample example=new TDepartmentExample();
		
		com.luban.po.TDepartmentExample.Criteria c=example.createCriteria();
		c.andNameEqualTo(name);
		
		return tDepartmentMapper.selectByExample(example);
	}

}

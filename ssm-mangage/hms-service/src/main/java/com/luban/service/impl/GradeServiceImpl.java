package com.luban.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luban.mapper.TGradeMapper;
import com.luban.po.TDepartmentExample;
import com.luban.po.TGrade;
import com.luban.po.TGradeExample;
import com.luban.service.GradeService;

@Service
@Transactional
public class GradeServiceImpl implements GradeService {
	@Autowired
	private TGradeMapper tGradeMapper;

	public int countByExample(TGradeExample example) {
		return tGradeMapper.countByExample(example);
	}

	public int deleteByExample(TGradeExample example) {
		return tGradeMapper.deleteByExample(example);
	}

	public int deleteByPrimaryKey(Integer id) {
		return tGradeMapper.deleteByPrimaryKey(id);
	}

	public int insert(TGrade record) {
		return tGradeMapper.insert(record);
	}

	public int insertSelective(TGrade record) {
		return tGradeMapper.insertSelective(record);
	}

	public List<TGrade> selectByExample(TGradeExample example) {
		return tGradeMapper.selectByExample(example);
	}

	public TGrade selectByPrimaryKey(Integer id) {
		return tGradeMapper.selectByPrimaryKey(id);
	}

	public int updateByExampleSelective(TGrade record, TGradeExample example) {
		return tGradeMapper.updateByExampleSelective(record, example) ;
	}

	public int updateByExample(TGrade record, TGradeExample example) {
		return tGradeMapper.updateByExample(record, example);
	}

	public int updateByPrimaryKeySelective(TGrade record) {
		return tGradeMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(TGrade record) {
		return tGradeMapper.updateByPrimaryKey(record);
	}

	public int selectMaxId() {
		return tGradeMapper.selectMaxId();
	}

	public List<TGrade> selectName(String name) {
		TGradeExample example=new TGradeExample();
		
		com.luban.po.TGradeExample.Criteria c=example.createCriteria();
		c.andNameEqualTo(name);
		
		return tGradeMapper.selectByExample(example);
	}

}

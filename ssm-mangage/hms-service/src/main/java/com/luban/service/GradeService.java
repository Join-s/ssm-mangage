package com.luban.service;

import java.util.List;

import com.luban.mapper.TGradeMapper;
import com.luban.po.TGrade;
import com.luban.po.TGradeExample;

public interface GradeService {
	List<TGrade> selectName(String name);

	int selectMaxId();

	int countByExample(TGradeExample example);

	int deleteByExample(TGradeExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(TGrade record);

	int insertSelective(TGrade record);

	List<TGrade> selectByExample(TGradeExample example);

	TGrade selectByPrimaryKey(Integer id);

	int updateByExampleSelective(TGrade record, TGradeExample example);

	int updateByExample(TGrade record, TGradeExample example);

	int updateByPrimaryKeySelective(TGrade record);

	int updateByPrimaryKey(TGrade record);
	
}

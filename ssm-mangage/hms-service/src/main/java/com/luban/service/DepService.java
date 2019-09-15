package com.luban.service;
import java.util.List;

import com.luban.po.TDepartment;
import com.luban.po.TDepartmentExample;

public interface DepService {

	int selectMaxId();
	List<TDepartment> selectName(String name);
	List<TDepartment> selectAllgra();

	int countByExample(TDepartmentExample example);

	int deleteByExample(TDepartmentExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(TDepartment record);

	int insertSelective(TDepartment record);

	List<TDepartment> selectByExample(TDepartmentExample example);

	TDepartment selectByPrimaryKey(Integer id);

	int updateByExampleSelective(TDepartment record, TDepartmentExample example);

	int updateByExample(TDepartment record, TDepartmentExample example);

	int updateByPrimaryKeySelective(TDepartment record);

	int updateByPrimaryKey(TDepartment record);

	
	
}

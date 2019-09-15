package com.luban.service;

import com.luban.po.TComponent;
import com.luban.po.TComponentExample;

import java.util.List;

public interface ComponentsService {
	/**
	* @Description 方法描述: 查询所有
	 */
	List<TComponent> selectAll();
	/**
	* @Description 方法描述: 查询所有
	 */
	List<TComponent> selectAll(TComponent tComponent);


	/**
	 * @Description 方法描述: 查询所有
	 */
	List<TComponent> selectByCom(TComponent tComponent);

	/**
	* @Description 方法描述: 根据id查询
	 */
	TComponent findById(Integer id);
	/**
	* @Description 方法描述: 修改
	 */
	int updateByPrimaryKeySelective(TComponent component);
	/**
	* @Description 方法描述: 根据id删除
	 */
	int deleteByPrimaryKey(Integer id);
	/**
	* @Description 方法描述: 插入
	 */
	int insert(TComponent record);	
	List<TComponent> selectByExample(TComponentExample example);
	 List<TComponent> selectByExample(List<Integer> ids);
	TComponent selectVoById(Integer id);
	int delete(Integer [] ids);

int selectMaxId();
	int insertSelect(TComponent component);
}

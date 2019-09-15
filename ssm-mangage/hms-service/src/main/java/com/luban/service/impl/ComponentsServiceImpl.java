package com.luban.service.impl;

import com.luban.mapper.TComponentMapper;
import com.luban.po.TComponent;
import com.luban.po.TComponentExample;
import com.luban.po.TComponentExample.Criteria;
import com.luban.service.ComponentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service
@Transactional
public class ComponentsServiceImpl implements ComponentsService {
	@Autowired
	private TComponentMapper tComponentMapper;

	/**
	 * @Description 方法描述: 查询所有
	 */
	@Override
	public List<TComponent> selectAll(TComponent example) {
//			TComponentExample ex=new TComponentExample();
//		Criteria c=ex.createCriteria();
//			if(example!=null){
//				if(example.getSid()!=null){
//					c.andSidEqualTo(example.getSid());
//				}
//				if(example.getName()!=null){
//					c.andNameLike("%"+example.getName()+"%");
//				}
//				if(example.getId()!=null){
//					c.andIdEqualTo(example.getId());
//				}
//		}else{
//c.andIdIsNotNull();
//			}
		return tComponentMapper.selectAll();
	}

	@Override
	public List<TComponent> selectByCom(TComponent example) {
		TComponentExample ex=new TComponentExample();
		Criteria c=ex.createCriteria();
			if(example!=null){
				if(example.getSid()!=null){
					c.andSidEqualTo(example.getSid());
				}
				if(example.getName()!=null){
					c.andNameLike("%"+example.getName()+"%");
				}
				if(example.getId()!=null){
					c.andIdEqualTo(example.getId());
				}
		}else{
c.andIdIsNotNull();
			}
		List<TComponent> list=tComponentMapper.selectByExample(ex);

		return list;
	}

	/**
	 * @Description 方法描述: 根据id查询
	 */

	@Override
	public TComponent findById(Integer id) {
		return tComponentMapper.selectByPrimaryKey(id);
	}

	/**
	 * @Description 方法描述: 修改
	 */

	@Override
	public int updateByPrimaryKeySelective(TComponent component) {
		return tComponentMapper.updateByPrimaryKeySelective(component);

	}

	/**
	 * @Description 方法描述: 根据id删除
	 */

	@Override
	public int deleteByPrimaryKey(Integer id) {
		return tComponentMapper.deleteByPrimaryKey(id);

	}

	/**
	 * @Description 方法描述: 插入
	 */
	public int insert(TComponent record) {
		return tComponentMapper.insert(record);

	}

	public List<TComponent> selectByExample(List<Integer> ids) {
		TComponentExample example=new TComponentExample();
		Criteria c=example.createCriteria();
		c.andIdIn(ids);
		return  tComponentMapper.selectByExample(example);
	}

	public TComponent selectVoById(Integer id) {
		return tComponentMapper.selectVoById(id);
	}

	public int delete(Integer[] ids) {
		List<Integer> ds=Arrays.asList(ids);
		TComponentExample example=new TComponentExample();
		Criteria c=example.createCriteria();
		c.andIdIn(ds);
		return tComponentMapper.deleteByExample(example);
	}

	public List<TComponent> selectAll() {
		return tComponentMapper.selectAll();
	}

	public List<TComponent> selectByExample(TComponentExample example) {
		return tComponentMapper.selectByExample(example);
	}

	public int insertSelect(TComponent component) {
		return tComponentMapper.insertSelective(component);
	}

	public int selectMaxId() {
		return tComponentMapper.selectMaxId();
	}
}

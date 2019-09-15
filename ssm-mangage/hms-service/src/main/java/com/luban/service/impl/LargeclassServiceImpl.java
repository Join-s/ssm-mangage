package com.luban.service.impl;

import com.luban.mapper.TLargeclassMapper;
import com.luban.po.TLargeclass;
import com.luban.po.TLargeclassExample;
import com.luban.service.LargeclassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class LargeclassServiceImpl implements LargeclassService {

	@Autowired
	private TLargeclassMapper largeclassMapper;
	public List<TLargeclass> selectVo(TLargeclass largeclass) {
		return largeclassMapper.selectVo(largeclass);
	}

	public int selectMaxId() {
		return largeclassMapper.selectMaxId();
	}

	public int insert(TLargeclass tl) {
		return largeclassMapper.insert(tl);
	}

	public List<TLargeclass> selectByName(String name) {
		TLargeclassExample  example=new TLargeclassExample();
		TLargeclassExample.Criteria c=example.createCriteria();
		c.andNameEqualTo(name);
		return largeclassMapper.selectByExample(example);
	}

	public List<TLargeclass> selectByExample(TLargeclassExample example) {
		return largeclassMapper.selectByExample(example);
	}
}

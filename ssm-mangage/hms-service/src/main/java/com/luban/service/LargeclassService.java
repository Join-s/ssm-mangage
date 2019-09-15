package com.luban.service;

import com.luban.po.TLargeclass;
import com.luban.po.TLargeclassExample;

import java.util.List;

public interface LargeclassService {
	/** 
	* @Description 描述: <pre>
	* @author 作者: hellc <pre>
	* @date 时间: 2018年11月9日 下午9:58:59 <pre> 
	*/
	List<TLargeclass> selectVo(TLargeclass largeclass);
	int selectMaxId();
	List<TLargeclass> selectByExample(TLargeclassExample example);
	int insert(TLargeclass tl);
	List<TLargeclass> selectByName(String name);

}

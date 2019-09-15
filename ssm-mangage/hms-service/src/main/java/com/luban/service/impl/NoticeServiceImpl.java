package com.luban.service.impl;

import com.luban.mapper.TNoticeMapper;
import com.luban.po.TNotice;
import com.luban.po.TNoticeExample;
import com.luban.po.TNoticeExample.Criteria;
import com.luban.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class NoticeServiceImpl implements NoticeService {


	@Autowired
	private TNoticeMapper tNoticeMapper;

	public int selectMaxId() {
		return tNoticeMapper.selectMaxId();
	}
	public List<TNotice> selectAll(){
		TNoticeExample example=new TNoticeExample();
		return tNoticeMapper.selectByExample(example);
	}

	public TNotice findById(Integer id) {
		return tNoticeMapper.selectByPrimaryKey(id);
	}
	
	public int updateByPrimaryKeySelective(TNotice tNotice) {
		return tNoticeMapper.updateByPrimaryKeySelective(tNotice);
	}

	public int deleteByPrimaryKey(Integer id) {
		return tNoticeMapper.deleteByPrimaryKey(id);
	}

	public int insert(TNotice record) {
	    if(record.getId()==null||record.getId()==0){
            int i=tNoticeMapper.selectMaxId();
            record.setId(i);
        }

		return tNoticeMapper.insert(record);
	}

	public List<TNotice> selectTop() {
		TNoticeExample example=new TNoticeExample();
		Criteria c=example.createCriteria();
		c.andIstopEqualTo("1");
		
		return tNoticeMapper.selectByExample(example);
	}
}

package com.luban.service;

import java.util.Date;
import java.util.List;
import com.luban.po.Reback;
import com.luban.po.RebackExample;

public interface RebackService {

//删除
    int deleteByPrimaryKey(Integer id);
//增加
    int insert(Reback record);
//查
    List<Reback> selectByExample(RebackExample example);
//查
    Reback selectByPrimaryKey(Integer id);
//修改
    int updateByPrimaryKeySelective(Reback record);
}

package com.luban.mapper;

import com.luban.po.Reback;
import com.luban.po.RebackExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RebackMapper {
    int countByExample(RebackExample example);

    int deleteByExample(RebackExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Reback record);

    int insertSelective(Reback record);

    List<Reback> selectByExample(RebackExample example);

    Reback selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Reback record, @Param("example") RebackExample example);

    int updateByExample(@Param("record") Reback record, @Param("example") RebackExample example);

    int updateByPrimaryKeySelective(Reback record);

    int updateByPrimaryKey(Reback record);
}
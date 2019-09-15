package com.luban.mapper;

import com.luban.po.TSubclass;
import com.luban.po.TSubclassExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TSubclassMapper {
    int countByExample(TSubclassExample example);
int selectMaxId();
    int deleteByExample(TSubclassExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TSubclass record);

    int insertSelective(TSubclass record);

    List<TSubclass> selectByExample(TSubclassExample example);

    TSubclass selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TSubclass record, @Param("example") TSubclassExample example);

    int updateByExample(@Param("record") TSubclass record, @Param("example") TSubclassExample example);

    int updateByPrimaryKeySelective(TSubclass record);

    int updateByPrimaryKey(TSubclass record);
}
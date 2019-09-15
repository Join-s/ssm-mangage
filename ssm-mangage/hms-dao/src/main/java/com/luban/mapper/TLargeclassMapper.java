package com.luban.mapper;

import com.luban.po.TLargeclass;
import com.luban.po.TLargeclassExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TLargeclassMapper {

    int countByExample(TLargeclassExample example);
int selectMaxId();
    int deleteByExample(TLargeclassExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TLargeclass record);

    int insertSelective(TLargeclass record);

    List<TLargeclass> selectByExample(TLargeclassExample example);
    
    List<TLargeclass> selectVo(TLargeclass tcLargeclass);

    TLargeclass selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TLargeclass record, @Param("example") TLargeclassExample example);

    int updateByExample(@Param("record") TLargeclass record, @Param("example") TLargeclassExample example);

    int updateByPrimaryKeySelective(TLargeclass record);

    int updateByPrimaryKey(TLargeclass record);
}
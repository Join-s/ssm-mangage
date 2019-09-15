package com.luban.mapper;

import com.luban.po.TComponent;
import com.luban.po.TComponentExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TComponentMapper {
    int countByExample(TComponentExample example);
    int deleteByExample(TComponentExample example);
int selectMaxId();
    int deleteByPrimaryKey(Integer id);

    int insert(TComponent record);

    int insertSelective(TComponent record);
    List<TComponent> selectAll();
    List<TComponent> selectByExample(TComponentExample example);
    
    List<TComponent> selectInfo(TComponent tComponent);
    
    TComponent selectByPrimaryKey(Integer id);
    TComponent  selectVoById(Integer id);

    int updateByExampleSelective(@Param("record") TComponent record, @Param("example") TComponentExample example);

    int updateByExample(@Param("record") TComponent record, @Param("example") TComponentExample example);

    int updateByPrimaryKeySelective(TComponent record);

    int updateByPrimaryKey(TComponent record);
}
package com.luban.mapper;

import com.luban.po.TNotice;
import com.luban.po.TNoticeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TNoticeMapper {
    int countByExample(TNoticeExample example);
    int selectMaxId();
    int deleteByExample(TNoticeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TNotice record);

    int insertSelective(TNotice record);

    List<TNotice> selectByExample(TNoticeExample example);

    TNotice selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TNotice record, @Param("example") TNoticeExample example);

    int updateByExample(@Param("record") TNotice record, @Param("example") TNoticeExample example);

    int updateByPrimaryKeySelective(TNotice record);

    int updateByPrimaryKey(TNotice record);
}
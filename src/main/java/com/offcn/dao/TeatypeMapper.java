package com.offcn.dao;

import com.offcn.po.Teatype;
import com.offcn.po.TeatypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TeatypeMapper {
    long countByExample(TeatypeExample example);

    int deleteByExample(TeatypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Teatype record);

    int insertSelective(Teatype record);

    List<Teatype> selectByExample(TeatypeExample example);

    Teatype selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Teatype record, @Param("example") TeatypeExample example);

    int updateByExample(@Param("record") Teatype record, @Param("example") TeatypeExample example);

    int updateByPrimaryKeySelective(Teatype record);

    int updateByPrimaryKey(Teatype record);
    
    List<Teatype> getTeaList();
}
package com.offcn.dao;

import com.offcn.po.CtcExample;
import com.offcn.po.CtcKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CtcMapper {
    long countByExample(CtcExample example);

    int deleteByExample(CtcExample example);

    int deleteByPrimaryKey(CtcKey key);

    int insert(CtcKey record);

    int insertSelective(CtcKey record);

    List<CtcKey> selectByExample(CtcExample example);

    int updateByExampleSelective(@Param("record") CtcKey record, @Param("example") CtcExample example);

    int updateByExample(@Param("record") CtcKey record, @Param("example") CtcExample example);
    
    void insertCtc(List<CtcKey> clist);
    
    List<CtcKey> selectCourse(int claid);
}
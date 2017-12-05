package com.offcn.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.offcn.po.Student;
import com.offcn.po.StudentExample;
import com.offcn.po.StudentExt;

public interface StudentMapper {
    long countByExample(StudentExample example);

    int deleteByExample(StudentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Student record);

    int insertSelective(Student record);

    List<Student> selectByExample(StudentExample example);

    Student selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Student record, @Param("example") StudentExample example);

    int updateByExample(@Param("record") Student record, @Param("example") StudentExample example);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
    
    List<StudentExt> getStuList(@Param("start") int start,@Param("size") int size);
    
    int getCount();
    
    Student getEditStu(int id);
    
    Student seleteById(int id);
    
    List<Student> getCourseById(int id);
    
    int getClassid(int id);
}
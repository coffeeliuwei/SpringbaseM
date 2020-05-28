package com.coffee.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.coffee.entity.Student;

@Repository
public interface IstuDentDao {
  public Student getStudent(int id);
  
  public List<Student> getStufromto(@Param("from")int from,@Param("to")int to);
}

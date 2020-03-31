package com.coffee.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.coffee.dao.IstuDentDao;
import com.coffee.entity.Student;

@Service
public class stuService {
	@Resource
	IstuDentDao dao;
	 public Student getStudent(int id) {
		return dao.getStudent(id);
	}
     public List<Student> getStufromto(int from,int to){
    	 return dao.getStufromto(from, to);
     }
}

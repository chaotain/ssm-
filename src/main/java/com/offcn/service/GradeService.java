package com.offcn.service;

import java.util.List;

import com.offcn.po.Grade;

public interface GradeService {

	List<Grade> getListBySid(int id);
}

package com.cuoikhoa.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cuoikhoa.demo.model.QuyenHan;

@Repository
public interface QuyenHanRepository extends JpaRepository<QuyenHan, Integer>{

}

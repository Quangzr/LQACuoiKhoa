package com.cuoikhoa.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cuoikhoa.demo.model.LoaiKhoaHoc;

@Repository
public interface LoaiKhoaHocRepository extends JpaRepository<LoaiKhoaHoc, Integer>{

}

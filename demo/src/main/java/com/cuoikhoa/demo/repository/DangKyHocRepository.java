package com.cuoikhoa.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cuoikhoa.demo.model.DangKyHoc;

@Repository
public interface DangKyHocRepository extends JpaRepository<DangKyHoc, Integer>{

}

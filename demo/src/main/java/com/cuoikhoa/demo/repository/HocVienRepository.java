package com.cuoikhoa.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cuoikhoa.demo.model.HocVien;

@Repository
public interface HocVienRepository extends JpaRepository<HocVien, Integer>{

}

package com.cuoikhoa.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cuoikhoa.demo.model.BaiViet;

@Repository
public interface BaiVietRepository extends JpaRepository<BaiViet, Integer>{

}

package com.cuoikhoa.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cuoikhoa.demo.model.LoaiBaiViet;

@Repository
public interface LoaiBaiVietRepository extends JpaRepository<LoaiBaiViet, Integer>{

}

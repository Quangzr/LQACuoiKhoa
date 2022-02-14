package com.cuoikhoa.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cuoikhoa.demo.model.TinhTrangHoc;

@Repository
public interface TinhTrangHocRepository extends JpaRepository<TinhTrangHoc, Integer>{

}

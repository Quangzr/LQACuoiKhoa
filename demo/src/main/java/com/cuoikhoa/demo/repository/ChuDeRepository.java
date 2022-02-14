package com.cuoikhoa.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cuoikhoa.demo.model.ChuDe;

@Repository
public interface ChuDeRepository extends JpaRepository<ChuDe, Integer> {

}

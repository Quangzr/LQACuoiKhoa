package com.cuoikhoa.demo.service;

import java.util.Optional;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cuoikhoa.demo.model.LoaiBaiViet;
import com.cuoikhoa.demo.repository.LoaiBaiVietRepository;

@Service
public class LoaiBaiVietService {
	
	@Autowired
	LoaiBaiVietRepository loaiBaiVietRepository;
	
	ValidatorFactory valfac = Validation.buildDefaultValidatorFactory();
	Validator validator = valfac.getValidator();
	//find all
	public Page<LoaiBaiViet> hienThiDanhSach() {
		Pageable pageable = PageRequest.of(0, 3);
		return loaiBaiVietRepository.findAll(pageable);
	}
	
	//add
	@SuppressWarnings("rawtypes")
	public ResponseEntity themLoaiBaiViet(LoaiBaiViet loaiBaiViet) {
		Set<ConstraintViolation<LoaiBaiViet>> violations = validator.validate(loaiBaiViet);
		String strError = "";
		
		for (ConstraintViolation<LoaiBaiViet> violation : violations) {
			strError += violation.getMessage();
		}
		
		if (violations.size() == 0) {
			loaiBaiVietRepository.save(loaiBaiViet);
			return ResponseEntity.ok("Thêm thành công!!");
		}
		
		return ResponseEntity.badRequest().body(strError);
	}
	
	//update
	@SuppressWarnings("rawtypes")
	public ResponseEntity suaLoaiBaiViet(LoaiBaiViet loaiBaiViet) {
		Set<ConstraintViolation<LoaiBaiViet>> violations = validator.validate(loaiBaiViet);
		String strError = "";
		
		for (ConstraintViolation<LoaiBaiViet> violation : violations) {
			strError += violation.getMessage();
		}
		
		if (violations.size() == 0) {
			Optional<LoaiBaiViet> op = loaiBaiVietRepository.findById(loaiBaiViet.getLoaiBaiVietId());
			if (op.isEmpty()) {
				return ResponseEntity.badRequest().body("Loại bài viết không tồn tại!!");
			} else {
				LoaiBaiViet lbv = loaiBaiVietRepository.getById(loaiBaiViet.getLoaiBaiVietId());
				lbv.setTenLoai(loaiBaiViet.getTenLoai());
				
				loaiBaiVietRepository.save(lbv);
				return ResponseEntity.ok("Thêm thành công!!");
			}
		}
		
		return ResponseEntity.badRequest().body(strError);
	}
	
	//delete
	@SuppressWarnings("rawtypes")
	public ResponseEntity xoaLoaiBaiViet(int id) {
		Optional<LoaiBaiViet> op = Optional.empty();
		if (loaiBaiVietRepository.findById(id) == op) {
			ResponseEntity.badRequest().body("Loại bài viết không tồn tại!!");
		} else {
			LoaiBaiViet lbv = loaiBaiVietRepository.getById(id);
			loaiBaiVietRepository.delete(lbv);
		}
		return ResponseEntity.ok("Xóa thành công!!");
	}
}

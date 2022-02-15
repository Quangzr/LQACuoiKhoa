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

import com.cuoikhoa.demo.model.QuyenHan;
import com.cuoikhoa.demo.repository.QuyenHanRepository;

@Service
public class QuyenHanService {
	
	@Autowired
	QuyenHanRepository quyenHanRepository;
	
	ValidatorFactory valfac = Validation.buildDefaultValidatorFactory();
	Validator validator = valfac.getValidator();
	//find all
	public Page<QuyenHan> hienThiDanhSach() {
		Pageable pageable = PageRequest.of(0, 3);
		return quyenHanRepository.findAll(pageable);
	}
	
	//add
	@SuppressWarnings("rawtypes")
	public ResponseEntity themBaiViet(QuyenHan quyenHan) {
		Set<ConstraintViolation<QuyenHan>> violations = validator.validate(quyenHan);
		String strError = "";
		
		for (ConstraintViolation<QuyenHan> violation : violations) {
			strError += violation.getMessage();
		}
		
		if (violations.size() == 0) {
			quyenHanRepository.save(quyenHan);
			return ResponseEntity.ok("Thêm thành công!!");
		}
		
		return ResponseEntity.badRequest().body(strError);
	}
	
	//update
	@SuppressWarnings("rawtypes")
	public ResponseEntity suaBaiViet(QuyenHan quyenHan) {
		Set<ConstraintViolation<QuyenHan>> violations = validator.validate(quyenHan);
		String strError = "";
		
		for (ConstraintViolation<QuyenHan> violation : violations) {
			strError += violation.getMessage();
		}
		
		if (violations.size() == 0) {
			Optional<QuyenHan> op = quyenHanRepository.findById(quyenHan.getQuyenHanId());
			if (op.isEmpty()) {
				return ResponseEntity.badRequest().body("Bài viết không tồn tại!!");
			} else {
				QuyenHan qh = quyenHanRepository.getById(quyenHan.getQuyenHanId());
				qh.setTenQuyenHan(quyenHan.getTenQuyenHan());
				
				quyenHanRepository.save(qh);
				return ResponseEntity.ok("Thêm thành công!!");
			}
		}
		
		return ResponseEntity.badRequest().body(strError);
	}
	
	//delete
		@SuppressWarnings("rawtypes")
		public ResponseEntity xoaLoaiBaiViet(int id) {
			Optional<QuyenHan> op = Optional.empty();
			if (quyenHanRepository.findById(id) == op) {
				ResponseEntity.badRequest().body("Bài viết không tồn tại!!");
			} else {
				QuyenHan lbv = quyenHanRepository.getById(id);
				quyenHanRepository.delete(lbv);
			}
			return ResponseEntity.ok("Xóa thành công!!");
		}
}

package com.cuoikhoa.demo.service;

import java.time.LocalDate;
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

import com.cuoikhoa.demo.model.BaiViet;
import com.cuoikhoa.demo.repository.BaiVietRepository;

@Service
public class BaiVietService {
	
	@Autowired
	BaiVietRepository baiVietRepository;
	
	ValidatorFactory valfac = Validation.buildDefaultValidatorFactory();
	Validator validator = valfac.getValidator();
	//find all
	public Page<BaiViet> hienThiDanhSach() {
		Pageable pageable = PageRequest.of(0, 3);
		return baiVietRepository.findAll(pageable);
	}
	
	//add
	@SuppressWarnings("rawtypes")
	public ResponseEntity themBaiViet(BaiViet baiViet) {
		Set<ConstraintViolation<BaiViet>> violations = validator.validate(baiViet);
		String strError = "";
		
		for (ConstraintViolation<BaiViet> violation : violations) {
			strError += violation.getMessage();
		}
		
		if (violations.size() == 0) {
			baiVietRepository.save(baiViet);
			return ResponseEntity.ok("Thêm thành công!!");
		}
		
		return ResponseEntity.badRequest().body(strError);
	}
	
	//update
	@SuppressWarnings("rawtypes")
	public ResponseEntity suaBaiViet(BaiViet baiViet) {
		Set<ConstraintViolation<BaiViet>> violations = validator.validate(baiViet);
		String strError = "";
		
		for (ConstraintViolation<BaiViet> violation : violations) {
			strError += violation.getMessage();
		}
		
		if (violations.size() == 0) {
			Optional<BaiViet> op = baiVietRepository.findById(baiViet.getBaiVietId());
			if (op.isEmpty()) {
				return ResponseEntity.badRequest().body("Bài viết không tồn tại!!");
			} else {
				BaiViet bv = baiVietRepository.getById(baiViet.getBaiVietId());
				bv.setTenBaiViet(baiViet.getTenBaiViet());
				bv.setTenTacGia(baiViet.getTenTacGia());
				bv.setThoiGianTao(LocalDate.now());
				bv.setChuDe(baiViet.getChuDe());
				bv.setNoiDung(baiViet.getNoiDung());
				bv.setNoiDungNgan(baiViet.getNoiDungNgan());
				bv.setTaiKhoan(baiViet.getTaiKhoan());
				bv.setHinhAnh(baiViet.getHinhAnh());
				
				baiVietRepository.save(bv);
				return ResponseEntity.ok("Thêm thành công!!");
			}
		}
		
		return ResponseEntity.badRequest().body(strError);
	}
	
	//delete
		@SuppressWarnings("rawtypes")
		public ResponseEntity xoaBaiViet(int id) {
			Optional<BaiViet> op = Optional.empty();
			if (baiVietRepository.findById(id) == op) {
				ResponseEntity.badRequest().body("Bài viết không tồn tại!!");
			} else {
				BaiViet bv = baiVietRepository.getById(id);
				baiVietRepository.delete(bv);
			}
			return ResponseEntity.ok("Xóa thành công!!");
		}
}

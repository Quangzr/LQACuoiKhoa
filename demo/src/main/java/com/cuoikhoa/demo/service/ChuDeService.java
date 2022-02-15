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

import com.cuoikhoa.demo.model.ChuDe;
import com.cuoikhoa.demo.repository.ChuDeRepository;

@Service
public class ChuDeService {

	@Autowired
	ChuDeRepository chuDeRepository;

	ValidatorFactory valfac = Validation.buildDefaultValidatorFactory();
	Validator validator = valfac.getValidator();

	// find all
	public Page<ChuDe> hienThiDanhSach() {
		Pageable pageable = PageRequest.of(0, 3);
		return chuDeRepository.findAll(pageable);
	}

	// add
	@SuppressWarnings("rawtypes")
	public ResponseEntity themChuDe(ChuDe chuDe) {
		Set<ConstraintViolation<ChuDe>> violations = validator.validate(chuDe);
		String strError = "";

		for (ConstraintViolation<ChuDe> violation : violations) {
			strError += violation.getMessage();
		}

		if (violations.size() == 0) {
			chuDeRepository.save(chuDe);
			return ResponseEntity.ok("Thêm thành công!!");
		}

		return ResponseEntity.badRequest().body(strError);
	}

	// update
	@SuppressWarnings("rawtypes")
	public ResponseEntity suaChuDe(ChuDe chuDe) {
		Set<ConstraintViolation<ChuDe>> violations = validator.validate(chuDe);
		String strError = "";

		for (ConstraintViolation<ChuDe> violation : violations) {
			strError += violation.getMessage();
		}

		if (violations.size() == 0) {
			Optional<ChuDe> op = chuDeRepository.findById(chuDe.getChuDeId());
			if (op.isEmpty()) {
				return ResponseEntity.badRequest().body("Chủ đề không tồn tại!!");
			} else {
				ChuDe cd = chuDeRepository.getById(chuDe.getChuDeId());
				cd.setTenChuDe(chuDe.getTenChuDe());
				cd.setNoiDung(chuDe.getNoiDung());

				chuDeRepository.save(cd);
				return ResponseEntity.ok("Thêm thành công!!");
			}
		}

		return ResponseEntity.badRequest().body(strError);
	}

	// delete
	@SuppressWarnings("rawtypes")
	public ResponseEntity xoaChuDe(int id) {
		Optional<ChuDe> op = Optional.empty();
		if (chuDeRepository.findById(id) == op) {
			ResponseEntity.badRequest().body("Chủ đề không tồn tại!!");
		} else {
			ChuDe lbv = chuDeRepository.getById(id);
			chuDeRepository.delete(lbv);
		}
		return ResponseEntity.ok("Xóa thành công!!");
	}
}

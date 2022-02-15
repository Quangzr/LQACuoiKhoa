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

import com.cuoikhoa.demo.model.TaiKhoan;
import com.cuoikhoa.demo.repository.TaiKhoanRepository;

@Service
public class TaiKhoanService {

	@Autowired
	TaiKhoanRepository taiKhoanRepository;

	ValidatorFactory valfac = Validation.buildDefaultValidatorFactory();
	Validator validator = valfac.getValidator();

	// find all
	public Page<TaiKhoan> hienThiDanhSach() {
		Pageable pageable = PageRequest.of(0, 3);
		return taiKhoanRepository.findAll(pageable);
	}

	// add
	@SuppressWarnings("rawtypes")
	public ResponseEntity themBaiViet(TaiKhoan taiKhoan) {
		Set<ConstraintViolation<TaiKhoan>> violations = validator.validate(taiKhoan);
		String strError = "";

		for (ConstraintViolation<TaiKhoan> violation : violations) {
			strError += violation.getMessage();
		}

		if (violations.size() == 0) {
			taiKhoanRepository.save(taiKhoan);
			return ResponseEntity.ok("Thêm thành công!!");
		}

		return ResponseEntity.badRequest().body(strError);
	}

	// update
	@SuppressWarnings("rawtypes")
	public ResponseEntity suaBaiViet(TaiKhoan taiKhoan) {
		Set<ConstraintViolation<TaiKhoan>> violations = validator.validate(taiKhoan);
		String strError = "";

		for (ConstraintViolation<TaiKhoan> violation : violations) {
			strError += violation.getMessage();
		}

		if (violations.size() == 0) {
			Optional<TaiKhoan> op = taiKhoanRepository.findById(taiKhoan.getTaiKhoanId());
			if (op.isEmpty()) {
				return ResponseEntity.badRequest().body("Tài Khoản không tồn tại!!");
			} else {
				TaiKhoan tk = taiKhoanRepository.getById(taiKhoan.getTaiKhoanId());
				tk.setTenNguoiDung(taiKhoan.getTenNguoiDung());
				tk.setTenDangNhap(taiKhoan.getTenDangNhap());

				String regex = "^(?=.*[0-9])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>])";
				if (taiKhoan.getMatKhau().matches(regex)) {
					tk.setMatKhau(taiKhoan.getMatKhau());
				} else {
					return ResponseEntity.badRequest().body("Mật khẩu bao gồm cả số và ký tự đặc biệt!!");
				}

				taiKhoanRepository.save(tk);
				return ResponseEntity.ok("Thêm thành công!!");
			}
		}

		return ResponseEntity.badRequest().body(strError);
	}

	// delete
	@SuppressWarnings("rawtypes")
	public ResponseEntity xoaLoaiBaiViet(int id) {
		Optional<TaiKhoan> op = Optional.empty();
		if (taiKhoanRepository.findById(id) == op) {
			ResponseEntity.badRequest().body("Tài Khoản không tồn tại!!");
		} else {
			TaiKhoan lbv = taiKhoanRepository.getById(id);
			taiKhoanRepository.delete(lbv);
		}
		return ResponseEntity.ok("Xóa thành công!!");
	}

	// find by name
	@SuppressWarnings("rawtypes")
	public ResponseEntity timTheoTen(String name) {
		for (TaiKhoan tk : taiKhoanRepository.findAll()) {
			if (tk.getTenDangNhap().toLowerCase().contains(name.toLowerCase())) {
				return ResponseEntity.ok(tk);
			}
		}
		return ResponseEntity.badRequest().body("Tài khoản không tồn tại!!");
	}
}

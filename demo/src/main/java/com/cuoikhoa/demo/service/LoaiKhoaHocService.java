package com.cuoikhoa.demo.service;

import java.util.Optional;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cuoikhoa.demo.model.LoaiKhoaHoc;
import com.cuoikhoa.demo.repository.BaiVietRepository;
import com.cuoikhoa.demo.repository.ChuDeRepository;
import com.cuoikhoa.demo.repository.DangKyHocRepository;
import com.cuoikhoa.demo.repository.HocVienRepository;
import com.cuoikhoa.demo.repository.KhoaHocRepository;
import com.cuoikhoa.demo.repository.LoaiBaiVietRepository;
import com.cuoikhoa.demo.repository.LoaiKhoaHocRepository;
import com.cuoikhoa.demo.repository.QuyenHanRepository;
import com.cuoikhoa.demo.repository.TaiKhoanRepository;
import com.cuoikhoa.demo.repository.TinhTrangHocRepository;
import com.cuoikhoa.demo.model.*;

@Service
public class LoaiKhoaHocService {
	@Autowired
	BaiVietRepository baiVietRepository;

	@Autowired
	ChuDeRepository chuDeRepository;

	@Autowired
	DangKyHocRepository dangKyHocRepository;

	@Autowired
	HocVienRepository hocVienRepository;

	@Autowired
	KhoaHocRepository khoaHocRepository;

	@Autowired
	LoaiBaiVietRepository loaiBaiVietRepository;

	@Autowired
	LoaiKhoaHocRepository loaiKhoaHocRepository;

	@Autowired
	QuyenHanRepository quyenHanRepository;

	@Autowired
	TaiKhoanRepository taiKhoanRepository;

	@Autowired
	TinhTrangHocRepository tinhTrangHocRepository;

	// Get All
	@SuppressWarnings("rawtypes")
	public ResponseEntity getListLoaiKhoaHoc() {
		return ResponseEntity.ok(loaiKhoaHocRepository.findAll());
	}

	// Thêm
	public ResponseEntity<ResponseDTO> ThemLoaiKhoaHoc(LoaiKhoaHoc loaiKhoaHocMoi) {
		ValidatorFactory valfac = Validation.buildDefaultValidatorFactory();
		Validator validator = valfac.getValidator();

		Set<ConstraintViolation<LoaiKhoaHoc>> violations = validator.validate(loaiKhoaHocMoi);
		String strError = ""; // strError dùng để lưu message lỗi
		for (ConstraintViolation<LoaiKhoaHoc> violation : violations) {
			System.out.println(violation.getMessage());
			strError = strError + violation.getMessage() + " \n";
		}

		if (violations.size() == 0) {
			loaiKhoaHocRepository.save(loaiKhoaHocMoi);

			ResponseDTO DTO1 = new ResponseDTO("Thành công", "Thành công", loaiKhoaHocMoi);
			return ResponseEntity.status(HttpStatus.OK).body(DTO1);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDTO("Lỗi", strError, null));
	}

	// Xóa
	public ResponseEntity<ResponseDTO> XoaLoaiKhoaHoc(int maLoaiKhoaHoc) {
		Optional<LoaiKhoaHoc> loaiKhoaHocXoa = loaiKhoaHocRepository.findById(maLoaiKhoaHoc);
		if (loaiKhoaHocXoa.isPresent()) {
			LoaiKhoaHoc loaiKhoaHocXoa1 = loaiKhoaHocRepository.getById(maLoaiKhoaHoc);
			loaiKhoaHocRepository.delete(loaiKhoaHocXoa1);

			ResponseDTO DTO1 = new ResponseDTO("Thành công", "Thành công", loaiKhoaHocXoa1);
			return ResponseEntity.status(HttpStatus.OK).body(DTO1);
		} else {
			System.out.println("Ko có để xóa");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDTO("Lỗi", "Ko có để xóa", null));
		}
	}

	// Update
	public ResponseEntity<ResponseDTO> UpdateLoaiKhoaHoc(LoaiKhoaHoc loaiKhoaHocSua) {
		ValidatorFactory valfac = Validation.buildDefaultValidatorFactory();
		Validator validator = valfac.getValidator();

		Set<ConstraintViolation<LoaiKhoaHoc>> violations = validator.validate(loaiKhoaHocSua);
		String strError = ""; // strError dùng để lưu message lỗi
		for (ConstraintViolation<LoaiKhoaHoc> violation : violations) {
			System.out.println(violation.getMessage());
			strError = strError + violation.getMessage() + " \n";
		}

		if (violations.size() == 0) {
			Optional<LoaiKhoaHoc> loaiKhoaHocCr = loaiKhoaHocRepository.findById(loaiKhoaHocSua.getLoaiKhoaHocId());
			if (loaiKhoaHocCr.isPresent()) {
				LoaiKhoaHoc loaiKhoaHocCr1 = loaiKhoaHocRepository.getById(loaiKhoaHocSua.getLoaiKhoaHocId());
				loaiKhoaHocCr1.setTenLoai(loaiKhoaHocSua.getTenLoai());

				loaiKhoaHocRepository.save(loaiKhoaHocCr1);

				ResponseDTO DTO1 = new ResponseDTO("Thành công", "Thành công", loaiKhoaHocSua);
				return ResponseEntity.status(HttpStatus.OK).body(DTO1);
			} else {
				System.out.println("Ko có để sửa");

				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDTO("Lỗi", "Ko có để sửa", null));
			}
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDTO("Lỗi", strError, null));
	}
}

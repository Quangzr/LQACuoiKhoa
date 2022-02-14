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

import com.cuoikhoa.demo.model.ResponseDTO;
import com.cuoikhoa.demo.model.TinhTrangHoc;
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

@Service
public class TinhTrangHocService {
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
	public ResponseEntity getListTinhTrangHoc() {
		return ResponseEntity.ok(tinhTrangHocRepository.findAll());
	}

	// Thêm
	public ResponseEntity<ResponseDTO> ThemTinhTrangHoc(TinhTrangHoc tinhTrangHocMoi) {
		ValidatorFactory valfac = Validation.buildDefaultValidatorFactory();
		Validator validator = valfac.getValidator();

		Set<ConstraintViolation<TinhTrangHoc>> violations = validator.validate(tinhTrangHocMoi);
		String strError = ""; // strError dùng để lưu message lỗi
		for (ConstraintViolation<TinhTrangHoc> violation : violations) {
			System.out.println(violation.getMessage());
			strError = strError + violation.getMessage() + " \n";
		}

		if (violations.size() == 0) {
			tinhTrangHocRepository.save(tinhTrangHocMoi);

			ResponseDTO DTO1 = new ResponseDTO("Thành công", "Thành công", tinhTrangHocMoi);
			return ResponseEntity.status(HttpStatus.OK).body(DTO1);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDTO("Lỗi", strError, null));
	}

	// Xóa
	public ResponseEntity<ResponseDTO> XoaTinhTrangHoc(int maTinhTrangHoc) {
		Optional<TinhTrangHoc> tinhTrangHocXoa = tinhTrangHocRepository.findById(maTinhTrangHoc);
		if (tinhTrangHocXoa.isPresent()) {
			TinhTrangHoc tinhTrangHocXoa1 = tinhTrangHocRepository.getById(maTinhTrangHoc);
			tinhTrangHocRepository.delete(tinhTrangHocXoa1);

			ResponseDTO DTO1 = new ResponseDTO("Thành công", "Thành công", tinhTrangHocXoa1);
			return ResponseEntity.status(HttpStatus.OK).body(DTO1);
		} else {
			System.out.println("Ko có để xóa");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDTO("Lỗi", "Ko có để xóa", null));
		}
	}

	// Update
	public ResponseEntity<ResponseDTO> UpdateTinhTrangHoc(TinhTrangHoc tinhTrangHocSua) {
		ValidatorFactory valfac = Validation.buildDefaultValidatorFactory();
		Validator validator = valfac.getValidator();

		Set<ConstraintViolation<TinhTrangHoc>> violations = validator.validate(tinhTrangHocSua);
		String strError = ""; // strError dùng để lưu message lỗi
		for (ConstraintViolation<TinhTrangHoc> violation : violations) {
			System.out.println(violation.getMessage());
			strError = strError + violation.getMessage() + " \n";
		}

		if (violations.size() == 0) {
			Optional<TinhTrangHoc> tinhTrangHocCr = tinhTrangHocRepository.findById(tinhTrangHocSua.getTinhTrangHocId());
			if (tinhTrangHocCr.isPresent()) {
				TinhTrangHoc tinhTrangHocCr1 = tinhTrangHocRepository.getById(tinhTrangHocSua.getTinhTrangHocId());
				tinhTrangHocCr1.setTenTinhTrang(tinhTrangHocSua.getTenTinhTrang());;

				tinhTrangHocRepository.save(tinhTrangHocCr1);

				ResponseDTO DTO1 = new ResponseDTO("Thành công", "Thành công", tinhTrangHocSua);
				return ResponseEntity.status(HttpStatus.OK).body(DTO1);
			} else {
				System.out.println("Ko có để sửa");

				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDTO("Lỗi", "Ko có để sửa", null));
			}
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDTO("Lỗi", strError, null));
	}
}

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

import com.cuoikhoa.demo.model.HocVien;
import com.cuoikhoa.demo.model.ResponseDTO;
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
public class HocVienService {
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
	public ResponseEntity getListHocVien() {
		return ResponseEntity.ok(hocVienRepository.findAll());
	}

	// Thêm
	public ResponseEntity<ResponseDTO> ThemHocVien(HocVien hocVienMoi) {
		ValidatorFactory valfac = Validation.buildDefaultValidatorFactory();
		Validator validator = valfac.getValidator();

		Set<ConstraintViolation<HocVien>> violations = validator.validate(hocVienMoi);
		String strError = ""; // strError dùng để lưu message lỗi
		for (ConstraintViolation<HocVien> violation : violations) {
			System.out.println(violation.getMessage());
			strError = strError + violation.getMessage() + " \n";
		}

		if (violations.size() == 0) {
			hocVienRepository.save(hocVienMoi);

			ResponseDTO DTO1 = new ResponseDTO("Thành công", "Thành công", hocVienMoi);
			return ResponseEntity.status(HttpStatus.OK).body(DTO1);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDTO("Lỗi", strError, null));
	}

	// Xóa
	public ResponseEntity<ResponseDTO> XoaHocVien(int maHocVien) {
		Optional<HocVien> hocVienXoa = hocVienRepository.findById(maHocVien);
		if (hocVienXoa.isPresent()) {
			HocVien hocVienXoa1 = hocVienRepository.getById(maHocVien);
			hocVienRepository.delete(hocVienXoa1);

			ResponseDTO DTO1 = new ResponseDTO("Thành công", "Thành công", hocVienXoa1);
			return ResponseEntity.status(HttpStatus.OK).body(DTO1);
		} else {
			System.out.println("Ko có để xóa");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDTO("Lỗi", "Ko có để xóa", null));
		}
	}

	// Update
	public ResponseEntity<ResponseDTO> UpdateHocVien(HocVien hocVienSua) {
		ValidatorFactory valfac = Validation.buildDefaultValidatorFactory();
		Validator validator = valfac.getValidator();

		Set<ConstraintViolation<HocVien>> violations = validator.validate(hocVienSua);
		String strError = ""; // strError dùng để lưu message lỗi
		for (ConstraintViolation<HocVien> violation : violations) {
			System.out.println(violation.getMessage());
			strError = strError + violation.getMessage() + " \n";
		}

		if (violations.size() == 0) {
			Optional<HocVien> hocVienCr = hocVienRepository.findById(hocVienSua.getHocVienId());
			if (hocVienCr.isPresent()) {
				HocVien hocVienCr1 = hocVienRepository.getById(hocVienSua.getHocVienId());
				hocVienCr1.setHinhAnh(hocVienSua.getHinhAnh());
				hocVienCr1.setHoTen(hocVienSua.getHoTen());
				hocVienCr1.setNgaySinh(hocVienSua.getNgaySinh());
				
				hocVienCr1.setEmail(hocVienSua.getEmail());
				hocVienCr1.setSoDienThoai(hocVienSua.getSoDienThoai());
				
				hocVienCr1.setTinhThanh(hocVienSua.getTinhThanh());
				hocVienCr1.setQuanHuyen(hocVienSua.getQuanHuyen());
				hocVienCr1.setPhuongXa(hocVienSua.getPhuongXa());
				hocVienCr1.setSoNha(hocVienSua.getSoNha());

				hocVienRepository.save(hocVienCr1);

				ResponseDTO DTO1 = new ResponseDTO("Thành công", "Thành công", hocVienSua);
				return ResponseEntity.status(HttpStatus.OK).body(DTO1);
			} else {
				System.out.println("Ko có để sửa");

				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDTO("Lỗi", "Ko có để sửa", null));
			}
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDTO("Lỗi", strError, null));
	}
}

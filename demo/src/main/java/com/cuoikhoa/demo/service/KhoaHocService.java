package com.cuoikhoa.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cuoikhoa.demo.model.DangKyHoc;
import com.cuoikhoa.demo.model.KhoaHoc;
import com.cuoikhoa.demo.model.LoaiKhoaHoc;
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
public class KhoaHocService {
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
	
	// Cập nhật số học viên
	public int CapNhatSoHocVien(KhoaHoc khoaHoc) {
		int maKhoaHoc = khoaHoc.getKhoaHocId();
		int count = 0;
		
		for(DangKyHoc dangKyHoc : dangKyHocRepository.findAll()) {
			if(dangKyHoc.getKhoaHoc().getKhoaHocId() == maKhoaHoc && dangKyHoc.getTinhTrangHoc().getTinhTrangHocId() != 1) {
				count = count + 1;
			}
		}
		
		return count;
	}

	// Tìm kiếm theo tên (có phân trang)
	@SuppressWarnings("rawtypes")
	public ResponseEntity TimKiemTheoTen(String tenCanTim) {
		List<KhoaHoc> listKhoaHocs = khoaHocRepository.findAll();
		List<KhoaHoc> listKhoaHocCanTim = new ArrayList<>();

		for (KhoaHoc khoaHoc : listKhoaHocs) {
			if (khoaHoc.getTenKhoaHoc().contains(tenCanTim)) {
				listKhoaHocCanTim.add(khoaHoc);
			}
		}
		return ResponseEntity.ok(listKhoaHocCanTim);
	}

	// Phân trang danh sách
	@SuppressWarnings("rawtypes")
	public ResponseEntity PhanTrangKhoaHoc() {
		Pageable pageable = PageRequest.of(0, 2);
		return ResponseEntity.ok(khoaHocRepository.findAll(pageable));
	}

	// Get All
	@SuppressWarnings("rawtypes")
	public ResponseEntity getListKhoaHoc() {
		return ResponseEntity.ok(khoaHocRepository.findAll());
	}

	// Thêm
	public ResponseEntity<ResponseDTO> ThemKhoaHoc(KhoaHoc khoaHocMoi) {
		ValidatorFactory valfac = Validation.buildDefaultValidatorFactory();
		Validator validator = valfac.getValidator();

		Set<ConstraintViolation<KhoaHoc>> violations = validator.validate(khoaHocMoi);
		String strError = ""; // strError dùng để lưu message lỗi
		for (ConstraintViolation<KhoaHoc> violation : violations) {
			System.out.println(violation.getMessage());
			strError = strError + violation.getMessage() + " \n";
		}

		if (violations.size() == 0) {
			khoaHocRepository.save(khoaHocMoi);

			ResponseDTO DTO1 = new ResponseDTO("Thành công", "Thành công", khoaHocMoi);
			return ResponseEntity.status(HttpStatus.OK).body(DTO1);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDTO("Lỗi", strError, null));
	}

	// Xóa
	public ResponseEntity<ResponseDTO> XoaKhoaHoc(int maKhoaHoc) {
		Optional<KhoaHoc> khoaHocXoa = khoaHocRepository.findById(maKhoaHoc);
		if (khoaHocXoa.isPresent()) {
			KhoaHoc khoaHocXoa1 = khoaHocRepository.getById(maKhoaHoc);
			khoaHocRepository.delete(khoaHocXoa1);

			ResponseDTO DTO1 = new ResponseDTO("Thành công", "Thành công", khoaHocXoa1);
			return ResponseEntity.status(HttpStatus.OK).body(DTO1);
		} else {
			System.out.println("Ko có để xóa");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDTO("Lỗi", "Ko có để xóa", null));
		}
	}

	// Update
	public ResponseEntity<ResponseDTO> UpdateKhoaHoc(KhoaHoc khoaHocSua) {
		ValidatorFactory valfac = Validation.buildDefaultValidatorFactory();
		Validator validator = valfac.getValidator();

		Set<ConstraintViolation<KhoaHoc>> violations = validator.validate(khoaHocSua);
		String strError = ""; // strError dùng để lưu message lỗi
		for (ConstraintViolation<KhoaHoc> violation : violations) {
			System.out.println(violation.getMessage());
			strError = strError + violation.getMessage() + " \n";
		}

		if (violations.size() == 0) {
			Optional<KhoaHoc> khoaHocCr = khoaHocRepository.findById(khoaHocSua.getKhoaHocId());
			Optional<LoaiKhoaHoc> loaiKhoaHocSua = loaiKhoaHocRepository.findById(khoaHocSua.getLoaiKhoaHoc().getLoaiKhoaHocId());

			if (loaiKhoaHocSua.isEmpty()) {
				System.out.println("Loại khóa học ko tồn tại");

				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDTO("Lỗi", "Loại khóa học ko tồn tại", null));
			}

			if (khoaHocCr.isPresent()) {
				KhoaHoc khoaHocCr1 = khoaHocRepository.getById(khoaHocSua.getKhoaHocId());
				khoaHocCr1.setTenKhoaHoc(khoaHocSua.getTenKhoaHoc());
				khoaHocCr1.setThoiGianHoc(khoaHocSua.getThoiGianHoc());
				khoaHocCr1.setGioiThieu(khoaHocSua.getGioiThieu());
				khoaHocCr1.setNoiDung(khoaHocSua.getNoiDung());
				khoaHocCr1.setHocPhi(khoaHocSua.getHocPhi());

//				khoaHocCr1.setSoHocVien(khoaHocSua.getSoHocVien());

				khoaHocCr1.setSoLuongMon(khoaHocSua.getSoLuongMon());
				khoaHocCr1.setHinhAnh(khoaHocSua.getHinhAnh());
				khoaHocCr1.setLoaiKhoaHoc(khoaHocSua.getLoaiKhoaHoc());

				khoaHocRepository.save(khoaHocCr1);

				ResponseDTO DTO1 = new ResponseDTO("Thành công", "Thành công", khoaHocSua);
				return ResponseEntity.status(HttpStatus.OK).body(DTO1);
			} else {
				System.out.println("Ko có để sửa");

				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDTO("Lỗi", "Ko có để sửa", null));
			}
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDTO("Lỗi", strError, null));
	}
}

package com.cuoikhoa.demo.service;

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
import com.cuoikhoa.demo.model.HocVien;
import com.cuoikhoa.demo.model.KhoaHoc;
import com.cuoikhoa.demo.model.ResponseDTO;
import com.cuoikhoa.demo.model.TaiKhoan;
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
public class DangKyHocService {
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

		for (DangKyHoc dangKyHoc : dangKyHocRepository.findAll()) {
			if (dangKyHoc.getKhoaHoc().getKhoaHocId() == maKhoaHoc && dangKyHoc.getTinhTrangHoc().getTinhTrangHocId() != 1) {
				count = count + 1;
			}
		}

		return count;
	}

	// Phân trang danh sách
	@SuppressWarnings("rawtypes")
	public ResponseEntity PhanTrangDangKyHoc() {
		Pageable pageable = PageRequest.of(0, 2);
		return ResponseEntity.ok(dangKyHocRepository.findAll(pageable));
	}

	// Get All
	@SuppressWarnings("rawtypes")
	public ResponseEntity getListDangKyHoc() {
		return ResponseEntity.ok(dangKyHocRepository.findAll());
	}

	// Thêm
	public ResponseEntity<ResponseDTO> ThemDangKyHoc(DangKyHoc dangKyHocMoi) {
		ValidatorFactory valfac = Validation.buildDefaultValidatorFactory();
		Validator validator = valfac.getValidator();

		Set<ConstraintViolation<DangKyHoc>> violations = validator.validate(dangKyHocMoi);
		String strError = ""; // strError dùng để lưu message lỗi
		for (ConstraintViolation<DangKyHoc> violation : violations) {
			System.out.println(violation.getMessage());
			strError = strError + violation.getMessage() + " \n";
		}

		if (violations.size() == 0) {
			Optional<KhoaHoc> khoaHocCr = khoaHocRepository.findById(dangKyHocMoi.getKhoaHoc().getKhoaHocId());
			Optional<HocVien> hocVienCr = hocVienRepository.findById(dangKyHocMoi.getHocVien().getHocVienId());
			Optional<TinhTrangHoc> tinhTrangHocCr = tinhTrangHocRepository.findById(dangKyHocMoi.getTinhTrangHoc().getTinhTrangHocId());
//			Optional<TaiKhoan> taiKhoanCr = taiKhoanRepository.findById(dangKyHocMoi.getTaiKhoan().getTaiKhoanId());

			if (khoaHocCr.isEmpty()) {
				System.out.println("Khóa học ko tồn tại");

				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDTO("Lỗi", "Khóa học ko tồn tại", null));
			}
			
			if (hocVienCr.isEmpty()) {
				System.out.println("Học viên ko tồn tại");

				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDTO("Lỗi", "Học viên ko tồn tại", null));
			}
			
			if (tinhTrangHocCr.isEmpty()) {
				System.out.println("Tình trạng học ko tồn tại");

				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDTO("Lỗi", "Tình trạng học ko tồn tại", null));
			}
			
//			if (taiKhoanCr.isEmpty()) {
//				System.out.println("Tài khoản ko tồn tại");
//
//				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDTO("Lỗi", "Tài khoản ko tồn tại", null));
//			}

			if (hocVienCr.isPresent() && tinhTrangHocCr.isPresent() && khoaHocCr.isPresent()) {
				TinhTrangHoc tinhTrangHocMacDinh = tinhTrangHocRepository.getById(1);
				
				DangKyHoc dangKyHocMoi1 = new DangKyHoc();
				dangKyHocMoi1.setHocVien(dangKyHocMoi.getHocVien());
				dangKyHocMoi1.setNgayBatDau(dangKyHocMoi.getNgayBatDau());
				dangKyHocMoi1.setNgayKetThuc(dangKyHocMoi.getNgayKetThuc());
				dangKyHocMoi1.setNgayDangKy(dangKyHocMoi.getNgayDangKy());
				dangKyHocMoi1.setTinhTrangHoc(tinhTrangHocMacDinh);
				dangKyHocMoi1.setKhoaHoc(dangKyHocMoi.getKhoaHoc());
				
				dangKyHocRepository.save(dangKyHocMoi1);

				ResponseDTO DTO1 = new ResponseDTO("Thành công", "Thành công", dangKyHocMoi1);
				return ResponseEntity.status(HttpStatus.OK).body(DTO1);
			}
			
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDTO("Lỗi", strError, null));
	}

	// Xóa
	public ResponseEntity<ResponseDTO> XoaDangKyHoc(int maDangKyHoc) {
		Optional<DangKyHoc> dangKyHocXoa = dangKyHocRepository.findById(maDangKyHoc);
		if (dangKyHocXoa.isPresent()) {
			DangKyHoc dangKyHocXoa1 = dangKyHocRepository.getById(maDangKyHoc);
			dangKyHocRepository.delete(dangKyHocXoa1);

			ResponseDTO DTO1 = new ResponseDTO("Thành công", "Thành công", dangKyHocXoa1);
			return ResponseEntity.status(HttpStatus.OK).body(DTO1);
		} else {
			System.out.println("Ko có để xóa");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDTO("Lỗi", "Ko có để xóa", null));
		}
	}

	// Update
	public ResponseEntity<ResponseDTO> UpdateDangKyHoc(DangKyHoc dangKyHocSua) {
		ValidatorFactory valfac = Validation.buildDefaultValidatorFactory();
		Validator validator = valfac.getValidator();

		Set<ConstraintViolation<DangKyHoc>> violations = validator.validate(dangKyHocSua);
		String strError = ""; // strError dùng để lưu message lỗi
		for (ConstraintViolation<DangKyHoc> violation : violations) {
			System.out.println(violation.getMessage());
			strError = strError + violation.getMessage() + " \n";
		}

		if (violations.size() == 0) {
			Optional<DangKyHoc> dangKyHocCr = dangKyHocRepository.findById(dangKyHocSua.getDangKyHocId());
			Optional<KhoaHoc> khoaHocCr = khoaHocRepository.findById(dangKyHocSua.getKhoaHoc().getKhoaHocId());
			Optional<HocVien> hocVienCr = hocVienRepository.findById(dangKyHocSua.getHocVien().getHocVienId());
			Optional<TinhTrangHoc> tinhTrangHocCr = tinhTrangHocRepository.findById(dangKyHocSua.getTinhTrangHoc().getTinhTrangHocId());
			Optional<TaiKhoan> taiKhoanCr = taiKhoanRepository.findById(dangKyHocSua.getTaiKhoan().getTaiKhoanId());

			if (khoaHocCr.isEmpty()) {
				System.out.println("Khóa học ko tồn tại");

				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDTO("Lỗi", "Khóa học ko tồn tại", null));
			}
			
			if (hocVienCr.isEmpty()) {
				System.out.println("Học viên ko tồn tại");

				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDTO("Lỗi", "Học viên ko tồn tại", null));
			}
			
			if (tinhTrangHocCr.isEmpty()) {
				System.out.println("Tình trạng học ko tồn tại");

				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDTO("Lỗi", "Tình trạng học ko tồn tại", null));
			}
			
			if (taiKhoanCr.isEmpty()) {
				System.out.println("Tài khoản ko tồn tại");

				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDTO("Lỗi", "Tài khoản ko tồn tại", null));
			}
			
			if (dangKyHocCr.isPresent()) {
				DangKyHoc dangKyHocCr1 = dangKyHocRepository.getById(dangKyHocSua.getDangKyHocId());
				dangKyHocCr1.setKhoaHoc(dangKyHocSua.getKhoaHoc());
				dangKyHocCr1.setHocVien(dangKyHocSua.getHocVien());
				dangKyHocCr1.setNgayDangKy(dangKyHocSua.getNgayDangKy());
				dangKyHocCr1.setNgayBatDau(dangKyHocSua.getNgayBatDau());
				dangKyHocCr1.setNgayKetThuc(dangKyHocSua.getNgayKetThuc());
				dangKyHocCr1.setTaiKhoan(dangKyHocSua.getTaiKhoan());
				
				if (dangKyHocCr1.getTinhTrangHoc().getTinhTrangHocId() == 1) {
					if(dangKyHocSua.getTinhTrangHoc().getTinhTrangHocId() == 3 || dangKyHocSua.getTinhTrangHoc().getTinhTrangHocId() == 4) {
						System.out.println("Học viên chưa bắt đầu khóa học nên ko thể hoàn thành hay chưa hoàn thành khóa học");

						return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDTO("Lỗi", "Ko có để sửa", null));
					} else {
						dangKyHocCr1.setTinhTrangHoc(dangKyHocSua.getTinhTrangHoc());
					}
				} else {
					dangKyHocCr1.setTinhTrangHoc(dangKyHocSua.getTinhTrangHoc());
				}

				dangKyHocRepository.save(dangKyHocCr1);
				
				// cập nhật học viên
				KhoaHoc khoaHoc = khoaHocRepository.getById(dangKyHocCr1.getKhoaHoc().getKhoaHocId());
				CapNhatSoHocVien(khoaHoc);

				ResponseDTO DTO1 = new ResponseDTO("Thành công", "Thành công", dangKyHocSua);
				return ResponseEntity.status(HttpStatus.OK).body(DTO1);
			} else {
				System.out.println("Ko có để sửa");

				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDTO("Lỗi", "Ko có để sửa", null));
			}
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDTO("Lỗi", strError, null));
	}
}

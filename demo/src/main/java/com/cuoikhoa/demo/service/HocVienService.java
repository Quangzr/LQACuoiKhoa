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

	// Check trùng SĐT và Email
	public boolean checkPhoneAndMail(HocVien hocVien) {
		boolean check = true; //false là bị trùng
		for(HocVien hocVienRepo : hocVienRepository.findAll()) {
			if(hocVienRepo.getEmail().equals(hocVien.getEmail()) || hocVienRepo.getSoDienThoai().equals(hocVien.getSoDienThoai())) {
				System.out.println("Email hoặc SĐT bị trùng");
				check = false;
			} 
		}
		return check;
	}
	
	// Validate tên
	public String validateTen(String ten) {
		ten = ten.trim();
		String[] words = ten.split(" ");
		String name = new String();
		for (String w : words) {
			// tạo hai chuỗi con firstLetter và remainingLetters
			// chuỗi firstLetter chứa chữ cái đầu tiên của name
			String firstLetter = w.substring(0, 1);
			// chuỗi remainingLetters chứa phần còn lại của name
			String remainingLetters = w.substring(1, w.length());

			// sử dụng phương thức toUpperCase() để chuyển đổi firstLetter thành chữ in hoa
			firstLetter = firstLetter.toUpperCase();

			// sau khi chuyển đổi thì gộp chúng lại
			w = firstLetter + remainingLetters;
			name = name + w + " ";
		}
		return name;
	}

	// Tìm kiếm theo tên (có phân trang)
	@SuppressWarnings("rawtypes")
	public ResponseEntity TimKiemTheoTen(String tenCanTim) {
		List<HocVien> listHocViens = hocVienRepository.findAll();
		List<HocVien> listHocVienCanTim = new ArrayList<>();
		
		for(HocVien hocVien : listHocViens) {
			if(hocVien.getHoTen().contains(tenCanTim)) {
				listHocVienCanTim.add(hocVien);
			}
		}
		return ResponseEntity.ok(listHocVienCanTim);
	}
	
	// Tìm kiếm theo tên và mail (có phân trang)
	@SuppressWarnings("rawtypes")
	public ResponseEntity TimKiemTheoTenVaMail(String tenCanTim, String emailCanTim) {
		List<HocVien> listHocViens = hocVienRepository.findAll();
		List<HocVien> listHocVienTheoTen = new ArrayList<>();
		List<HocVien> listHocVienCanTim = new ArrayList<>();
		
		// lọc theo tên
		for(HocVien hocVien : listHocViens) {
			if(hocVien.getHoTen().contains(tenCanTim)) {
				listHocVienTheoTen.add(hocVien);
			}
		}
		
		// lọc theo mail
		for(HocVien hocVien : listHocVienTheoTen) {
			if(hocVien.getHoTen().contains(tenCanTim)) {
				listHocVienCanTim.add(hocVien);
			}
		}
		
		return ResponseEntity.ok(listHocVienCanTim);
	}
	
	// Phân trang danh sách 
	@SuppressWarnings("rawtypes")
	public ResponseEntity PhanTrangHocVien() {
		Pageable pageable = PageRequest.of(0, 2);
		return ResponseEntity.ok(hocVienRepository.findAll(pageable)); 
	}

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
			if (checkPhoneAndMail(hocVienMoi) == false) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDTO("Lỗi", "Email hoặc SĐT bị trùng", null));
			} else {
				hocVienMoi.setHoTen(validateTen(hocVienMoi.getHoTen()));
				hocVienRepository.save(hocVienMoi);

				ResponseDTO DTO1 = new ResponseDTO("Thành công", "Thành công", hocVienMoi);
				return ResponseEntity.status(HttpStatus.OK).body(DTO1);
			}
			
//			hocVienMoi.setHoTen(validateTen(hocVienMoi.getHoTen()));
//			hocVienRepository.save(hocVienMoi);
//
//			ResponseDTO DTO1 = new ResponseDTO("Thành công", "Thành công", hocVienMoi);
//			return ResponseEntity.status(HttpStatus.OK).body(DTO1);
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
				
				if (checkPhoneAndMail(hocVienCr1) == false) { // nếu bị trùng email hoặc SĐT
					return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDTO("Lỗi", "Email hoặc SĐT bị trùng", null));
				} else { // ko bị trùng email hoặc SĐT
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
				}
			} else {
				System.out.println("Ko có để sửa");

				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDTO("Lỗi", "Ko có để sửa", null));
			}
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDTO("Lỗi", strError, null));
	}
}

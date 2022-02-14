package com.cuoikhoa.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
import com.cuoikhoa.demo.service.BaiVietService;
import com.cuoikhoa.demo.service.ChuDeService;
import com.cuoikhoa.demo.service.DangKyHocService;
import com.cuoikhoa.demo.service.HocVienService;
import com.cuoikhoa.demo.service.KhoaHocService;
import com.cuoikhoa.demo.service.LoaiBaiVietService;
import com.cuoikhoa.demo.service.LoaiKhoaHocService;
import com.cuoikhoa.demo.service.QuyenHanService;
import com.cuoikhoa.demo.service.TaiKhoanService;
import com.cuoikhoa.demo.service.TinhTrangHocService;
import com.cuoikhoa.demo.model.*;

@RestController
public class LoaiKhoaHocController {
	// Autowired Repository
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

	// Autowired Service
	@Autowired
	BaiVietService baiVietService;

	@Autowired
	ChuDeService chuDeService;

	@Autowired
	DangKyHocService dangKyHocService;

	@Autowired
	HocVienService hocVienService;

	@Autowired
	KhoaHocService khoaHocService;

	@Autowired
	LoaiBaiVietService loaiBaiVietService;

	@Autowired
	LoaiKhoaHocService loaiKhoaHocService;

	@Autowired
	QuyenHanService quyenHanService;

	@Autowired
	TaiKhoanService taiKhoanService;

	@Autowired
	TinhTrangHocService tinhTrangHocService;

	// Get All
	@SuppressWarnings("rawtypes")
	@GetMapping(value = "/loaikhoahoc/getall")
	public ResponseEntity getListLoaiKhoaHocController() {
		return ResponseEntity.ok(loaiKhoaHocService.getListLoaiKhoaHoc());
	}

	// Thêm
	@PostMapping(value = "/loaikhoahoc/them")
	public ResponseEntity<ResponseDTO> ThemLoaiKhoaHocController(@RequestBody LoaiKhoaHoc loaiKhoaHocMoi) {
		return loaiKhoaHocService.ThemLoaiKhoaHoc(loaiKhoaHocMoi);
	}

	// Xóa
	@DeleteMapping(value = "/loaikhoahoc/xoa")
	public ResponseEntity<ResponseDTO> XoaLoaiKhoaHocController(@RequestParam int maLoaiKhoaHoc) {
		return loaiKhoaHocService.XoaLoaiKhoaHoc(maLoaiKhoaHoc);
	}

	// Sửa
	@PutMapping(value = "/loaikhoahoc/sua")
	public ResponseEntity<ResponseDTO> SuaLoaiKhoaHocController(@RequestBody LoaiKhoaHoc loaiKhoaHocSua) {
		return loaiKhoaHocService.UpdateLoaiKhoaHoc(loaiKhoaHocSua);
	}
}

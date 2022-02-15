package com.cuoikhoa.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cuoikhoa.demo.model.TaiKhoan;
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

@RestController
@RequestMapping(value = "/taikhoan")
public class TaiKhoanController {

		@Autowired
		TaiKhoanService taiKhoanService;

		@SuppressWarnings("rawtypes")
		@GetMapping(value = "/danhsach")
		public ResponseEntity hienThiDanhSach() {
			return ResponseEntity.ok(taiKhoanService.hienThiDanhSach());
		}

		@SuppressWarnings("rawtypes")
		@PostMapping(value = "/them")
		public ResponseEntity themBaiViet(TaiKhoan taiKhoan) {
			return ResponseEntity.ok(taiKhoanService.themTaiKhoan(taiKhoan));
		}

		@SuppressWarnings("rawtypes")
		@PutMapping(value = "/sua")
		public ResponseEntity suaBaiViet(TaiKhoan taiKhoan) {
			return ResponseEntity.ok(taiKhoanService.suaTaiKhoan(taiKhoan));
		}

		@SuppressWarnings("rawtypes")
		@DeleteMapping(value = "/xoa")
		public ResponseEntity xoaBaiViet(int id) {
			return ResponseEntity.ok(taiKhoanService.xoaTaiKhoan(id));
		}

		@SuppressWarnings("rawtypes")
		@GetMapping(value = "/searchbyname")
		public ResponseEntity timTheoTen(String name) {
			return ResponseEntity.ok(taiKhoanService.timTheoTen(name));
		}
}

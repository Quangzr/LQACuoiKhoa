package com.cuoikhoa.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cuoikhoa.demo.model.QuyenHan;
import com.cuoikhoa.demo.service.QuyenHanService;

@RestController
@RequestMapping(value = "/quyenhan")
public class QuyenHanController {

		@Autowired
		QuyenHanService quyenHanService;
		
		@SuppressWarnings("rawtypes")
		@GetMapping(value = "/danhsach")
		public ResponseEntity hienThiDanhSach() {
			return ResponseEntity.ok(quyenHanService.hienThiDanhSach());
		}

		@SuppressWarnings("rawtypes")
		@PostMapping(value = "/them")
		public ResponseEntity themBaiViet(QuyenHan quyenHan) {
			return ResponseEntity.ok(quyenHanService.themQuyenHan(quyenHan));
		}

		@SuppressWarnings("rawtypes")
		@PutMapping(value = "/sua")
		public ResponseEntity suaBaiViet(QuyenHan quyenHan) {
			return ResponseEntity.ok(quyenHanService.suaQuyenHan(quyenHan));
		}

		@SuppressWarnings("rawtypes")
		@DeleteMapping(value = "/xoa")
		public ResponseEntity xoaBaiViet(int id) {
			return ResponseEntity.ok(quyenHanService.xoaQuyenHan(id));
		}
}

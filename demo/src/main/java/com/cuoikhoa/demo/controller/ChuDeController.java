package com.cuoikhoa.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cuoikhoa.demo.model.ChuDe;
import com.cuoikhoa.demo.service.ChuDeService;

@RestController
@RequestMapping(value = "/chude")

public class ChuDeController {
		@Autowired
		ChuDeService chuDeService;
		
		@SuppressWarnings("rawtypes")
		@GetMapping(value = "/danhsach")
		public ResponseEntity hienThiDanhSach() {
			return ResponseEntity.ok(chuDeService.hienThiDanhSach());
		}

		@SuppressWarnings("rawtypes")
		@PostMapping(value = "/them")
		public ResponseEntity themBaiViet(ChuDe chuDe) {
			return ResponseEntity.ok(chuDeService.themChuDe(chuDe));
		}

		@SuppressWarnings("rawtypes")
		@PutMapping(value = "/sua")
		public ResponseEntity suaBaiViet(ChuDe chuDe) {
			return ResponseEntity.ok(chuDeService.suaChuDe(chuDe));
		}

		@SuppressWarnings("rawtypes")
		@DeleteMapping(value = "/xoa")
		public ResponseEntity xoaBaiViet(int id) {
			return ResponseEntity.ok(chuDeService.xoaChuDe(id));
		}
}

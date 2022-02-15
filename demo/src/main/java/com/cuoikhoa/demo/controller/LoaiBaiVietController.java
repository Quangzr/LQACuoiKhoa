package com.cuoikhoa.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cuoikhoa.demo.model.LoaiBaiViet;
import com.cuoikhoa.demo.service.LoaiBaiVietService;

@RestController
@RequestMapping(value = "/loaibaiviet")
public class LoaiBaiVietController {

		@Autowired
		LoaiBaiVietService loaiBaiVietService;
		
		@SuppressWarnings("rawtypes")
		@GetMapping(value = "/danhsach")
		public ResponseEntity hienThiDanhSach() {
			return ResponseEntity.ok(loaiBaiVietService.hienThiDanhSach());
		}

		@SuppressWarnings("rawtypes")
		@PostMapping(value = "/them")
		public ResponseEntity themBaiViet(LoaiBaiViet loaiBaiViet) {
			return ResponseEntity.ok(loaiBaiVietService.themLoaiBaiViet(loaiBaiViet));
		}

		@SuppressWarnings("rawtypes")
		@PutMapping(value = "/sua")
		public ResponseEntity suaBaiViet(LoaiBaiViet loaiBaiViet) {
			return ResponseEntity.ok(loaiBaiVietService.suaLoaiBaiViet(loaiBaiViet));
		}

		@SuppressWarnings("rawtypes")
		@DeleteMapping(value = "/xoa")
		public ResponseEntity xoaBaiViet(int id) {
			return ResponseEntity.ok(loaiBaiVietService.xoaLoaiBaiViet(id));
		}
}

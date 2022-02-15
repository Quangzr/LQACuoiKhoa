package com.cuoikhoa.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cuoikhoa.demo.model.BaiViet;
import com.cuoikhoa.demo.service.BaiVietService;

@RestController
@RequestMapping(value = "/baiviet")
public class BaiVietController {
	@Autowired
	BaiVietService baiVietService;
	
	@SuppressWarnings("rawtypes")
	@GetMapping(value = "/danhsach")
	public ResponseEntity hienThiDanhSach() {
		return ResponseEntity.ok(baiVietService.hienThiDanhSach());
	}
	
	@SuppressWarnings("rawtypes")
	@PostMapping(value = "/them")
	public ResponseEntity themBaiViet(BaiViet baiViet) {
		return ResponseEntity.ok(baiVietService.themBaiViet(baiViet));
	}
	
	@SuppressWarnings("rawtypes")
	@PutMapping(value = "/sua")
	public ResponseEntity suaBaiViet(BaiViet baiViet) {
		return ResponseEntity.ok(baiVietService.suaBaiViet(baiViet));
	}
	
	@SuppressWarnings("rawtypes")
	@DeleteMapping(value = "/xoa")
	public ResponseEntity xoaBaiViet(int id) {
		return ResponseEntity.ok(baiVietService.xoaBaiViet(id));
	}
}

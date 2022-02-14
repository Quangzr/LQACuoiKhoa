package com.cuoikhoa.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class ChuDeService {
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
	
}

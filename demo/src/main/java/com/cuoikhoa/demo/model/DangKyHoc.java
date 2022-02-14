package com.cuoikhoa.demo.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Table
@Entity
public class DangKyHoc {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int dangKyHocId;
	
	@Column
	private LocalDate ngayBatDau;
	
	@Column
	private LocalDate ngayDangKy;
	
	@Column
	private LocalDate ngayKetThuc;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tinhTrangHocId")
	@JsonIgnoreProperties(value = "dangKyHocs")
	TinhTrangHoc tinhTrangHoc;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "hocVienId")
	@JsonIgnoreProperties(value = "dangKyHocs")
	HocVien hocVien;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "taiKhoanId")
	@JsonIgnoreProperties(value = "dangKyHocs")
	TaiKhoan taiKhoan;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "khoaHocId")
	@JsonIgnoreProperties(value = "dangKyHocs")
	KhoaHoc khoaHoc;

	public int getDangKyHocId() {
		return dangKyHocId;
	}

	public void setDangKyHocId(int dangKyHocId) {
		this.dangKyHocId = dangKyHocId;
	}

	public LocalDate getNgayBatDau() {
		return ngayBatDau;
	}

	public void setNgayBatDau(LocalDate ngayBatDau) {
		this.ngayBatDau = ngayBatDau;
	}

	public LocalDate getNgayDangKy() {
		return ngayDangKy;
	}

	public void setNgayDangKy(LocalDate ngayDangKy) {
		this.ngayDangKy = ngayDangKy;
	}

	public LocalDate getNgayKetThuc() {
		return ngayKetThuc;
	}

	public void setNgayKetThuc(LocalDate ngayKetThuc) {
		this.ngayKetThuc = ngayKetThuc;
	}

	public TinhTrangHoc getTinhTrangHoc() {
		return tinhTrangHoc;
	}

	public void setTinhTrangHoc(TinhTrangHoc tinhTrangHoc) {
		this.tinhTrangHoc = tinhTrangHoc;
	}

	public HocVien getHocVien() {
		return hocVien;
	}

	public void setHocVien(HocVien hocVien) {
		this.hocVien = hocVien;
	}

	public TaiKhoan getTaiKhoan() {
		return taiKhoan;
	}

	public void setTaiKhoan(TaiKhoan taiKhoan) {
		this.taiKhoan = taiKhoan;
	}

	public KhoaHoc getKhoaHoc() {
		return khoaHoc;
	}

	public void setKhoaHoc(KhoaHoc khoaHoc) {
		this.khoaHoc = khoaHoc;
	}

	public DangKyHoc(int dangKyHocId, LocalDate ngayBatDau, LocalDate ngayDangKy, LocalDate ngayKetThuc,
			TinhTrangHoc tinhTrangHoc, HocVien hocVien, TaiKhoan taiKhoan, KhoaHoc khoaHoc) {
		this.dangKyHocId = dangKyHocId;
		this.ngayBatDau = ngayBatDau;
		this.ngayDangKy = ngayDangKy;
		this.ngayKetThuc = ngayKetThuc;
		this.tinhTrangHoc = tinhTrangHoc;
		this.hocVien = hocVien;
		this.taiKhoan = taiKhoan;
		this.khoaHoc = khoaHoc;
	}
	
	public DangKyHoc() {
	
	}
}
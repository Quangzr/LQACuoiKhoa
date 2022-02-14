package com.cuoikhoa.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Table
@Entity
public class KhoaHoc {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int khoaHocId;
	
	@Column 
	@Size(max = 50, message = "Tên khóa học không được quá 50 kí tự")
	@NotNull
	private String tenKhoaHoc;
	
	@Column
	@NotNull
	private int thoiGianHoc;
	
	@Column
	@NotNull
	private String gioiThieu;
	
	@Column
	@NotNull
	private String noiDung;
	
	@Column
	@NotNull
	private double hocPhi;
	
	@Column
	@NotNull
	private int soHocVien;
	
	@Column
	@NotNull
	private int soLuongMon;
	
	@Column
	@NotNull
	private String hinhAnh;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "loaiKhoaHocId")
	@JsonIgnoreProperties(value = "khoaHocs")
	@NotNull
	LoaiKhoaHoc loaiKhoaHoc;
	
	@OneToMany(mappedBy = "khoaHoc", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties(value = "khoaHoc")
	List<DangKyHoc> dangKyHocs;

	public int getKhoaHocId() {
		return khoaHocId;
	}

	public void setKhoaHocId(int khoaHocId) {
		this.khoaHocId = khoaHocId;
	}

	public String getTenKhoaHoc() {
		return tenKhoaHoc;
	}

	public void setTenKhoaHoc(String tenKhoaHoc) {
		this.tenKhoaHoc = tenKhoaHoc;
	}

	public int getThoiGianHoc() {
		return thoiGianHoc;
	}

	public void setThoiGianHoc(int thoiGianHoc) {
		this.thoiGianHoc = thoiGianHoc;
	}

	public String getGioiThieu() {
		return gioiThieu;
	}

	public void setGioiThieu(String gioiThieu) {
		this.gioiThieu = gioiThieu;
	}

	public String getNoiDung() {
		return noiDung;
	}

	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}

	public double getHocPhi() {
		return hocPhi;
	}

	public void setHocPhi(double hocPhi) {
		this.hocPhi = hocPhi;
	}

	public int getSoHocVien() {
		return soHocVien;
	}

	public void setSoHocVien(int soHocVien) {
		this.soHocVien = soHocVien;
	}

	public int getSoLuongMon() {
		return soLuongMon;
	}

	public void setSoLuongMon(int soLuongMon) {
		this.soLuongMon = soLuongMon;
	}

	public String getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

	public LoaiKhoaHoc getLoaiKhoaHoc() {
		return loaiKhoaHoc;
	}

	public void setLoaiKhoaHoc(LoaiKhoaHoc loaiKhoaHoc) {
		this.loaiKhoaHoc = loaiKhoaHoc;
	}

	public List<DangKyHoc> getDangKyHocs() {
		return dangKyHocs;
	}

	public void setDangKyHocs(List<DangKyHoc> dangKyHocs) {
		this.dangKyHocs = dangKyHocs;
	}

	public KhoaHoc(int khoaHocId,
			@Size(max = 50, message = "Tên khóa học không được quá 50 kí tự") @NotNull String tenKhoaHoc,
			@NotNull int thoiGianHoc, @NotNull String gioiThieu, @NotNull String noiDung, @NotNull double hocPhi,
			@NotNull int soHocVien, @NotNull int soLuongMon, @NotNull String hinhAnh, @NotNull LoaiKhoaHoc loaiKhoaHoc,
			List<DangKyHoc> dangKyHocs) {
		this.khoaHocId = khoaHocId;
		this.tenKhoaHoc = tenKhoaHoc;
		this.thoiGianHoc = thoiGianHoc;
		this.gioiThieu = gioiThieu;
		this.noiDung = noiDung;
		this.hocPhi = hocPhi;
		this.soHocVien = soHocVien;
		this.soLuongMon = soLuongMon;
		this.hinhAnh = hinhAnh;
		this.loaiKhoaHoc = loaiKhoaHoc;
		this.dangKyHocs = dangKyHocs;
	}
	
	public KhoaHoc() {

	}
}

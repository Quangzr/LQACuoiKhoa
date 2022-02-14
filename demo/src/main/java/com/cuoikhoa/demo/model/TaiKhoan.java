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
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Table
@Entity
public class TaiKhoan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int taiKhoanId;
	
	@Column
	@Size(max = 50, message = "Tên người dùng không được quá 50 kí tự")
	private String tenNguoiDung;
	
	@Column(unique = true)
	@Size(max = 50, message = "Tên đăng nhập không được quá 50 kí tự")
	private String tenDangNhap;
	
	@Column
	@Size(max = 50, message = "Mật khẩu không được quá 50 kí tự")
	private String matKhau;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "quyenHanId")
	@JsonIgnoreProperties(value = "taiKhoans")
	QuyenHan quyenHan;
	
	@OneToMany(mappedBy = "taiKhoan", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties(value = "taiKhoan")
	List<BaiViet> baiViets;
	
	@OneToMany(mappedBy = "taiKhoan", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties(value = "taiKhoan")
	List<DangKyHoc> dangKyHocs;

	public int getTaiKhoanId() {
		return taiKhoanId;
	}

	public void setTaiKhoanId(int taiKhoanId) {
		this.taiKhoanId = taiKhoanId;
	}

	public String getTenNguoiDung() {
		return tenNguoiDung;
	}

	public void setTenNguoiDung(String tenNguoiDung) {
		this.tenNguoiDung = tenNguoiDung;
	}

	public String getTenDangNhap() {
		return tenDangNhap;
	}

	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public QuyenHan getQuyenHan() {
		return quyenHan;
	}

	public void setQuyenHan(QuyenHan quyenHan) {
		this.quyenHan = quyenHan;
	}

	public List<BaiViet> getBaiViets() {
		return baiViets;
	}

	public void setBaiViets(List<BaiViet> baiViets) {
		this.baiViets = baiViets;
	}

	public List<DangKyHoc> getDangKyHocs() {
		return dangKyHocs;
	}

	public void setDangKyHocs(List<DangKyHoc> dangKyHocs) {
		this.dangKyHocs = dangKyHocs;
	}

	public TaiKhoan(int taiKhoanId,
			@Size(max = 50, message = "Tên người dùng không được quá 50 kí tự") String tenNguoiDung,
			@Size(max = 50, message = "Tên đăng nhập không được quá 50 kí tự") String tenDangNhap,
			@Size(max = 50, message = "Mật khẩu không được quá 50 kí tự") String matKhau, QuyenHan quyenHan,
			List<BaiViet> baiViets, List<DangKyHoc> dangKyHocs) {
		this.taiKhoanId = taiKhoanId;
		this.tenNguoiDung = tenNguoiDung;
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
		this.quyenHan = quyenHan;
		this.baiViets = baiViets;
		this.dangKyHocs = dangKyHocs;
	}
	
	public TaiKhoan() {
	
	}
}

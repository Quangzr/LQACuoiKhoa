package com.cuoikhoa.demo.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Table
@Entity
public class HocVien {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int hocVienId;
	
	@Column
	private String hinhAnh;
	
	@Column
	@Size(max = 50, message = "Họ tên không được quá 50 kí tự")
	private String hoTen;
	
	@Column
	private LocalDate ngaySinh;
	
//	@Column(unique = true)
	@Column
	@Size(max = 11, message = "Số điện thoại không được quá 11 kí tự")
	private String soDienThoai;
	
//	@Column(unique = true)
	@Column
	@Size(max = 40, message = "Email không được quá 40 kí tự")
	private String email;
	
	@Column
	@Size(max = 50, message = "Tên tỉnh thành không được quá 50 kí tự")
	private String tinhThanh;
	
	@Column
	@Size(max = 50, message = "Tên quận huyện không được quá 50 kí tự")
	private String quanHuyen;
	
	@Column
	@Size(max = 50, message = "Tên phường xã không được quá 50 kí tự")
	private String phuongXa;
	
	@Column
	@Size(max = 50, message = "Tên số nhà không được quá 50 kí tự")
	private String soNha;
	
	@OneToMany(mappedBy = "hocVien", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties(value = "hocVien")
	List<DangKyHoc> dangKyHocs;

	public int getHocVienId() {
		return hocVienId;
	}

	public void setHocVienId(int hocVienId) {
		this.hocVienId = hocVienId;
	}

	public String getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public LocalDate getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(LocalDate ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTinhThanh() {
		return tinhThanh;
	}

	public void setTinhThanh(String tinhThanh) {
		this.tinhThanh = tinhThanh;
	}

	public String getQuanHuyen() {
		return quanHuyen;
	}

	public void setQuanHuyen(String quanHuyen) {
		this.quanHuyen = quanHuyen;
	}

	public String getPhuongXa() {
		return phuongXa;
	}

	public void setPhuongXa(String phuongXa) {
		this.phuongXa = phuongXa;
	}

	public String getSoNha() {
		return soNha;
	}

	public void setSoNha(String soNha) {
		this.soNha = soNha;
	}

	public List<DangKyHoc> getDangKyHocs() {
		return dangKyHocs;
	}

	public void setDangKyHocs(List<DangKyHoc> dangKyHocs) {
		this.dangKyHocs = dangKyHocs;
	}

	public HocVien(int hocVienId, String hinhAnh,
			@Size(max = 50, message = "Họ tên không được quá 50 kí tự") String hoTen, LocalDate ngaySinh,
			@Size(max = 11, message = "Số điện thoại không được quá 11 kí tự") String soDienThoai,
			@Size(max = 40, message = "Email không được quá 40 kí tự") String email,
			@Size(max = 50, message = "Tên tỉnh thành không được quá 50 kí tự") String tinhThanh,
			@Size(max = 50, message = "Tên quận huyện không được quá 50 kí tự") String quanHuyen,
			@Size(max = 50, message = "Tên phường xã không được quá 50 kí tự") String phuongXa,
			@Size(max = 50, message = "Tên số nhà không được quá 50 kí tự") String soNha, List<DangKyHoc> dangKyHocs) {
		this.hocVienId = hocVienId;
		this.hinhAnh = hinhAnh;
		this.hoTen = hoTen;
		this.ngaySinh = ngaySinh;
		this.soDienThoai = soDienThoai;
		this.email = email;
		this.tinhThanh = tinhThanh;
		this.quanHuyen = quanHuyen;
		this.phuongXa = phuongXa;
		this.soNha = soNha;
		this.dangKyHocs = dangKyHocs;
	}
	
	public HocVien() {
	
	}
}

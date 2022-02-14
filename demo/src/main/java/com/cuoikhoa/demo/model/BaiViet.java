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
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Table
@Entity
public class BaiViet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int baiVietId;
	
	@Column
	@Size(max = 50, message = "Tên bài viết không được quá 50 kí tự")
	private String tenBaiViet;
	
	@Column
	@Size(max = 50, message = "Tên tác giả không được quá 50 kí tự")
	private String tenTacGia;
	
	@Column
	private String noiDung;
	
	@Column
	@Size(max = 1000, message = "Nội dung ngắn không được quá 1000 kí tự")
	private String noiDungNgan;
	
	@Column
	private LocalDate thoiGianTao;
	
	@Column
	private String hinhAnh;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "chuDeId")
	@JsonIgnoreProperties(value = "baiViets")
	ChuDe chuDe;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "taiKhoanId")
	@JsonIgnoreProperties(value = "baiViets")
	TaiKhoan taiKhoan;

	public int getBaiVietId() {
		return baiVietId;
	}

	public void setBaiVietId(int baiVietId) {
		this.baiVietId = baiVietId;
	}

	public String getTenBaiViet() {
		return tenBaiViet;
	}

	public void setTenBaiViet(String tenBaiViet) {
		this.tenBaiViet = tenBaiViet;
	}

	public String getTenTacGia() {
		return tenTacGia;
	}

	public void setTenTacGia(String tenTacGia) {
		this.tenTacGia = tenTacGia;
	}

	public String getNoiDung() {
		return noiDung;
	}

	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}

	public String getNoiDungNgan() {
		return noiDungNgan;
	}

	public void setNoiDungNgan(String noiDungNgan) {
		this.noiDungNgan = noiDungNgan;
	}

	public LocalDate getThoiGianTao() {
		return thoiGianTao;
	}

	public void setThoiGianTao(LocalDate thoiGianTao) {
		this.thoiGianTao = thoiGianTao;
	}

	public String getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

	public ChuDe getChuDe() {
		return chuDe;
	}

	public void setChuDe(ChuDe chuDe) {
		this.chuDe = chuDe;
	}

	public TaiKhoan getTaiKhoan() {
		return taiKhoan;
	}

	public void setTaiKhoan(TaiKhoan taiKhoan) {
		this.taiKhoan = taiKhoan;
	}

	public BaiViet(int baiVietId, @Size(max = 50, message = "Tên bài viết không được quá 50 kí tự") String tenBaiViet,
			@Size(max = 50, message = "Tên tác giả không được quá 50 kí tự") String tenTacGia, String noiDung,
			@Size(max = 1000, message = "Nội dung ngắn không được quá 1000 kí tự") String noiDungNgan,
			LocalDate thoiGianTao, String hinhAnh, ChuDe chuDe, TaiKhoan taiKhoan) {
		this.baiVietId = baiVietId;
		this.tenBaiViet = tenBaiViet;
		this.tenTacGia = tenTacGia;
		this.noiDung = noiDung;
		this.noiDungNgan = noiDungNgan;
		this.thoiGianTao = thoiGianTao;
		this.hinhAnh = hinhAnh;
		this.chuDe = chuDe;
		this.taiKhoan = taiKhoan;
	}
	
	public BaiViet() {
		
	}
}

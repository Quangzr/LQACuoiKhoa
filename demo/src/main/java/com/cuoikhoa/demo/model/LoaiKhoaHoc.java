package com.cuoikhoa.demo.model;

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
public class LoaiKhoaHoc {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int loaiKhoaHocId;
	
	@Column
	@Size(max = 30, message = "Tên loại khóa học không được quá 30 kí tự")
	private String tenLoai;
	
	@OneToMany(mappedBy = "loaiKhoaHoc", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties(value = "loaiKhoaHoc")
	List<KhoaHoc> khoaHocs;

	public int getLoaiKhoaHocId() {
		return loaiKhoaHocId;
	}

	public void setLoaiKhoaHocId(int loaiKhoaHocId) {
		this.loaiKhoaHocId = loaiKhoaHocId;
	}

	public String getTenLoai() {
		return tenLoai;
	}

	public void setTenLoai(String tenLoai) {
		this.tenLoai = tenLoai;
	}

	public List<KhoaHoc> getKhoaHocs() {
		return khoaHocs;
	}

	public void setKhoaHocs(List<KhoaHoc> khoaHocs) {
		this.khoaHocs = khoaHocs;
	}

	public LoaiKhoaHoc(int loaiKhoaHocId,
			@Size(max = 30, message = "Tên loại khóa học không được quá 30 kí tự") String tenLoai,
			List<KhoaHoc> khoaHocs) {
		this.loaiKhoaHocId = loaiKhoaHocId;
		this.tenLoai = tenLoai;
		this.khoaHocs = khoaHocs;
	}
	
	public LoaiKhoaHoc() {
	
	}
}

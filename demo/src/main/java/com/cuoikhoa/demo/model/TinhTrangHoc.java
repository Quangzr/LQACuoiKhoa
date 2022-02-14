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
public class TinhTrangHoc {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int tinhTrangHocId;
	
	@Column
	@Size(max = 40, message = "Tên tình trạng học không được quá 40 kí tự")
	private String tenTinhTrang;
	
	@OneToMany(mappedBy = "tinhTrangHoc", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties(value = "tinhTrangHoc")
	List<DangKyHoc> dangKyHocs;

	public int getTinhTrangHocId() {
		return tinhTrangHocId;
	}

	public void setTinhTrangHocId(int tinhTrangHocId) {
		this.tinhTrangHocId = tinhTrangHocId;
	}

	public String getTenTinhTrang() {
		return tenTinhTrang;
	}

	public void setTenTinhTrang(String tenTinhTrang) {
		this.tenTinhTrang = tenTinhTrang;
	}

	public List<DangKyHoc> getDangKyHocs() {
		return dangKyHocs;
	}

	public void setDangKyHocs(List<DangKyHoc> dangKyHocs) {
		this.dangKyHocs = dangKyHocs;
	}

	public TinhTrangHoc(int tinhTrangHocId,
			@Size(max = 40, message = "Tên tình trạng học không được quá 40 kí tự") String tenTinhTrang,
			List<DangKyHoc> dangKyHocs) {
		this.tinhTrangHocId = tinhTrangHocId;
		this.tenTinhTrang = tenTinhTrang;
		this.dangKyHocs = dangKyHocs;
	}
	
	public TinhTrangHoc() {
	
	}
}

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
public class QuyenHan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int quyenHanId;
	
	@Column
	@Size(max = 50, message = "Tên quyền hạn không được quá 50 kí tự")
	private String tenQuyenHan;
	
	@OneToMany(mappedBy = "quyenHan", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties(value = "quyenHan")
	List<TaiKhoan> taiKhoans;

	public int getQuyenHanId() {
		return quyenHanId;
	}

	public void setQuyenHanId(int quyenHanId) {
		this.quyenHanId = quyenHanId;
	}

	public String getTenQuyenHan() {
		return tenQuyenHan;
	}

	public void setTenQuyenHan(String tenQuyenHan) {
		this.tenQuyenHan = tenQuyenHan;
	}

	public List<TaiKhoan> getTaiKhoans() {
		return taiKhoans;
	}

	public void setTaiKhoans(List<TaiKhoan> taiKhoans) {
		this.taiKhoans = taiKhoans;
	}

	public QuyenHan(int quyenHanId,
			@Size(max = 50, message = "Tên quyền hạn không được quá 50 kí tự") String tenQuyenHan,
			List<TaiKhoan> taiKhoans) {
		this.quyenHanId = quyenHanId;
		this.tenQuyenHan = tenQuyenHan;
		this.taiKhoans = taiKhoans;
	}
	
	public QuyenHan() {

	}
}

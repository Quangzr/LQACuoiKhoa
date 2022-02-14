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
public class LoaiBaiViet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int loaiBaiVietId;
	
	@Column
	@Size(max = 50, message = "Tên loại bài viết không được quá 50 kí tự")
	private String tenLoai;
	
	@OneToMany(mappedBy = "loaiBaiViet", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties(value = "loaiBaiViet")
	List<ChuDe> chuDes;

	public int getLoaiBaiVietId() {
		return loaiBaiVietId;
	}

	public void setLoaiBaiVietId(int loaiBaiVietId) {
		this.loaiBaiVietId = loaiBaiVietId;
	}

	public String getTenLoai() {
		return tenLoai;
	}

	public void setTenLoai(String tenLoai) {
		this.tenLoai = tenLoai;
	}

	public List<ChuDe> getChuDes() {
		return chuDes;
	}

	public void setChuDes(List<ChuDe> chuDes) {
		this.chuDes = chuDes;
	}

	public LoaiBaiViet(int loaiBaiVietId,
			@Size(max = 50, message = "Tên loại bài viết không được quá 50 kí tự") String tenLoai, List<ChuDe> chuDes) {
		this.loaiBaiVietId = loaiBaiVietId;
		this.tenLoai = tenLoai;
		this.chuDes = chuDes;
	}
	
	public LoaiBaiViet() {

	}
}

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
public class ChuDe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int chuDeId;
	
	@Column
	@NotNull
	@Size(max = 50, message = "Tên chủ đề không được quá 50 kí tự")
	private String tenChuDe;
	
	@Column
	@NotNull
	private String noiDung;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "loaiBaiVietId")
	@JsonIgnoreProperties(value = "chuDes")
	@NotNull
	LoaiBaiViet loaiBaiViet;
	
	@OneToMany(mappedBy = "chuDe", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties(value = "chuDe")
	List<BaiViet> baiViets;

	public int getChuDeId() {
		return chuDeId;
	}

	public void setChuDeId(int chuDeId) {
		this.chuDeId = chuDeId;
	}

	public String getTenChuDe() {
		return tenChuDe;
	}

	public void setTenChuDe(String tenChuDe) {
		this.tenChuDe = tenChuDe;
	}

	public String getNoiDung() {
		return noiDung;
	}

	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}

	public LoaiBaiViet getLoaiBaiViet() {
		return loaiBaiViet;
	}

	public void setLoaiBaiViet(LoaiBaiViet loaiBaiViet) {
		this.loaiBaiViet = loaiBaiViet;
	}

	public List<BaiViet> getBaiViets() {
		return baiViets;
	}

	public void setBaiViets(List<BaiViet> baiViets) {
		this.baiViets = baiViets;
	}

	public ChuDe(int chuDeId, @NotNull @Size(max = 50, message = "Tên chủ đề không được quá 50 kí tự") String tenChuDe,
			@NotNull String noiDung, @NotNull LoaiBaiViet loaiBaiViet, List<BaiViet> baiViets) {
		this.chuDeId = chuDeId;
		this.tenChuDe = tenChuDe;
		this.noiDung = noiDung;
		this.loaiBaiViet = loaiBaiViet;
		this.baiViets = baiViets;
	}
	
	public ChuDe() {
	
	}
}

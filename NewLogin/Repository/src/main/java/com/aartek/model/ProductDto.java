package com.aartek.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product_details")
public class ProductDto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "P_ID")
	private Integer p_id;

	@Column(name = "PRO_ID")
	private String pro_id;

	@Column(name = "PRO_NAME")
	private String pro_name;

	@Column(name = "PRO_PRICE")
	private String pro_price;

	@Column(name = "PRO_CATEORY")
	private String pro_category;

	public Integer getP_id() {
		return p_id;
	}

	public void setP_id(Integer p_id) {
		this.p_id = p_id;
	}

	public String getPro_id() {
		return pro_id;
	}

	public void setPro_id(String pro_id) {
		this.pro_id = pro_id;
	}

	public String getPro_name() {
		return pro_name;
	}

	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}

	public String getPro_price() {
		return pro_price;
	}

	public void setPro_price(String pro_price) {
		this.pro_price = pro_price;
	}

	public String getPro_category() {
		return pro_category;
	}

	public void setPro_category(String pro_category) {
		this.pro_category = pro_category;
	}

}

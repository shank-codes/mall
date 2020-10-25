package com.internshipproject.dlithe.mall;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import com.sun.istack.NotNull;


@Entity
public class Product {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer pid;
	
	@NotNull
	private String pname;
	@NotNull
	private Integer quantity;
	@NotNull
	private Double ppp;
	
	@NotNull
	private Double total;
	
	public Product(){
		super();
	}

	public Product(Integer pid, String pname, Integer quantity, Double ppp, Double total) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.quantity = quantity;
		this.ppp = ppp;
		this.total = total;
	}
	

	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", quantity=" + quantity + ", ppp=" + ppp + ", total="
				+ total + "]";
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPpp() {
		return ppp;
	}

	public void setPpp(Double ppp) {
		this.ppp = ppp;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}
	
}

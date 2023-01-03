package com.demo.pojo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Consumer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int consumerId;
	
	private String consumerName;
	private String area;
	private String city;
	private String connectionType;
	@OneToMany(cascade = CascadeType.ALL)
    private List<Bill> bills;
	
	
//	public List<Bill> getBills() {
//		return bills;
//	}
//	public void setBills(List<Bill> bills) {
//		this.bills = bills;
//	}
	public int getConsumerId() {
		return consumerId;
	}
	public void setConsumerId(int consumerId) {
		this.consumerId = consumerId;
	}
	public String getConsumerName() {
		return consumerName;
	}
	public void setConsumerName(String consumerName) {
		this.consumerName = consumerName;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getConnectionType() {
		return connectionType;
	}
	public void setConnectionType(String connectionType) {
		this.connectionType = connectionType;
	}
	
	@Override
	public String toString() {
		return "Consumer [consumerId=" + consumerId + ", consumerName=" + consumerName + ", area=" + area + ", city="
				+ city + ", connectionType=" + connectionType +"]";
	}
	public Consumer(String consumerName, String area, String city, String connectionType) {
		super();
		//this.consumerId = consumerId;
		this.consumerName = consumerName;
		this.area = area;
		this.city = city;
		this.connectionType = connectionType;
		//this.bills = bills;
	}
	public Consumer() {
		//super();
		// TODO Auto-generated constructor stub
	}
	
	
}

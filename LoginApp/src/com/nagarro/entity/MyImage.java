package com.nagarro.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class MyImage {
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private int imageId;
	private String name;
	@Lob
	private byte[] image;
	public MyImage(int imageId, String name, byte[] image) {
		super();
		this.imageId = imageId;
		this.name = name;
		this.image = image;
	}
	public MyImage() {
		super();
		
	}
	public int getImageId() {
		return imageId;
	}
	public void setImageId(int imageId) {
		this.imageId = imageId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	
	
	

}

package com.example.ecommerceapp.model.homeBanner;

import com.google.gson.annotations.SerializedName;

public class BannerItem{

	@SerializedName("id")
	private String id;

	@SerializedName("banner_name")
	private String bannerName;

	@SerializedName("banner_image")
	private String bannerImage;

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setBannerName(String bannerName){
		this.bannerName = bannerName;
	}

	public String getBannerName(){
		return bannerName;
	}

	public void setBannerImage(String bannerImage){
		this.bannerImage = bannerImage;
	}

	public String getBannerImage(){
		return bannerImage;
	}
}
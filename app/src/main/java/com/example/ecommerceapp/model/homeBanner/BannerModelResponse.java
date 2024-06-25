package com.example.ecommerceapp.model.homeBanner;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class BannerModelResponse{

	@SerializedName("code")
	private int code;

	@SerializedName("banner")
	private List<BannerItem> banner;

	public void setCode(int code){
		this.code = code;
	}

	public int getCode(){
		return code;
	}

	public void setBanner(List<BannerItem> banner){
		this.banner = banner;
	}

	public List<BannerItem> getBanner(){
		return banner;
	}
}
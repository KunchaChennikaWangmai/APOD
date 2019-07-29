package com.chennikawangmai.chenproject;

import com.google.gson.annotations.SerializedName;

public class apod {
  @SerializedName("hdurl")
  public   String hdurl;
  public String url;

  public String getHdurl() {
    return hdurl;
  }
}

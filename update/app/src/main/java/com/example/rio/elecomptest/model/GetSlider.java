package com.example.rio.elecomptest.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Created by anyem on 7/21/2019.
 */

public class GetSlider {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    List<Slider> listSlider;
    @SerializedName("message")
    String message;

    public void setStatus(String status){
        this.status = status;
    }
    public String getMessage(){
        return message;
    }
    public void setMessage(String message){
        this.message = message;
    }
    public List<Slider> getDataSlider(){
        return listSlider;
    }
    public void setListSlider(List<Slider> listSlider){
        this.listSlider = listSlider;
    }
}

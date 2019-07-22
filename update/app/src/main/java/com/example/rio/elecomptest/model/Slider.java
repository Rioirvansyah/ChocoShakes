package com.example.rio.elecomptest.model;

import com.google.gson.annotations.SerializedName;
/**
 * Created by anyem on 7/21/2019.
 */

public class Slider {
    @SerializedName("id_slider")
    private String id_slider;
    @SerializedName("slider_judul")
    private String slider_judul;
    @SerializedName("slider_deskripsi")
    private String slider_deskripsi;
    @SerializedName("slider_gambar")
    private String slider_gambar;

    public Slider(String id_slider, String slider_judul, String slider_deskripsi, String slider_gambar) {
        this.id_slider = id_slider;
        this.slider_judul = slider_judul;
        this.slider_deskripsi = slider_deskripsi;
        this.slider_gambar = slider_gambar;
    }

    public String getId_slider() {
        return id_slider;
    }

    public void setId_slider(String id_slider) {
        this.id_slider = id_slider;
    }

    public String getSlider_judul() {
        return slider_judul;
    }

    public void setSlider_judul(String slider_judul) {
        this.slider_judul = slider_judul;
    }

    public String getSlider_deskripsi() {
        return slider_deskripsi;
    }

    public void setSlider_deskripsi(String slider_deskripsi) {
        this.slider_deskripsi = slider_deskripsi;
    }

    public String getSlider_gambar() {
        return slider_gambar;
    }

    public void setSlider_gambar(String slider_gambar) {
        this.slider_gambar = slider_gambar;
    }
}

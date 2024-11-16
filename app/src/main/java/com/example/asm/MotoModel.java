package com.example.asm;

public class MotoModel {
    private String id;
    private String ten;
    private String namSx;
    private String hangsx;
    private String gia;
    private String image;

    public MotoModel(String id, String ten, String namSx, String hangsx, String gia, String image) {
        this.id = id;
        this.ten = ten;
        this.namSx = namSx;
        this.hangsx = hangsx;
        this.gia = gia;
        this.image = image;
    }

    public MotoModel(String ten, String namSx, String hangsx, String gia, String image) {
        this.ten = ten;
        this.namSx = namSx;
        this.hangsx = hangsx;
        this.gia = gia;
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getNamSx() {
        return namSx;
    }

    public void setNamSx(String namSx) {
        this.namSx = namSx;
    }

    public String getHangsx() {
        return hangsx;
    }

    public void setHangsx(String hangsx) {
        this.hangsx = hangsx;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}

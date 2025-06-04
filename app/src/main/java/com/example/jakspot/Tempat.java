package com.example.jakspot;

public class Tempat {
    private int gambar;
    private String nama;
    private String lokasi;

    public Tempat(int gambar, String nama, String lokasi) {
        this.gambar = gambar;
        this.nama = nama;
        this.lokasi = lokasi;
    }

    public int getGambar() {
        return gambar;
    }

    public String getNama() {
        return nama;
    }

    public String getLokasi() {
        return lokasi;
    }
}

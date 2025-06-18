package com.example.jakspot;

public class Tempat {
    private int gambar;
    private String nama;
    private String lokasi;
    private String kategori;
    private boolean isFavorite = false;

    public Tempat(int gambar, String nama, String lokasi, String kategori) {
        this.gambar = gambar;
        this.nama = nama;
        this.lokasi = lokasi;
        this.kategori = kategori;
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

    public String getKategori() {
        return kategori;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }
}

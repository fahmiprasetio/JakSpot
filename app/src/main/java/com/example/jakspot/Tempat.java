package com.example.jakspot;

public class Tempat {
    private int gambar;
    private String nama;
    private String lokasi;
    private String kategori;
    private double latitude;
    private double longitude;
    private boolean isFavorite = false;

    // Constructor with coordinates
    public Tempat(int gambar, String nama, String lokasi, String kategori, double latitude, double longitude) {
        this.gambar = gambar;
        this.nama = nama;
        this.lokasi = lokasi;
        this.kategori = kategori;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    // Legacy constructor without coordinates
    public Tempat(int gambar, String nama, String lokasi, String kategori) {
        this(gambar, nama, lokasi, kategori, 0.0, 0.0);
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

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }
}

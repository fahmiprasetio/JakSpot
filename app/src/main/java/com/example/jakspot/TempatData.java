// === TempatData.java ===
package com.example.jakspot;

import java.util.ArrayList;
import java.util.List;

public class TempatData {
    public static List<Tempat> getAllTempat() {
        List<Tempat> list = new ArrayList<>();

        // Data kategori Cafe
        list.add(new Tempat(R.drawable.muga, "Museum Gajah", "Jakarta Pusat", "Cafe", -6.176146, 106.821589));
        list.add(new Tempat(R.drawable.mufa, "Museum Fatahillah", "Jakarta Barat", "Cafe", -6.135199, 106.8133));
        list.add(new Tempat(R.drawable.tmii, "Taman Mini Indonesia Indah", "Jakarta Barat", "Cafe", -6.301667, 106.896667));
        list.add(new Tempat(R.drawable.ancol, "Taman Impian Jaya Ancol", "Jakarta Timur", "Cafe", -6.122743, 106.831529));
        list.add(new Tempat(R.drawable.jis, "Jakarta International Stadium", "Jakarta Utara", "Cafe", -6.12477, 106.859542));
        list.add(new Tempat(R.drawable.gbk, "Gelora Bung Karno", "Jakarta Pusat", "Cafe", -6.218611, 106.8025));

        // Tambahan kategori Hotel
        list.add(new Tempat(R.drawable.monas, "Monas", "Jakarta Pusat", "Hotel", -6.1754, 106.8272));
        list.add(new Tempat(R.drawable.moseda, "Monumen Selamat Datang", "Jakarta Pusat", "Hotel", -6.194979, 106.823049));

        // Tambahan kategori Stasiun
        list.add(new Tempat(R.drawable.gambir, "Stasiun Gambir", "Jakarta Pusat", "Stasiun", -6.175392, 106.830165));
        list.add(new Tempat(R.drawable.sps, "Stasiun Pasar Senen", "Jakarta Pusat", "Stasiun", -6.173611, 106.844169));

        // Tambahan kategori Bandara
        list.add(new Tempat(R.drawable.suha, "Bandara Soekarno-Hatta", "Tangerang", "Bandara", -6.1275, 106.6544));
        list.add(new Tempat(R.drawable.hlp, "Bandara Halim Perdanakusuma", "Jakarta Timur", "Bandara", -6.2669, 106.8900));

        return list;
    }
}

// === TempatData.java ===
package com.example.jakspot;

import java.util.ArrayList;
import java.util.List;

public class TempatData {
    public static List<Tempat> getAllTempat() {
        List<Tempat> list = new ArrayList<>();

        // Data kategori Cafe
        list.add(new Tempat(R.drawable.sample_kafe, "Kafe Random 1", "Jakarta Pusat", "Cafe"));
        list.add(new Tempat(R.drawable.sample_kafe, "Kafe Random 2", "Jakarta Barat", "Cafe"));
        list.add(new Tempat(R.drawable.sample_kafe, "Kafe Random 3", "Jakarta Selatan", "Cafe"));
        list.add(new Tempat(R.drawable.sample_kafe, "Kafe Random 4", "Jakarta Timur", "Cafe"));
        list.add(new Tempat(R.drawable.sample_kafe, "Kafe Random 5", "Jakarta Utara", "Cafe"));
        list.add(new Tempat(R.drawable.sample_kafe, "Kafe Random 6", "Jakarta Kota", "Cafe"));

        // Tambahan kategori Hotel
        list.add(new Tempat(R.drawable.sample_kafe, "Hotel Grand Jakarta", "Jakarta Pusat", "Hotel"));
        list.add(new Tempat(R.drawable.sample_kafe, "Hotel Nusantara", "Jakarta Selatan", "Hotel"));

        // Tambahan kategori Stasiun
        list.add(new Tempat(R.drawable.sample_kafe, "Stasiun Gambir", "Jakarta Pusat", "Stasiun"));
        list.add(new Tempat(R.drawable.sample_kafe, "Stasiun Senen", "Jakarta Pusat", "Stasiun"));

        // Tambahan kategori Bandara
        list.add(new Tempat(R.drawable.sample_kafe, "Bandara Soekarno-Hatta", "Tangerang", "Bandara"));
        list.add(new Tempat(R.drawable.sample_kafe, "Bandara Halim Perdana", "Jakarta Timur", "Bandara"));

        return list;
    }
}

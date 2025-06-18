// === ExploreActivity.java ===
package com.example.jakspot;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ExploreActivity extends AppCompatActivity {

    private RecyclerView gridRecyclerView;
    private TempatAdapter adapter;
    private List<Tempat> listTempat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explore);

        // === 1. BOTTOM NAV ===
        ImageButton navHome = findViewById(R.id.nav_home);
        ImageButton navExplore = findViewById(R.id.nav_explore);
        ImageButton navProfile = findViewById(R.id.nav_profile);

        navHome.setOnClickListener(v -> {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        });

        navExplore.setOnClickListener(v -> {
            // sudah di halaman ini
        });

        navProfile.setOnClickListener(v -> {
            startActivity(new Intent(this, ProfileActivity.class));
            finish();
        });

        // === 2. RECYCLER VIEW ===
        gridRecyclerView = findViewById(R.id.gridRecyclerView);
        gridRecyclerView.setLayoutManager(new GridLayoutManager(this, 2)); // 2 kolom

        // === 3. DATA & ADAPTER ===
        listTempat = TempatData.getAllTempat();
        adapter = new TempatAdapter(ExploreActivity.this, listTempat);
        gridRecyclerView.setAdapter(adapter);

        // === 4. FILTER BUTTONS ===
        Button btnHotel = findViewById(R.id.btnHotel);
        Button btnStasiun = findViewById(R.id.btnStasiun);
        Button btnBandara = findViewById(R.id.btnBandara);
        Button btnCafe = findViewById(R.id.btnCafe);

        btnHotel.setOnClickListener(v -> filterKategori("Hotel"));
        btnStasiun.setOnClickListener(v -> filterKategori("Stasiun"));
        btnBandara.setOnClickListener(v -> filterKategori("Bandara"));
        btnCafe.setOnClickListener(v -> filterKategori("Cafe"));
    }

    private void filterKategori(String kategori) {
        List<Tempat> hasil = new ArrayList<>();
        for (Tempat t : listTempat) {
            if (t.getKategori().equalsIgnoreCase(kategori)) {
                hasil.add(t);
            }
        }
        adapter = new TempatAdapter(this, hasil);
        gridRecyclerView.setAdapter(adapter);
    }
}

package com.example.jakspot;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TempatAdapter adapter;
    private List<Tempat> listTempat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home); // menuju ke beranda

        // Inisialisasi RecyclerView
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(
                new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        );

        // Data dummy
        listTempat = new ArrayList<>();
        listTempat.add(new Tempat(R.drawable.sample_kafe, "Kafe Random 1", "Jakarta Pusat"));
        listTempat.add(new Tempat(R.drawable.sample_kafe, "Kafe Random 2", "Jakarta Barat"));
        listTempat.add(new Tempat(R.drawable.sample_kafe, "Kafe Random 3", "Jakarta Selatan"));

        // Set adapter
        adapter = new TempatAdapter(listTempat);
        recyclerView.setAdapter(adapter);

        // === Kode Navigasi Bottom Nav ===
        ImageButton navHome = findViewById(R.id.nav_home);
        ImageButton navExplore = findViewById(R.id.nav_explore);
        ImageButton navProfile = findViewById(R.id.nav_profile);

        navHome.setOnClickListener(v -> {
            // Sudah di halaman Home, tidak perlu pindah
        });

        navExplore.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, ExploreActivity.class));
            finish();
        });

        navProfile.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, ProfileActivity.class));
            finish();
        });
    }
}

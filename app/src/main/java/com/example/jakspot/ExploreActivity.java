package com.example.jakspot;

import android.content.Intent;
import android.os.Bundle;
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

        // === 3. DATA DUMMY ===
        listTempat = new ArrayList<>();
        listTempat.add(new Tempat(R.drawable.sample_kafe, "Kafe Random 1", "Jakarta Selatan"));
        listTempat.add(new Tempat(R.drawable.sample_kafe, "Kafe Random 2", "Jakarta Timur"));
        listTempat.add(new Tempat(R.drawable.sample_kafe, "Kafe Random 3", "Jakarta Pusat"));
        listTempat.add(new Tempat(R.drawable.sample_kafe, "Kafe Random 4", "Jakarta Utara"));
        listTempat.add(new Tempat(R.drawable.sample_kafe, "Kafe Random 5", "Jakarta Barat"));
        listTempat.add(new Tempat(R.drawable.sample_kafe, "Kafe Random 6", "Jakarta Kota"));

        adapter = new TempatAdapter(listTempat);
        gridRecyclerView.setAdapter(adapter);
    }
}

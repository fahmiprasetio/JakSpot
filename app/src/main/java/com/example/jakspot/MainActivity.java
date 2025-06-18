// === MainActivity.java ===
package com.example.jakspot;

import android.content.Intent;
import android.os.Bundle;
import android.widget.AutoCompleteTextView;
import android.widget.ArrayAdapter;
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

        // Ambil data dari TempatData agar konsisten dengan halaman Explore
        listTempat = TempatData.getAllTempat();

        // Set adapter
        adapter = new TempatAdapter(MainActivity.this, listTempat);
        recyclerView.setAdapter(adapter);

        // === SEARCH BAR ===
        AutoCompleteTextView searchBar = findViewById(R.id.searchBar);

        List<String> namaTempatList = new ArrayList<>();
        for (Tempat t : listTempat) {
            namaTempatList.add(t.getNama());
        }

        ArrayAdapter<String> searchAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_dropdown_item_1line,
                namaTempatList
        );
        searchBar.setAdapter(searchAdapter);
        searchBar.setThreshold(1);

        searchBar.setOnItemClickListener((adapterView, view, i, l) -> {
            String namaDipilih = adapterView.getItemAtPosition(i).toString();

            for (Tempat t : listTempat) {
                if (t.getNama().equalsIgnoreCase(namaDipilih)) {
                    Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                    intent.putExtra("nama", t.getNama());
                    intent.putExtra("lokasi", t.getLokasi());
                    intent.putExtra("gambar", t.getGambar());
                    startActivity(intent);
                    break;
                }
            }
        });

        // === Navigasi Bottom ===
        ImageButton navHome = findViewById(R.id.nav_home);
        ImageButton navExplore = findViewById(R.id.nav_explore);
        ImageButton navProfile = findViewById(R.id.nav_profile);

        navHome.setOnClickListener(v -> {
            // Sudah di halaman Home
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

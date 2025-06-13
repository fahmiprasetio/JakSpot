package com.example.jakspot;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView namaView = findViewById(R.id.nama_kafe);
        TextView lokasiView = findViewById(R.id.lokasi_kafe);
        ImageView gambarView = findViewById(R.id.gambar_kafe);

        Intent intent = getIntent();
        String nama = intent.getStringExtra("nama");
        String lokasi = intent.getStringExtra("lokasi");
        int gambar = intent.getIntExtra("gambar", 0);

        namaView.setText(nama);
        lokasiView.setText(lokasi);
        gambarView.setImageResource(gambar);

        // Tambahkan listener tombol navbar
        ImageButton navHome = findViewById(R.id.nav_home);
        ImageButton navExplore = findViewById(R.id.nav_explore);
        ImageButton navProfile = findViewById(R.id.nav_profile);

        navHome.setOnClickListener(v -> {
            startActivity(new Intent(DetailActivity.this, MainActivity.class));
            finish();
        });

        navExplore.setOnClickListener(v -> {
            startActivity(new Intent(DetailActivity.this, ExploreActivity.class));
            finish();
        });

        navProfile.setOnClickListener(v -> {
            startActivity(new Intent(DetailActivity.this, ProfileActivity.class));
            finish();
        });
    }
}

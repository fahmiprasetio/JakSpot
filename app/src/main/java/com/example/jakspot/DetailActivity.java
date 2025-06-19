package com.example.jakspot;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.ImageButton;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity implements OnMapReadyCallback {

    private double latitude;
    private double longitude;
    private String namaPlace;
    private GoogleMap mMap;

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
        latitude = intent.getDoubleExtra("lat", 0.0);
        longitude = intent.getDoubleExtra("lng", 0.0);
        namaPlace = nama;

        namaView.setText(nama);
        lokasiView.setText(lokasi);
        gambarView.setImageResource(gambar);

        // Setup Google Map fragment
        SupportMapFragment mapFragment = SupportMapFragment.newInstance();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.map_container, mapFragment)
                .commit();
        mapFragment.getMapAsync(this);

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

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng pos = new LatLng(latitude, longitude);
        mMap.addMarker(new MarkerOptions().position(pos).title(namaPlace));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(pos, 15f));
    }
}

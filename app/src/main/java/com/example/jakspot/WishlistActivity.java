package com.example.jakspot;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class WishlistActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TempatWishlistAdapter adapter;
    private DbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wishlist);

        // === 1. BOTTOM NAVIGATION LOGIC ===
        ImageButton navHome = findViewById(R.id.nav_home);
        ImageButton navExplore = findViewById(R.id.nav_explore);
        ImageButton navProfile = findViewById(R.id.nav_profile);

        navHome.setOnClickListener(v -> {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        });

        navExplore.setOnClickListener(v -> {
            startActivity(new Intent(this, ExploreActivity.class));
            finish();
        });

        navProfile.setOnClickListener(v -> {
            startActivity(new Intent(this, ProfileActivity.class));
            finish();
        });

        // === 2. AMBIL DATA DARI DATABASE ===
        dbHelper = new DbHelper(this);
        List<Tempat> listWishlist = dbHelper.getAllFavorites();

        recyclerView = findViewById(R.id.recyclerViewWishlist);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new TempatWishlistAdapter(this, listWishlist);
        recyclerView.setAdapter(adapter);
    }
}

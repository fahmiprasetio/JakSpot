package com.example.jakspot;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen); // XML layout-nya

        // Delay 2 detik lalu pindah ke MainActivity
        new Handler().postDelayed(() -> {
            startActivity(new Intent(SplashActivity.this, MainActivity.class));
            finish(); // Biar splash nggak bisa di-back
        }, 2000); // Delay 2000ms (2 detik)
    }
}

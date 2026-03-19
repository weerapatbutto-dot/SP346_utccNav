package com.example.sp346_utccnav;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;

public class AboutActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        // Make activity full screen
        hideSystemUI();

        findViewById(R.id.homeBtn).setOnClickListener(v -> {
            startActivity(new Intent(this, MainActivity.class));
        });
        findViewById(R.id.aboutBtn).setOnClickListener(v -> {
            // Already here
        });
        findViewById(R.id.historyBtn).setOnClickListener(v -> {
            startActivity(new Intent(this, HistoryActivity.class));
        });
        findViewById(R.id.gmapBtn).setOnClickListener(v -> {
            startActivity(new Intent(this, MapActivity.class));
        });
        findViewById(R.id.settingBtn).setOnClickListener(v -> {
            startActivity(new Intent(this, SettingActivity.class));
        });
    }

    private void hideSystemUI() {
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        WindowInsetsControllerCompat controller = new WindowInsetsControllerCompat(getWindow(), getWindow().getDecorView());
        controller.hide(WindowInsetsCompat.Type.statusBars() | WindowInsetsCompat.Type.navigationBars());
        controller.setSystemBarsBehavior(WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE);
    }
}
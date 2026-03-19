package com.example.sp346_utccnav;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;

public class SettingActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        hideSystemUI();
        findViewById(R.id.homeBtn).setOnClickListener(v -> {
            startActivity(new Intent(this, MainActivity.class));
        });
        findViewById(R.id.aboutBtn).setOnClickListener(v -> {
            startActivity(new Intent(this, AboutActivity.class));
        });
        findViewById(R.id.historyBtn).setOnClickListener(v -> {
            startActivity(new Intent(this, HistoryActivity.class));
        });
        findViewById(R.id.gmapBtn).setOnClickListener(v -> {
            startActivity(new Intent(this, MapActivity.class));
        });
        findViewById(R.id.settingBtn).setOnClickListener(v -> {
            // Already here
        });
    }
    private void hideSystemUI() {
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        WindowInsetsControllerCompat controller = new WindowInsetsControllerCompat(getWindow(), getWindow().getDecorView());
        controller.hide(WindowInsetsCompat.Type.statusBars() | WindowInsetsCompat.Type.navigationBars());
        controller.setSystemBarsBehavior(WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE);
    }
}
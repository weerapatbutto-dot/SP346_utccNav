package com.example.sp346_utccnav;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;

public class MapActivity extends AppCompatActivity {

    private WebView mapWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        // Make activity full screen
        hideSystemUI();

        mapWebView = findViewById(R.id.mapWebView);
        WebSettings webSettings = mapWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        mapWebView.setWebViewClient(new WebViewClient());
        
        // Load Google Maps URL (UTCC location)
        mapWebView.loadUrl("https://www.google.com/maps/@13.7799375,100.5603548,20z?entry=ttu&g_ep=EgoyMDI2MDMxMS4wIKXMDSoASAFQAw%3D%3D");

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
            // Already here
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
    
    @Override
    public void onBackPressed() {
        if (mapWebView.canGoBack()) {
            mapWebView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
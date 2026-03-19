package com.example.sp346_utccnav;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;

public class MainActivity extends AppCompatActivity {

    private TextView currentLocationValue;
    double latitude, longitude;

    FusedLocationProviderClient fusedLocationClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hideSystemUI();

        currentLocationValue = findViewById(R.id.currentLocationValue);
        currentLocationValue.setText("กำลังระบุตำแหน่ง...");

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        getLocation();

        // Navigation buttons
        findViewById(R.id.homeBtn).setOnClickListener(v -> {
            getLocation();
            Toast.makeText(this, "lat:" + latitude + " lon:" + longitude, Toast.LENGTH_SHORT).show();
        });
        findViewById(R.id.aboutBtn).setOnClickListener(v -> startActivity(new Intent(this, AboutActivity.class)));
        findViewById(R.id.historyBtn).setOnClickListener(v -> startActivity(new Intent(this, HistoryActivity.class)));
        findViewById(R.id.gmapBtn).setOnClickListener(v -> startActivity(new Intent(this, MapActivity.class)));
        findViewById(R.id.settingBtn).setOnClickListener(v -> startActivity(new Intent(this, SettingActivity.class)));

        // Box Click Listeners
        View.OnClickListener boxClickListener = v -> startActivity(new Intent(MainActivity.this, ViewPageActivity.class));
        int[] boxIds = {R.id.box1, R.id.box2, R.id.box3, R.id.box4, R.id.box5, R.id.box6, R.id.box7, R.id.box8, R.id.box9, R.id.box10};
        for (int id : boxIds) findViewById(id).setOnClickListener(boxClickListener);
    }

    private void hideSystemUI() {
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        WindowInsetsControllerCompat controller = new WindowInsetsControllerCompat(getWindow(), getWindow().getDecorView());
        controller.hide(WindowInsetsCompat.Type.statusBars() | WindowInsetsCompat.Type.navigationBars());
        controller.setSystemBarsBehavior(WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE);
    }

    private void getLocation() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
            return;
        }
        fusedLocationClient.getLastLocation().addOnSuccessListener(this, location -> {
            if (location != null) {
                this.latitude = location.getLatitude();
                this.longitude = location.getLongitude();
                if (currentLocationValue != null) {
                    currentLocationValue.setText("lat:" + latitude + "\n lon:" + longitude);
                }
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1 && grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            getLocation();
        }
    }
}
package com.example.sp346_utccnav;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;

public class ViewPageActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_page);
        hideSystemUI();

        HorizontalScrollView scroll = findViewById(R.id.panoramaScroll);
        LinearLayout container = findViewById(R.id.panoramaContainer);
        TextView pixelIndicator = findViewById(R.id.pixelIndicator);

        // Default image Some reason the damn thing is interger
        int panoImg = R.drawable.pos4; //This damn thing
        
        // Check if an image was passed from another activity
        if (getIntent().hasExtra("image_resource")) {
            panoImg = getIntent().getIntExtra("image_resource", R.drawable.pos4);
        }

        // Apply image to all three ImageViews in the loop
        for (int i = 0; i < container.getChildCount(); i++) {
            View child = container.getChildAt(i);
            if (child instanceof ImageView) {
                ((ImageView) child).setImageResource(panoImg);
            }
        }

        final ImageView referenceImage = (ImageView) container.getChildAt(1);

        scroll.getViewTreeObserver().addOnScrollChangedListener(() -> {
            int scrollX = scroll.getScrollX();
            int imageWidth = referenceImage.getWidth();
            int screenWidth = scroll.getWidth();

            if (imageWidth > 0) {
                if (scrollX >= imageWidth * 2) {
                    scroll.setScrollX(scrollX - imageWidth);
                    scrollX = scroll.getScrollX();
                } else if (scrollX <= 0) {
                    scroll.setScrollX(scrollX + imageWidth);
                    scrollX = scroll.getScrollX();
                }
                //Center calculation get the max width then divide by 2 of whatever reference
                float centerInContent = scrollX + (screenWidth / 2f);
                float pixelPos = (centerInContent % imageWidth) * (2048f / imageWidth);
                pixelIndicator.setText("Pixel: " + (int)pixelPos);
            }
        });

        scroll.post(() -> scroll.setScrollX(referenceImage.getWidth()));

        findViewById(R.id.homeBtn).setOnClickListener(v -> {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        });
    }

    private void hideSystemUI() {
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        WindowInsetsControllerCompat controller = new WindowInsetsControllerCompat(getWindow(), getWindow().getDecorView());
        controller.hide(WindowInsetsCompat.Type.statusBars() | WindowInsetsCompat.Type.navigationBars());
        controller.setSystemBarsBehavior(WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE);
    }
}
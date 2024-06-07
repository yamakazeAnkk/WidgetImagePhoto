package com.example.imagephoto;

import androidx.appcompat.app.AppCompatActivity;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.RemoteViews;

public class MainActivity extends AppCompatActivity {
    private ImageAdapter imageAdapter;
    private GridView gridView;
    private void updateWidget(Bitmap image) {
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(this);
        RemoteViews remoteViews = new RemoteViews(getPackageName(), R.layout.my_widget_provider);
        ComponentName thisWidget = new ComponentName(this, MyWidgetProvider.class);

        // Chỉ định ảnh được chọn cho widget
        remoteViews.setImageViewBitmap(R.id.image_view, image);

        // Cập nhật widget với ảnh được chọn
        appWidgetManager.updateAppWidget(thisWidget, remoteViews);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int[] images = {R.drawable.baseline_assist_walker_24, R.drawable.baseline_business_center_24,R.drawable.baseline_camera_alt_24,R.drawable.baseline_perm_camera_mic_24};
        gridView = findViewById(R.id.grid_view);
        imageAdapter = new ImageAdapter(this,images);
        gridView.setAdapter(imageAdapter);


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Lấy id của ảnh được chọn
                int selectedImageId = (Integer) imageAdapter.getItem(position);

                // Lấy bitmap từ id của ảnh được chọn
                Bitmap selectedImage = BitmapFactory.decodeResource(getResources(), selectedImageId);

                // Chuyển ảnh lên widget
                updateWidget(selectedImage);
            }

        });







    }
}
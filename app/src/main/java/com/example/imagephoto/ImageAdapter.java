package com.example.imagephoto;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.List;

public class ImageAdapter extends BaseAdapter {

    private Context context;
    private int[] ThumbIds;

    public ImageAdapter(Context context,int[] ThumbIds){
        this.context = context;
        this.ThumbIds =ThumbIds;
    }

    //...

    @Override
    public Object getItem(int i) {
        return ThumbIds[i];
    }

    //...


    @Override
    public int getCount() {
        return ThumbIds.length;
    }



    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            imageView = new ImageView(context);
            imageView.setLayoutParams(new GridView.LayoutParams(350, 350));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(ThumbIds[position]);

        return imageView;
    }

}

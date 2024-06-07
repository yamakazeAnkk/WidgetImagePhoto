package com.example.imagephoto;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

/**
 * Implementation of App Widget functionality.
 */
public class   MyWidgetProvider extends AppWidgetProvider {

    public static final String EXTRA_IMAGE_ID = "com.example.appwidget.EXTRA_IMAGE_ID";

    private void updateWidgetImage(Context context, int appWidgetId, int imageId) {


        RemoteViews views = new RemoteViews(context.getPackageName(),R.layout.my_widget_provider);
        views.setImageViewResource(R.id.image_view,imageId);
        Intent intent = new Intent(context,MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context,0, intent,0);
        views.setOnClickPendingIntent(R.id.image_view,pendingIntent);
        AppWidgetManager appWidgetManager1 = AppWidgetManager.getInstance(context);
        appWidgetManager1.updateAppWidget(appWidgetId,views);
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(AppWidgetManager.ACTION_APPWIDGET_UPDATE)){
            int appWidget = intent.getIntExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, AppWidgetManager.INVALID_APPWIDGET_ID);
            int imageID = intent.getIntExtra(EXTRA_IMAGE_ID, 0);
            updateWidgetImage(context, appWidget, imageID);
        }
        super.onReceive(context,intent);

    }
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // Nothing to do here
    }






}
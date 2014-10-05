package com.coolbong.barcodegenerator;

import android.appwidget.AppWidgetProviderInfo;
import android.appwidget.AppWidgetProvider;
import android.appwidget.AppWidgetManager;
import android.content.Context;
import com.coolbong.barcodegenerator.model.Code128;
import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.RemoteViews;

public class BarcodeWidgetProvider extends AppWidgetProvider {
    //public static final String UPDATE_BARCODE = "com.coolbong.barcodegenerator.UPDATE_BARCODE";

    /*@Override
    public void onReceive(Context context, Intent intent) {
        AppWidgetManager mgr = AppWidgetManager.getInstance(context);
        if (intent.getAction().equals(UPDATE_BARCODE)) {
            String barcode = intent.getStringExtra("barcode");
            updateBarcode(barcode);
        }
        super.onReceive(context, intent);
    }*/

    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        return;
    }

    /*private void updateBarcode(String barcode, Context context) {
        Code128 code = new Code128(context);
        code.setData(barcode);
        Bitmap bitmap = code.getBitmap(1000, 400);

        final int N = appWidgetIds.length;
        for (int i=0; i<N; i++) {
            int appWidgetId = appWidgetIds[i];

            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.widget);
            views.setImageViewBitmap(R.id.barcode, bitmap);
            appWidgetManager.updateAppWidget(appWidgetId, views);
        }
    }*/
}

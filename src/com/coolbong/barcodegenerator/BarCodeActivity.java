package com.coolbong.barcodegenerator;

import com.coolbong.barcodegenerator.model.Code128;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.appwidget.AppWidgetManager;
import android.widget.RemoteViews;
import android.content.Context;
import android.content.ComponentName;
import android.util.Log;

public class BarCodeActivity extends Activity {
    
    protected int mAppWidgetId = AppWidgetManager.INVALID_APPWIDGET_ID;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bar_code);
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if (extras != null) {
            mAppWidgetId = extras.getInt(
                    AppWidgetManager.EXTRA_APPWIDGET_ID, 
                    AppWidgetManager.INVALID_APPWIDGET_ID);
        }
    }
	
	public void drawBarcode(View view) {
        EditText barText = (EditText)findViewById(R.id.barcode_text);
        String barcode = barText.getText().toString();


        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(this);
        int[] appWidgetIds = { mAppWidgetId };
        if(mAppWidgetId == AppWidgetManager.INVALID_APPWIDGET_ID) {
            ComponentName widgetComponent = new ComponentName(this, BarcodeWidgetProvider.class);
            appWidgetIds = appWidgetManager.getAppWidgetIds(widgetComponent);
        }

        //325 24 73

        updateBarcode(barcode, this, appWidgetManager, appWidgetIds);

        Intent resultValue = new Intent();
        resultValue.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, mAppWidgetId);
        setResult(RESULT_OK, resultValue);
        finish();
	}

    public static void updateBarcode(String barcode, Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        Code128 code = new Code128(context);
        code.setData(barcode);
        Bitmap bitmap = code.getBitmap(800, 500);

        final int N = appWidgetIds.length;
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.widget);
        views.setImageViewBitmap(R.id.barcode, bitmap);
        appWidgetManager.updateAppWidget(appWidgetIds, views);
    }


	/*@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_bar_code, menu);
		return true;
	}*/

}

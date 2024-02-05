package com.example.yahome

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.os.Handler
import android.os.Looper
import android.widget.RemoteViews

/**
 * Implementation of App Widget functionality.
 */
class NewAppWidget : AppWidgetProvider() {
    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        for (appWidgetId in appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId)
        }
    }

    fun updateAppWidget(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetId: Int
    ) {
        val views = RemoteViews(context.packageName, R.layout.new_app_widget)
//        views.setonClik(R.id.switch1, RemoteViews.RemoteResponse.fromPendingIntent(getPendingSelfIntent(context, "MC_ACTION", PendingIntent.FLAG_IMMUTABLE)))

        Handler(Looper.getMainLooper()).post {
            appWidgetManager.updateAppWidget(appWidgetId, views)
        }
    }

    fun getPendingSelfIntent(context: Context, action: String, flag: Int): PendingIntent {
        val intent = Intent(context, javaClass);
        intent.setAction(action)
        return PendingIntent.getBroadcast(context, 0, intent, flag);
    }
}
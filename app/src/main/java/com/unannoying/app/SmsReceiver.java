package com.unannoying.app;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Looper;
import android.provider.Telephony;
import android.telephony.SmsMessage;
import android.util.Log;

import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class SmsReceiver extends BroadcastReceiver {
    private final Handler handler = new Handler(Looper.getMainLooper());
    private int notificationId = 0;

    @Override
    public void onReceive(Context context, Intent intent) {
        if (Telephony.Sms.Intents.SMS_RECEIVED_ACTION.equals(intent.getAction())) {
            for (SmsMessage sms : Telephony.Sms.Intents.getMessagesFromIntent(intent)) {
                String messageBody = sms.getMessageBody();
                String sender = sms.getDisplayOriginatingAddress();

                // We just log the message to console for now
                Log.d("received", messageBody);

                // Create the notification
                Runnable runnable = () -> createNotification(context, sender, messageBody);

                handler.postDelayed(runnable, 5000);
            }
        }
    }

    private void createNotification(Context context, String sender, String messageBody) {
        createNotificationChannel(context);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "10003")
                .setSmallIcon(R.drawable.notification)
                .setContentTitle("New SMS from " + sender)
                .setContentText(messageBody)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setAutoCancel(true);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);

        if (ActivityCompat.checkSelfPermission(context, android.Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            Log.e("Notification", "Permissions error");
            return;
        }
        notificationManager.notify(notificationId++, builder.build());
    }

    private void createNotificationChannel(Context context) {
        CharSequence name = "SMS Notifications";
        String description = "Include all the SMS notifications";
        int importance = NotificationManager.IMPORTANCE_HIGH;
        NotificationChannel channel = new NotificationChannel("10003", name, importance);
        channel.setDescription(description);
        channel.enableVibration(true);
        channel.setVibrationPattern(new long[] { 0, 1000, 500, 1000 });
        NotificationManager notificationManager = context.getSystemService(NotificationManager.class);
        notificationManager.createNotificationChannel(channel);
    }
}
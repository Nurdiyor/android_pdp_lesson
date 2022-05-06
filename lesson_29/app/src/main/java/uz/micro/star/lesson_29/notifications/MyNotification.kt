package uz.micro.star.lesson_29.notifications

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Build
import android.provider.Settings
import androidx.core.app.NotificationCompat
import androidx.core.graphics.get
import uz.micro.star.lesson_29.MainActivity
import uz.micro.star.lesson_29.R

class MyNotification {
    private val CHANNEL_ID = "my_channel_id"
    lateinit var manager: NotificationManager
    private lateinit var notification: Notification
    fun createNotificationChannel(context: Context) {
        manager = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            context.getSystemService(NotificationManager::class.java)!!
        } else {
            (context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager)
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val serviceChannel = NotificationChannel(
                CHANNEL_ID, "Foreground Service Channel",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            manager.createNotificationChannel(serviceChannel)
        }
    }
    fun createNotification(
        context: Context,
        title: String,
        body: String,
//        image: String?,
    ): Notification {
        val notificationIntent = Intent(context, MainActivity::class.java)
        notificationIntent.putExtra("FRAGMENT_NAME", "notification")
        val flags =
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                (PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT)
            } else {
                PendingIntent.FLAG_UPDATE_CURRENT
            }
        val pendingIntent = PendingIntent.getActivity(
            context,
            0, notificationIntent, flags
        )
        val bitmap=BitmapFactory.decodeResource(context.resources, R.drawable.car)
        notification = NotificationCompat.Builder(context, CHANNEL_ID)
            .setContentTitle(title)
            .setContentText(body)
            .setSubText("QQQQQQqqqqqq")
            .setSound(Settings.System.DEFAULT_NOTIFICATION_URI)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setColor(Color.GREEN)
            .setLargeIcon(bitmap)
            .setAutoCancel(true)
            .setStyle(NotificationCompat.BigPictureStyle().bigPicture(bitmap))
            .setContentIntent(pendingIntent)
            .setVibrate(
                longArrayOf(1000, 1000, 1000, 1000, 1000)
            )
            .build()
        return notification
    }
}
//package uz.micro.star.lesson_29.notifications
//
//import android.app.Notification
//import android.app.NotificationChannel
//import android.app.NotificationManager
//import android.app.PendingIntent
//import android.content.Context
//import android.content.Intent
//import android.graphics.Color
//import android.os.Build
//import android.provider.Settings.System.DEFAULT_NOTIFICATION_URI
//import androidx.core.app.NotificationCompat
//import uz.micro.star.lesson_29.MainActivity
//import uz.micro.star.lesson_29.R
//
///**
// * Created by Microstar on 27.03.2020.
// */
//class NotificationHelper {
//    var CHANNEL_ID = "davr-pay-payment-system"
//    lateinit var manager: NotificationManager
//    lateinit var notification: Notification
//
//    fun createNotificationChannel(context: Context) {
//        manager = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            context.getSystemService(NotificationManager::class.java)!!
//        } else {
//            (context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager)
//        }
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            val serviceChannel = NotificationChannel(
//                CHANNEL_ID, "Foreground Service Channel",
//                NotificationManager.IMPORTANCE_DEFAULT
//            )
//            manager.createNotificationChannel(serviceChannel)
//        }
//    }
//
//    fun createNotification(
//        context: Context,
//        title: String,
//        body: String,
//        image: String?,
//    ): Notification {
//        val notificationIntent = Intent(context, MainActivity::class.java)
//        notificationIntent.putExtra("FRAGMENT_NAME", "notification")
//        val flags =
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//                (PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT)
//            } else {
//                PendingIntent.FLAG_UPDATE_CURRENT
//            }
//        val pendingIntent = PendingIntent.getActivity(
//            context,
//            0, notificationIntent, flags
//        )
//        if (image.isNullOrEmpty().not()) {
//            try {
//                val futureTarget = Glide.with(context)
//                    .asBitmap()
//                    .load(image)
//                    .submit()
//                notification = NotificationCompat.Builder(context, CHANNEL_ID)
//                    .setContentTitle(title)
//                    .setContentText(body)
//                    .setSound(DEFAULT_NOTIFICATION_URI)
//                    .setSmallIcon(R.drawable.ic_launcher_foreground)
//                    .setColor(Color.GREEN)
//                    .setContentIntent(pendingIntent)
//                    .setVibrate(
//                        longArrayOf(1000, 1000, 1000, 1000, 1000)
//                    )
////                .setShowWhen(true)
//                    .setStyle(NotificationCompat.BigPictureStyle().bigPicture(futureTarget.get()))
//                    .setLargeIcon(futureTarget.get())
//                    .build()
//            } catch (e: Exception) {
//                notification = NotificationCompat.Builder(context, CHANNEL_ID)
//                    .setContentTitle(title)
//                    .setContentText(body)
//                    .setSound(DEFAULT_NOTIFICATION_URI)
//                    .setSmallIcon(R.drawable.ic_launcher_foreground)
//                    .setColor(Color.GREEN)
//                    .setContentIntent(pendingIntent)
//                    .setVibrate(
//                        longArrayOf(1000, 1000, 1000, 1000, 1000)
//                    ).build()
//            }
//        } else {
//            notification = NotificationCompat.Builder(context, CHANNEL_ID)
//                .setContentTitle(title)
//                .setContentText(body)
//                .setSound(DEFAULT_NOTIFICATION_URI)
//                .setSmallIcon(R.drawable.ic_launcher_foreground)
//                .setColor(Color.GREEN)
//                .setContentIntent(pendingIntent)
//                .setVibrate(
//                    longArrayOf(1000, 1000, 1000, 1000, 1000)
//                ).build()
//        }
//        return notification
//    }
//}
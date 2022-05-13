package uz.micro.star.lesson_31.firebase

import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MessageReceiverService : FirebaseMessagingService() {

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        Log.d("UUUU", "sendTokenToServer: ${remoteMessage.notification?.title}-" +
                "${remoteMessage.notification?.body}")
    
    }

    override fun onNewToken(p0: String) {
        super.onNewToken(p0)


    }

    private fun sendTokenToServer(p0: String) {
        //function for send token
        Log.d("UUUU", "sendTokenToServer: $p0")
    }

}

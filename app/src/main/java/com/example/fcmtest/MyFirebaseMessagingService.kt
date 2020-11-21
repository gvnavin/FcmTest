package com.example.fcmtest

import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.Toast
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService: FirebaseMessagingService() {

    private val TAG: String = "MyFirebaseMessagingService";

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)
        Log.w(TAG, "onMessageReceived")
        handleMessage(remoteMessage)
    }

    private fun handleMessage(remoteMessage: RemoteMessage) {

        Log.w(TAG, "handleMessage")

        //1
        val handler = Handler(Looper.getMainLooper())

        var str = remoteMessage.notification?.body
        var data = remoteMessage.data.toString()

        Log.w(TAG, "handleMessage " + str + " data : " + data);

        //2
        handler.post {
            Toast.makeText(baseContext, "handle_notification_now " + str, Toast.LENGTH_LONG).show()
        }
    }

}
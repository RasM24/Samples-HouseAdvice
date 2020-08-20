package ru.endroad.houseadvice.navigation

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.TaskStackBuilder
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.media.RingtoneManager
import android.net.Uri
import android.os.Build
import androidx.core.app.NotificationCompat
import com.google.firebase.messaging.RemoteMessage
import ru.endroad.houseadvice.R
import ru.endroad.houseadvice.application.SingleActivity
import ru.endroad.houseadvice.feature.push.PushRouting

class PushRoutingImpl(private val context: Context) : PushRouting {

	//TODO несоответствие названий и действий
	override fun openPushNotification(remoteMessage: RemoteMessage) {
		val data = remoteMessage.data

		val title = remoteMessage.notification?.title
		val message = remoteMessage.messageId
		val deepLink = data["deeplink"]


		sendNotification(context, title!!, message!!, deepLink!!)
	}

	private fun sendNotification(context: Context, title: String, message: String, deepLink: String) {
		val intent = Intent(context, SingleActivity::class.java)
			.apply {
				action = Intent.ACTION_VIEW
				data = Uri.parse(deepLink)
			}

		val notificationManager = getNotificationManager(context)

		val notificationBuilder = NotificationCompat.Builder(context, "channelId")
			.setSmallIcon(R.drawable.common_google_signin_btn_icon_dark)
			.setContentTitle(title)
			.setContentText(message)
			.setAutoCancel(true)
			.setNumber(1)
			.setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
			.setVibrate(longArrayOf(100, 200, 300, 400, 500, 400, 300, 200, 400))
			.setWhen(System.currentTimeMillis())

		notificationBuilder.setContentIntent(getPendingIntentForNotification(intent, context))
		notificationManager.notify(12, notificationBuilder.build())
	}

	private fun getPendingIntentForNotification(intent: Intent, context: Context): PendingIntent {
		val stackBuilder = TaskStackBuilder.create(context)
		stackBuilder.addNextIntent(intent)
		return stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT)
	}

	private fun getNotificationManager(context: Context): NotificationManager {
		val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
			val mChannel = NotificationChannel("channelId", "channelName", NotificationManager.IMPORTANCE_DEFAULT)
			mChannel.enableLights(true)
			mChannel.lightColor = Color.RED
			notificationManager.createNotificationChannel(mChannel)
		}

		return notificationManager
	}
}
package ru.endroad.houseadvice.feature.push

import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import org.koin.android.ext.android.inject

class PushNotificationService : FirebaseMessagingService() {

	private val routing: PushRouting by inject()

	override fun onMessageReceived(remoteMessage: RemoteMessage) {
		routing.openPushNotification(remoteMessage)
	}
}
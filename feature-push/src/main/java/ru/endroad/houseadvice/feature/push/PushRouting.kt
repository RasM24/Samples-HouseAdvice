package ru.endroad.houseadvice.feature.push

import com.google.firebase.messaging.RemoteMessage

interface PushRouting {

	fun openPushNotification(data: RemoteMessage)
}
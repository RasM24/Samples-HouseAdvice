package ru.endroad.shared.profile

class ProfileDataSource {

	private val hardcoreData = Profile(
		"Дволятик Олег",
		Flat("г. Новосибирск, ул. Центральная, д.2г", 43, 70f)
	)

	//TODO suspend нужен для понимания, что этот запрос может быть слишком долгим
	suspend fun get(): Profile {
		return hardcoreData
	}
}
package ru.endroad.feature.forum.data

class ForumDataSource {

	fun get(): List<ForumItem> = listOf(
		ForumItem.Category("Общая информация"),
		ForumItem.Topic("Расписание уборок", "Обсуждаем кому как лучше", 12),
		ForumItem.Topic("Отключения воды и света", "Света нет, но вы держитесь", 424),
		ForumItem.Category("Проблемы жильцов"),
		ForumItem.Topic("Сосед топит", "А может и не топит", 58),
		ForumItem.Topic("Отключили свет", "Нет света в квартире 66", 84),
		ForumItem.Topic("Громко стучит дверь в подъезде","Почините уже кто-нибудь доводчик =(", 75),
		ForumItem.Topic("Опять припарковались на газон", "Ну как так то", 56),
		ForumItem.Category("Потеряшки"),
		ForumItem.Topic("Потеряла брошку", "Фото приложила внутри", 56),
		ForumItem.Topic("Потеряла сердце", "Сосед из 23 квартиры - козел", 471681),
		ForumItem.Topic("Все потеряли совесть", "Почему никто не полил цветок?", 341)
	)
}
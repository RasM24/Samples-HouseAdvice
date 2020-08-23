package ru.endroad.shared.voting

import ru.endroad.shared.voting.model.Question
import ru.endroad.shared.voting.model.QuestionStatus

//TODO идеальным и единственным правильным решением было бы использовать interface, но мне лень тратить сейчас на это время =)
class QuestionsDataSource {

	private val hardcodeData = listOf(
		Question(
			0,
			"Ремонт подъезда",
			"Накопилось достаточно много денег с фонда капитального ремонта",
			QuestionStatus.OPEN,
			1598097778,
			1599097778
		),
		Question(
			1,
			"Смена домофонов",
			"На новые, красивые",
			QuestionStatus.SOON,
			1599097778,
			1599997778
		),
		Question(
			2,
			"Запрет стоительства парковки",
			"Негоже автобусам дымить выхлопом под окном",
			QuestionStatus.COMPLETED,
			1597097778,
			1598097778
		),
		Question(
			3,
			"Запретить выгул животных во дворе",
			"За домом есть прекрасное, оборудованное место, где собаки могут вдоволь набегаться и нагуляться",
			QuestionStatus.OPEN,
			1598097778,
			1599097778
		),
		Question(
			4,
			"установить шлагбаум",
			"Фирму выберем потом",
			QuestionStatus.SOON,
			1599097778,
			1599997778
		),
		Question(
			5,
			"Общий пикник во дворе",
			"Берем еду и детей. Главное не перепутать",
			QuestionStatus.COMPLETED,
			1593097778,
			1598097778
		),
		Question(
			6,
			"Субботник 5 сентября",
			"Берем лопаты, мешки и прочее. Будет убирать остатки расклейщиков объявлений",
			QuestionStatus.OPEN,
			1598097778,
			1599097778
		),
		Question(
			7,
			"Нанять вахтеров",
			"Я помню белые обои, черную посуду",
			QuestionStatus.SOON,
			1599097778,
			1599997778
		),
		Question(
			8,
			"Пускать ли собак на расклейщиков объявлений?",
			"Всех же бесят такие люди, которые портят клеем чистые двери?",
			QuestionStatus.COMPLETED,
			1587097778,
			1598097778
		),
		Question(
			9,
			"Выбор цветов",
			"Фиалки, розы, гвоздики. А какие любимые цветы у тебя? Что предпочтешь видеть у себя под окнами?",
			QuestionStatus.OPEN,
			1598097778,
			1599097778
		),
		Question(
			10,
			"Смена ТСЖ",
			"Голосуем за смену ТСЖ. Старая не справляется со своими должностями",
			QuestionStatus.SOON,
			1599097778,
			1599997778
		)
	)







	//TODO suspend нужен для понимания, что этот запрос может быть слишком долгим
	suspend fun get(): List<Question> {
		return hardcodeData.sortedBy { it.status }
	}

	//TODO стоило бы разделить dataSource, но для ускорения разработки решено оставить так
	suspend fun get(id: Long): Question {
		val question = hardcodeData.find { it.id == id }
		return checkNotNull(question)
	}
}
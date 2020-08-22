package ru.endroad.shared.voting

import ru.endroad.shared.voting.model.Question
import ru.endroad.shared.voting.model.QuestionStatus

//TODO идеальным и единственным правильным решением было бы использовать interface, но мне лень тратить сейчас на это время =)
class QuestionsDataSource {

	private val hardcodeData = listOf(
		Question(
			0,
			"Выбор цветов",
			"Фиалки, розы, гвоздики. А какие любимые цветы у тебя? Что предпочтешь видеть у себя под окнами?",
			QuestionStatus.OPEN,
			1598097778,
			1599097778
		),
		Question(
			1,
			"Смена ТСЖ",
			"",
			QuestionStatus.SOON,
			1599097778,
			1599997778
		),
		Question(
			2,
			"Запрет стоительства парковки",
			"",
			QuestionStatus.COMPLETED,
			1597097778,
			1598097778
		),
		Question(
			3,
			"Выбор цветов",
			"Фиалки, розы, гвоздики. А какие любимые цветы у тебя? Что предпочтешь видеть у себя под окнами?",
			QuestionStatus.OPEN,
			1598097778,
			1599097778
		),
		Question(
			4,
			"Смена ТСЖ",
			"",
			QuestionStatus.SOON,
			1599097778,
			1599997778
		),
		Question(
			5,
			"Запрет стоительства парковки",
			"",
			QuestionStatus.COMPLETED,
			1593097778,
			1598097778
		),
		Question(
			6,
			"Выбор цветов",
			"Фиалки, розы, гвоздики. А какие любимые цветы у тебя? Что предпочтешь видеть у себя под окнами?",
			QuestionStatus.OPEN,
			1598097778,
			1599097778
		),
		Question(
			7,
			"Смена ТСЖ",
			"",
			QuestionStatus.SOON,
			1599097778,
			1599997778
		),
		Question(
			8,
			"Запрет стоительства парковки",
			"",
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
			"",
			QuestionStatus.SOON,
			1599097778,
			1599997778
		),
		Question(
			11,
			"Запрет стоительства парковки",
			"",
			QuestionStatus.COMPLETED,
			1596097778,
			1598097778
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
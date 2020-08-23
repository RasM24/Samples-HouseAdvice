package ru.endroad.shared.voting

import ru.endroad.shared.voting.model.Question
import ru.endroad.shared.voting.model.QuestionStatus

//TODO идеальным и единственным правильным решением было бы использовать interface, но мне лень тратить сейчас на это время =)
class QuestionsDataSource {

	val hardcodeData = listOf<Question>(
		Question(
			0,
			"Выбор цветов",
			"",
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
		)
	)

	fun get(): List<Question> {
		return hardcodeData
	}
}
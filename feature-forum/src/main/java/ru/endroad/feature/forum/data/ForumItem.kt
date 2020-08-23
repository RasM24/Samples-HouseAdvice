package ru.endroad.feature.forum.data

 sealed class ForumItem {
	data class Category(val name: String) : ForumItem()
	data class Topic(val name: String, val desc: String, val answerCount: Int) : ForumItem()
}
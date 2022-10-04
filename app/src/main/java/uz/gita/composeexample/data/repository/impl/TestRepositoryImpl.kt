package uz.gita.composeexample.data.repository.impl

import uz.gita.composeexample.data.models.QuestionData
import uz.gita.composeexample.data.repository.TestRepository
import javax.inject.Inject

class TestRepositoryImpl @Inject constructor(): TestRepository {
    override suspend fun getTests() = listOf(
        QuestionData("2+2", "2", "1", "3", "4", "4"),
        QuestionData("3+2", "2", "1", "3", "5", "5"),
        QuestionData("2+5", "2", "5", "3", "4", "5"),
        QuestionData("0+2", "2", "1", "3", "4", "2"),
        QuestionData("1+1", "2", "1", "3", "4", "2")
    )
}
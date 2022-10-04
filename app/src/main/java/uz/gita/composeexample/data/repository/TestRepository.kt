package uz.gita.composeexample.data.repository

import uz.gita.composeexample.data.models.QuestionData


interface TestRepository {

    suspend fun getTests(): List<QuestionData>

}
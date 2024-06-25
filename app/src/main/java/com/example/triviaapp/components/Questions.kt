package com.example.triviaapp.components

import android.util.Log
import androidx.compose.runtime.Composable
import com.example.triviaapp.screens.QuestionsViewModel

@Composable
fun Questions(viewModel: QuestionsViewModel) {
    val questions = viewModel.data.value.data?.toMutableList()
    if (viewModel.data.value.loading == true) {
        Log.d("Loading", "Questions: ...Loading..")
    } else {
        Log.d("Loading", "Questions: Loading Stopped")
        questions?.forEach { questionItem ->
            Log.d("Result", "Questions:${questionItem.question}")
        }
    }
}

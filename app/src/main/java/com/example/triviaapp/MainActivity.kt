package com.example.triviaapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.triviaapp.screens.QuestionsViewModel
import com.example.triviaapp.ui.theme.TriviaAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TriviaAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TriviaHome()

                }
            }
        }
    }
}
@Composable
fun TriviaHome( viewModel: QuestionsViewModel = hiltViewModel())  {
    Questions(viewModel)
}

fun Questions(viewModel: QuestionsViewModel) {
    val questions=viewModel.data.value.data?.toMutableList()
    if(viewModel.data.value.loading == true)
        Log.d("Loading","Questions: ...Loading..")
    else{
        Log.d("Loading","Questions: Loading Stopped")
        questions?.forEach{questionItem ->  
            Log.d("Result","Questions:${questionItem.question}")
        }
    }

}


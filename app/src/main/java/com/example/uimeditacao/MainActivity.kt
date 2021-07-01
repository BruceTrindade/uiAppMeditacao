package com.example.uimeditacao


import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.uimeditacao.ui.compose.ProfileScreen
import com.example.uimeditacao.ui.theme.MeditationUIYouTubeTheme

@ExperimentalFoundationApi
class MainActivity : AppCompatActivity() {
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
           MeditationUIYouTubeTheme {
               HomeScreen()
              //ProfileScreen()
            }
        }
    }



}




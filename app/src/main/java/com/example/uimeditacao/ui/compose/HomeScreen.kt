package com.example.uimeditacao

//import androidx.compose.foundation.Canvas
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyRow
//import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
//import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.graphics.Path
import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
//import androidx.compose.ui.unit.sp
//import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
//import com.example.uimeditacao.BottomMenuContent
//import com.example.uimeditacao.Feature
//import com.example.uimeditacao.R
//import com.example.uimeditacao.standardQuadFromTo
//import com.example.uimeditacao.ui.compose.FeatureItem
import com.example.uimeditacao.ui.compose.ProfileScreen
import com.example.uimeditacao.ui.compose.principal
import com.example.uimeditacao.ui.theme.*
import java.security.Principal


@ExperimentalFoundationApi
@Preview
@Composable
fun HomeScreen() {
    val navController = rememberNavController()
      Box(
        modifier = Modifier
            .background(DeepBlue)
            .fillMaxSize()
    ) {
          NavHost(navController = navController, startDestination = "Inicio"){

              composable("Inicio"){
                  principal()
              }

              composable("Perfil"){
                  ProfileScreen()
              }

//              composable()


          }

        BottomMenu(items = listOf(
            BottomMenuContent("Inicio", R.drawable.ic_home),
            BottomMenuContent("Meditação", R.drawable.ic_bubble),
            BottomMenuContent("Dormir", R.drawable.ic_moon),
            BottomMenuContent("Musica", R.drawable.ic_music),
            BottomMenuContent("Perfil", R.drawable.ic_profile),
        ),navController = navController, modifier = Modifier.align(Alignment.BottomCenter))

    }//this: cope

}//HomeScreen


@ExperimentalFoundationApi
@Composable
fun BottomMenu(
    items: List<BottomMenuContent>,
    modifier: Modifier = Modifier,
    activeHighlightColor: Color = ButtonBlue,
    activeTextColor: Color = Color.White,
    inactiveTextColor: Color = AquaBlue,
    initialSelectedItemIndex: Int = 0,
    navController: NavController
) {
    var selectedItemIndex by remember {
        mutableStateOf(initialSelectedItemIndex)
    }
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .background(DeepBlue)
            .padding(15.dp)
    ) {
        items.forEachIndexed { index, item ->
            BottomMenuItem(
                item = item,
                isSelected = index == selectedItemIndex,
                activeHighlightColor = activeHighlightColor,
                activeTextColor = activeTextColor,
                inactiveTextColor = inactiveTextColor,
                navController = navController
            ) {
                selectedItemIndex = index
            }
        }
    }
}

@ExperimentalFoundationApi
@Composable
fun BottomMenuItem(
    item: BottomMenuContent,
    isSelected: Boolean = false,
    activeHighlightColor: Color = ButtonBlue,
    activeTextColor: Color = Color.White,
    inactiveTextColor: Color = AquaBlue,
    navController: NavController,
    onItemClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.clickable {
            onItemClick()
            navController.navigate(item.title)

        }
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .background(if (isSelected) activeHighlightColor else Color.Transparent)
                .padding(10.dp)
        ) {
            Icon(
                painter = painterResource(id = item.iconId),
                contentDescription = item.title,
                tint = if (isSelected) activeTextColor else inactiveTextColor,
                modifier = Modifier.size(20.dp)
            )
        }
        Text(
            text = item.title,
            color = if(isSelected) activeTextColor else inactiveTextColor
        )
    }
}


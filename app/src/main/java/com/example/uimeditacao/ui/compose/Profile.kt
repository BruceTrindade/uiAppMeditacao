package com.example.uimeditacao.ui.compose

import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uimeditacao.*
import com.example.uimeditacao.R
import com.example.uimeditacao.ui.theme.*

@Preview(device = Devices.PIXEL_XL)
@ExperimentalFoundationApi
@Composable
fun ProfileScreen() {
    Box(
        modifier = Modifier
            .background(DeepBlue)
            .fillMaxSize()

    ){
        Column (modifier = Modifier

     ){
            CurrentMeditation()
            FeatureSection(
                features = listOf(
                    Feature(
                        title = "Meditação para dormir",
                        R.drawable.ic_headphone,
                        BlueViolet1,
                        BlueViolet2,
                        BlueViolet3
                    ),
                    Feature(
                        title = "Dicas para dormir",
                        R.drawable.ic_videocam,
                        LightGreen1,
                        LightGreen2,
                        LightGreen3
                    ),
                    Feature(
                        title = "Ilha Noturna",
                        R.drawable.ic_headphone,
                        OrangeYellow1,
                        OrangeYellow2,
                        OrangeYellow3
                    ),
                    Feature(
                        title = "Sons calmos",
                        R.drawable.ic_headphone,
                        Beige1,
                        Beige2,
                        Beige3
                    )
                ))
        }

       BottomMenu(items = listOf(
                BottomMenuContent("Inicio", R.drawable.ic_home),
                BottomMenuContent("Meditação", R.drawable.ic_bubble),
                BottomMenuContent("Dormir", R.drawable.ic_moon),
                BottomMenuContent("Musica", R.drawable.ic_music),
                BottomMenuContent("Perfil", R.drawable.ic_profile),
            ), modifier = Modifier.align(Alignment.BottomCenter)
        )

    }

}

@Composable
fun BottomMenu(
    items: List<BottomMenuContent>,
    modifier: Modifier = Modifier,
    activeHighlightColor: Color = ButtonBlue,
    activeTextColor: Color = Color.White,
    inactiveTextColor: Color = AquaBlue,
    initialSelectedItemIndex: Int = 0
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
                inactiveTextColor = inactiveTextColor
            ) {
                selectedItemIndex = index
            }
        }
    }
}

@Composable
fun BottomMenuItem(
    item: BottomMenuContent,
    isSelected: Boolean = false,
    activeHighlightColor: Color = ButtonBlue,
    activeTextColor: Color = Color.White,
    inactiveTextColor: Color = AquaBlue,
    onItemClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.clickable {
            onItemClick()
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


@Composable
fun CurrentMeditation(
    //color: Color = LightRed
) {
    Column(
       verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
           .fillMaxWidth()
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        Surface(
            color = DarkerButtonBlue,
              modifier = Modifier
                  .fillMaxWidth(0.5f)
                  .fillMaxHeight(0.3f)
                  .clip(RoundedCornerShape(30.dp))
                  .background(DarkerButtonBlue)
                  .padding(start = 40.dp, end = 20.dp, top = 20.dp)

        ) {         Icon(
                    painter = painterResource(id = R.drawable.ic_profile),
                    contentDescription = "Photo",
                    tint = DeepBlue,
                    modifier = Modifier.size(80.dp)
                )
            }



        Column {
            Text(
                text = "Bruce Trindade",
                style = MaterialTheme.typography.h2,
                textAlign = TextAlign.Center,
                modifier = Modifier.width(180.dp)
            )
            Text(
                text = "brucetrindade@compose.com",
                style = MaterialTheme.typography.body1,
                color = TextWhite,
                textAlign = TextAlign.Center,
                modifier = Modifier.width(200.dp)
            )

        }
    }
}

@Composable
fun FeatureItem(
    feature: Feature
) {
    BoxWithConstraints(
        modifier = Modifier
            .padding(7.5.dp)
            .aspectRatio(1f)
            .clip(RoundedCornerShape(10.dp))
            .background(feature.darkColor)
    ) {
        val width = constraints.maxWidth
        val height = constraints.maxHeight

        // Medium colored path
        val mediumColoredPoint1 = Offset(0f, height * 0.3f)
        val mediumColoredPoint2 = Offset(width * 0.1f, height * 0.35f)
        val mediumColoredPoint3 = Offset(width * 0.4f, height * 0.05f)
        val mediumColoredPoint4 = Offset(width * 0.75f, height * 0.7f)
        val mediumColoredPoint5 = Offset(width * 1.4f, -height.toFloat())

        val mediumColoredPath = Path().apply {
            moveTo(mediumColoredPoint1.x, mediumColoredPoint1.y)
            standardQuadFromTo(mediumColoredPoint1, mediumColoredPoint2)
            standardQuadFromTo(mediumColoredPoint2, mediumColoredPoint3)
            standardQuadFromTo(mediumColoredPoint3, mediumColoredPoint4)
            standardQuadFromTo(mediumColoredPoint4, mediumColoredPoint5)
            lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
            lineTo(-100f, height.toFloat() + 100f)
            close()
        }

        // Light colored path
        val lightPoint1 = Offset(0f, height * 0.35f)
        val lightPoint2 = Offset(width * 0.1f, height * 0.4f)
        val lightPoint3 = Offset(width * 0.3f, height * 0.35f)
        val lightPoint4 = Offset(width * 0.65f, height.toFloat())
        val lightPoint5 = Offset(width * 1.4f, -height.toFloat() / 3f)

        val lightColoredPath = Path().apply {
            moveTo(lightPoint1.x, lightPoint1.y)
            standardQuadFromTo(lightPoint1, lightPoint2)
            standardQuadFromTo(lightPoint2, lightPoint3)
            standardQuadFromTo(lightPoint3, lightPoint4)
            standardQuadFromTo(lightPoint4, lightPoint5)
            lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
            lineTo(-100f, height.toFloat() + 100f)
            close()
        }
        Canvas(
            modifier = Modifier
                .fillMaxSize()
        ) {
            drawPath(
                path = mediumColoredPath,
                color = feature.mediumColor
            )
            drawPath(
                path = lightColoredPath,
                color = feature.lightColor
            )
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp)
        ) {
            Text(
                text = feature.title,
                style = MaterialTheme.typography.h2,
                lineHeight = 26.sp,
                modifier = Modifier.align(Alignment.TopStart)
            )
            Icon(
                painter = painterResource(id = feature.iconId),
                contentDescription = feature.title,
                tint = Color.White,
                modifier = Modifier.align(Alignment.BottomStart)
            )
            Text(
                text = "Start",
                color = TextWhite,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .clickable {
                        // Handle the click
                    }
                    .align(Alignment.BottomEnd)
                    .clip(RoundedCornerShape(10.dp))
                    .background(ButtonBlue)
                    .padding(vertical = 6.dp, horizontal = 15.dp)
            )
        }
    }
}


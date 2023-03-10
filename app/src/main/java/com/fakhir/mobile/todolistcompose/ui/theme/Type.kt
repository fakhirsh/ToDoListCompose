package com.fakhir.mobile.todolistcompose.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.fakhir.mobile.todolistcompose.R

val TrenchThin = FontFamily(
    Font(R.font.trench_thin),
)

val Montserrat = FontFamily(
    Font(R.font.montserrat_regular),
    Font(R.font.montserrat_bold, FontWeight.Bold)
)

// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    h6 = TextStyle(
        fontFamily = Montserrat,
        fontWeight = FontWeight.Bold,
        fontSize = 30.sp,
        shadow = Shadow(
            color = BrightOrange,
            offset = Offset(0f, 0f),
            blurRadius = 10f
        )
    ),
    subtitle1 = TextStyle(
        fontFamily = TrenchThin,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
        shadow = Shadow(
                        color = BrightOrange,
                        offset = Offset(0f, 0f),
                        blurRadius = 6.5f
                 )

    ),
    subtitle2 = TextStyle(
        fontFamily = TrenchThin,
        fontWeight = FontWeight.Bold,
        //fontSize = 24.sp,
        shadow = Shadow(
            color = BrightOrange,
            offset = Offset(0f, 0f),
            blurRadius = 4f
        )

    ),

    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)
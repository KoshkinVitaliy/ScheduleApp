package com.example.scheduleapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.scheduleapp.ui.theme.ScheduleAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScheduleAppTheme {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Brush.linearGradient(listOf(
                            Color(0xFF380D4B), Color(0xFF101346)
                        )))
                        .verticalScroll(rememberScrollState())
                ) {
                    ScheduleItem("СР", "3 апреля")
                    ScheduleItem("ЧТ", "4 апреля")
                    ScheduleItem("ПТ", "5 апреля")
                    ScheduleItem("ПН", "8 апреля")
                    ScheduleItem("ВТ", "9 апреля")
                }
            }
        }
    }
}

@Composable
private fun ScheduleItem(day: String, date: String) {
    Card(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        ),
        shape = RoundedCornerShape(15.dp)

    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Row() {
                Box(
                    modifier = Modifier
                        .padding(10.dp)
                        .height(50.dp)
                        .width(100.dp)
                        .clip(RoundedCornerShape(30.dp))
                        .background(Color(0xFFFD0C60))
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxSize(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(text = day, color = Color.White)
                    }
                }
                Box(
                    modifier = Modifier
                        .padding(10.dp)
                        .height(50.dp)
                        .width(200.dp)
                        .clip(RoundedCornerShape(30.dp))
                        .background(Color(0xFF5DB924))
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxSize(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(text = date, color = Color.White)
                    }
                }
            }
            LessonItem(1, "9:00 - 10:30", "Внедрение информационных систем", "Кошкин В.А.")
            LessonItem(2,"10:50 - 12:20","Разработка кода информационных систем", "Кошкин В.А.")
            LessonItem(3,"13:25 - 14:45","Проектирование и дизайн информационных систем", "Кошкин В.А.")
            LessonItem(4,"15:00 - 16:20","Моделирование и анализ ПО", "Кошкин В.А.")
        }
    }
}


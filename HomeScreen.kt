package com.aestheticanimevault.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class WallpaperItem(
    val id: Int,
    val title: String,
    val category: String,
    val color1: Color,
    val color2: Color
)

private val mockWallpapers = listOf(
    WallpaperItem(
        1,
        "Cozy Anime Room",
        "Cozy Anime",
        Color(0xFF2C1E3B),
        Color(0xFF8A5A7A)
    ),
    WallpaperItem(
        2,
        "Anime Waterfall",
        "Nature Aesthetic",
        Color(0xFF123C46),
        Color(0xFF2D8A72)
    ),
    WallpaperItem(
        3,
        "Anime Beach Sunset",
        "Summer Aesthetic",
        Color(0xFF5B2940),
        Color(0xFFE38B5B)
    ),
    WallpaperItem(
        4,
        "Anime Mountain",
        "Nature Scenery",
        Color(0xFF26364A),
        Color(0xFF607D8B)
    ),
    WallpaperItem(
        5,
        "Anime Sakura Garden",
        "Seasonal",
        Color(0xFF492C3C),
        Color(0xFFD47A9B)
    ),
    WallpaperItem(
        6,
        "Anime Neon City",
        "Cyberpunk",
        Color(0xFF10152D),
        Color(0xFF3D5AFE)
    )
)

@Composable
fun HomeScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0D0D12))
            .padding(horizontal = 16.dp)
    ) {

        Spacer(modifier = Modifier.height(28.dp))

        Text(
            text = "Anime Aesthetic Vault",
            color = Color.White,
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(6.dp))

        Text(
            text = "Anime-inspired wallpapers & aesthetic backgrounds",
            color = Color.LightGray,
            fontSize = 14.sp
        )

        Spacer(modifier = Modifier.height(20.dp))

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(bottom = 24.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            items(mockWallpapers) { wallpaper ->

                WallpaperCard(wallpaper)
            }
        }
    }
}

@Composable
private fun WallpaperCard(
    wallpaper: WallpaperItem
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(230.dp)
            .clickable { },

        shape = RoundedCornerShape(16.dp),

        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF1A1A22)
        )
    ) {

        Column(
            modifier = Modifier.fillMaxSize()
        ) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                wallpaper.color1,
                                wallpaper.color2
                            )
                        )
                    )
            )

            Column(
                modifier = Modifier.padding(10.dp)
            ) {

                Text(
                    text = wallpaper.title,
                    color = Color.White,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.SemiBold,
                    maxLines = 1
                )

                Spacer(modifier = Modifier.height(3.dp))

                Text(
                    text = wallpaper.category,
                    color = Color.Gray,
                    fontSize = 11.sp,
                    maxLines = 1
                )
            }
        }
    }
}
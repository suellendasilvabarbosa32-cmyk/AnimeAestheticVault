
package com.aestheticanimevault.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
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
    val resolution: String,
    val orientation: String,
    val color1: Color,
    val color2: Color
)

val mockWallpapers = listOf(
    WallpaperItem(
        1,
        "Cozy Anime Room",
        "Environment Aesthetic",
        "1080x1920",
        "Portrait",
        Color(0xFF2C1E3B),
        Color(0xFF5C3D6E)
    ),
    WallpaperItem(
        2,
        "Anime Waterfall",
        "Mood Aesthetic",
        "1080x1920",
        "Portrait",
        Color(0xFF1B3B36),
        Color(0xFF2D6A4F)
    ),
    WallpaperItem(
        3,
        "Anime Beach Sunset",
        "Lifestyle Aesthetic",
        "1080x1920",
        "Portrait",
        Color(0xFF4A1525),
        Color(0xFFB5525C)
    ),
    WallpaperItem(
        4,
        "Anime Mountain",
        "Anime Wallpapers",
        "1080x1920",
        "Portrait",
        Color(0xFF1F2937),
        Color(0xFF4B5563)
    ),
    WallpaperItem(
        5,
        "Anime Sakura Garden",
        "Seasonal Content",
        "1080x1920",
        "Portrait",
        Color(0xFF3B1E2E),
        Color(0xFF8C5271)
    ),
    WallpaperItem(
        6,
        "Anime Neon City",
        "Style & Visual Trends",
        "1080x1920",
        "Portrait",
        Color(0xFF0F172A),
        Color(0xFF3B82F6)
    )
)

@Composable
fun HomeScreen(onWallpaperClick: (Int) -> Unit) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Anime Aesthetic Vault",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = "Discover beautiful anime-inspired wallpapers",
            fontSize = 14.sp,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(20.dp))

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.fillMaxSize()
        ) {

            items(mockWallpapers) { wallpaper ->

                WallpaperCard(
                    wallpaper = wallpaper,
                    onClick = {
                        onWallpaperClick(wallpaper.id)
                    }
                )
            }
        }
    }
}

@Composable
fun WallpaperCard(
    wallpaper: WallpaperItem,
    onClick: () -> Unit
) {

    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF1E1E1E)
        ),
        modifier = Modifier
            .fillMaxWidth()
            .height(220.dp)
            .clickable(onClick = onClick)
    ) {

        Column(
            modifier = Modifier.fillMaxSize()
        ) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                wallpaper.color1,
                                wallpaper.color2
                            )
                        )
                    )
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            ) {

                Text(
                    text = wallpaper.title,
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 13.sp,
                    maxLines = 1
                )

                Spacer(modifier = Modifier.height(2.dp))

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

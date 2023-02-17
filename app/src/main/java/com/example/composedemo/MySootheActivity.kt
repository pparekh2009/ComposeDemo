package com.example.composedemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

class MySootheActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val alignYourBodyData = listOf(
                Item(R.drawable.ab1_inversions, "Inversions"),
                Item(R.drawable.ab2_quick_yoga, "Quick Yoga"),
                Item(R.drawable.ab3_stretching, "Stretching"),
                Item(R.drawable.ab4_tabata, "Tabata"),
                Item(R.drawable.ab5_hiit, "HIIT"),
                Item(R.drawable.ab6_pre_natal_yoga, "Pre-natal Yoga"),
            )

            val favoriteCollectionsData = listOf(
                Item(R.drawable.fc1_short_mantras, "Short Mantras"),
                Item(R.drawable.fc2_nature_meditations, "Nature Meditations"),
                Item(R.drawable.fc3_stress_and_anxiety, "Stress and Anxiety"),
                Item(R.drawable.fc4_self_massage, "Self Massage"),
                Item(R.drawable.fc5_overwhelmed, "Overwhelmed"),
                Item(R.drawable.fc6_nightly_wind_down, "Nightly Wind Down"),
            )

            Column(modifier = Modifier.fillMaxWidth()) {
                SearchBar(modifier = Modifier.padding(15.dp))
                AlignYourBodyRow(alignYourBodyData = alignYourBodyData)
                FavoriteCollectionsGrid(favoriteCollectionsData = favoriteCollectionsData)
            }
        }
    }
}

@Composable
fun SearchBar(modifier: Modifier = Modifier) {
    TextField(
        value = "",
        onValueChange = {},
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 56.dp),
        leadingIcon = {
            Icon(imageVector = Icons.Default.Search, contentDescription = "Search")
        },
        placeholder = {
            Text(text = "Search")
        })
}

@Composable
fun AlignYourBodyElement(@DrawableRes drawable: Int, text: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = drawable),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = modifier
                .size(88.dp)
                .clip(CircleShape)
        )
        Text(
            text = text,
            style = MaterialTheme.typography.h6,
            modifier = Modifier.paddingFromBaseline(
                top = 24.dp, bottom = 8.dp
            )
        )
    }
}

@Composable
fun FavoriteCollectionCard(
    text: String,
    @DrawableRes drawable: Int,
    modifier: Modifier = Modifier
) {
    Surface(
        shape = MaterialTheme.shapes.small,
        modifier = modifier
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.width(192.dp)
        ) {
            Image(
                painter = painterResource(drawable),
                contentDescription = null
            )
            Text(
                text = text
            )
        }
    }
}

@Composable
fun AlignYourBodyRow(alignYourBodyData: List<Item>, modifier: Modifier = Modifier) {

    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier) {
        items(alignYourBodyData) {
            AlignYourBodyElement(drawable = it.drawable, text = it.text)
        }
    }
}

@Composable
fun FavoriteCollectionsGrid(
    favoriteCollectionsData: List<Item>,
    modifier: Modifier = Modifier
) {
//    LazyHorizontalGrid(
//        rows = GridCells.Fixed(2),
//        contentPadding = PaddingValues(horizontal = 16.dp),
//        horizontalArrangement = Arrangement.spacedBy(8.dp),
//        verticalArrangement = Arrangement.spacedBy(8.dp),
//        modifier = modifier.height(120.dp)
//    ) {
//        items(favoriteCollectionsData) {
//            FavoriteCollectionCard(
//                drawable = it.drawable,
//                text = it.text,
//                modifier = Modifier.height(56.dp)
//            )
//        }
//    }
}
package com.example.composedemo

import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composedemo.ui.theme.ComposeDemoTheme
import java.util.*

class MySootheActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeDemoTheme() {
                Scaffold(bottomBar = {
                    SootheBottomNavigation()
                }) {
                    HomeScreen()
                }
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
            style = MaterialTheme.typography.body1,
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
            modifier = modifier.width(192.dp)
        ) {
            Image(
                painter = painterResource(drawable),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = modifier.fillMaxWidth(0.3f)
            )
            Text(
                text = text,
                modifier = modifier.padding(start = 10.dp, top = 0.dp, end = 0.dp, bottom = 0.dp)
            )
        }
    }
}

@Composable
fun AlignYourBodyRow(modifier: Modifier = Modifier) {

    val alignYourBodyData = listOf(
        Item(R.drawable.ab1_inversions, "Inversions"),
        Item(R.drawable.ab2_quick_yoga, "Quick Yoga"),
        Item(R.drawable.ab3_stretching, "Stretching"),
        Item(R.drawable.ab4_tabata, "Tabata"),
        Item(R.drawable.ab5_hiit, "HIIT"),
        Item(R.drawable.ab6_pre_natal_yoga, "Pre-natal Yoga"),
    )

    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(18.dp),
        verticalAlignment = Alignment.CenterVertically,
        contentPadding = PaddingValues(horizontal = 24.dp),
        modifier = modifier.height(150.dp)) {
        items(alignYourBodyData) {
            AlignYourBodyElement(drawable = it.drawable, text = it.text)
        }
    }
}

@Composable
fun FavoriteCollectionsGrid(modifier: Modifier = Modifier) {

    val favoriteCollectionsData = listOf(
        Item(R.drawable.fc1_short_mantras, "Short Mantras"),
        Item(R.drawable.fc2_nature_meditations, "Nature Meditations"),
        Item(R.drawable.fc3_stress_and_anxiety, "Stress and Anxiety"),
        Item(R.drawable.fc4_self_massage, "Self Massage"),
        Item(R.drawable.fc5_overwhelmed, "Overwhelmed"),
        Item(R.drawable.fc6_nightly_wind_down, "Nightly Wind Down"),
    )

    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.height(80.dp)
    ) {
        items(favoriteCollectionsData) {
            FavoriteCollectionCard(
                drawable = it.drawable,
                text = it.text,
                modifier = modifier.height(56.dp)
            )
        }
    }
}

@Composable
fun HomeSection(
    title: String,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Column(modifier) {
        Text(
            text = title.uppercase(Locale.getDefault()),
            style = MaterialTheme.typography.h6,
            fontWeight = FontWeight.Light,
            modifier = Modifier
                .paddingFromBaseline(top = 40.dp, bottom = 8.dp)
                .padding(horizontal = 16.dp)
        )
        content()
    }
}

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Column(modifier = modifier
        .verticalScroll(rememberScrollState())
        .padding(vertical = 16.dp)) {
        Spacer(modifier = Modifier.height(16.dp))
        SearchBar(Modifier.padding(horizontal = 16.dp))
        HomeSection(title = "Align your body") {
            AlignYourBodyRow()
        }
        HomeSection(title = "Favourite Collections") {
            FavoriteCollectionsGrid()
        }
        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Composable
fun SootheBottomNavigation(modifier: Modifier = Modifier) {
    BottomNavigation(
        backgroundColor = MaterialTheme.colors.background,
        modifier = modifier) {
        BottomNavigationItem(
            icon = {
                   Icon(imageVector = Icons.Default.Place, contentDescription = null)
            },
            label = {
                    Text(text = "Home")
            },
            selected = true, onClick = {})
        BottomNavigationItem(
            icon = {
                Icon(imageVector = Icons.Default.AccountCircle, contentDescription = null)
            },
            label = {
                Text(text = "Profile")
            },
            selected = false, onClick = {})
    }
}
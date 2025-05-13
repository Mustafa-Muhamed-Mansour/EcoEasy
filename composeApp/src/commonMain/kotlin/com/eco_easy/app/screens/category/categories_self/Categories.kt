package com.eco_easy.app.screens.category.categories_self

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.navigator.LocalNavigator
import com.eco_easy.app.compositions.FABComposition
import com.eco_easy.app.compositions.states.StateError
import com.eco_easy.app.compositions.states.StateLoading
import com.eco_easy.app.screens.category.content_of_categories.ContentOfCategoriesScreen
import com.eco_easy.app.screens.home.HomeProductsScreen
import com.eco_easy.app.view_models.CategoriesViewModel
import compose.icons.FeatherIcons
import compose.icons.feathericons.Home
import ecoeasy.composeapp.generated.resources.Res
import ecoeasy.composeapp.generated.resources.appliances
import ecoeasy.composeapp.generated.resources.audio
import ecoeasy.composeapp.generated.resources.gaming
import ecoeasy.composeapp.generated.resources.laptop
import ecoeasy.composeapp.generated.resources.mobile
import ecoeasy.composeapp.generated.resources.tv
import org.jetbrains.compose.resources.painterResource

@Composable
fun Categories(
    viewModel: CategoriesViewModel
) {
    val uiState by viewModel.uiState.collectAsState()
    val navigator = LocalNavigator.current

    Scaffold(floatingActionButton = {
        FABComposition(
            onClick = {
                navigator?.push(item = HomeProductsScreen)
                navigator?.popUntilRoot()
            },
            content = {
                Icon(
                    imageVector = FeatherIcons.Home,
                    contentDescription = "home icon",
                    tint = Color.Gray
                )
            },
            modifier = Modifier.padding(all = 16.dp)
        )
    }, floatingActionButtonPosition = androidx.compose.material3.FabPosition.Start) {
        when {
            uiState.isLoading -> {
                StateLoading(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .padding(all = 8.dp)
                        .fillMaxSize(),
                    color = Color.Black
                )
            }

            uiState.error.isNotEmpty() -> {
                StateError(
                    contentAlignment = Alignment.Center,
                    contents = {
                        Text(
                            text = " ${uiState?.error.toString()}",
                            fontSize = 20.sp,
                            color = Color.Black,
                            fontWeight = FontWeight.Bold
                        )
                    },
                    horizontal = Arrangement.Center,
                    vertical = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxSize()
                )
            }

            else -> {
                uiState?.data?.let {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(all = 8.dp)
                            .verticalScroll(state = rememberScrollState())
                    ) {
                        it?.categories?.forEach { category ->
                            Column(
                                modifier = Modifier
                                    .clickable {
                                        navigator?.push(
                                            item = ContentOfCategoriesScreen(
                                                category = category
                                            )
                                        )
                                    }
                            ) {
                                when (category) {
                                    "tv" -> {
                                        Card(
                                            colors = CardDefaults.cardColors(containerColor = Color.White),
                                            elevation = CardDefaults.elevatedCardElevation(
                                                disabledElevation = 8.dp
                                            )
                                        ) {
                                            Column {
                                                Text(
                                                    modifier = Modifier
                                                        .fillMaxWidth(),
                                                    text = category,
                                                    fontSize = 20.sp,
                                                    color = Color.Black,
                                                    fontWeight = FontWeight.ExtraBold,
                                                    textAlign = TextAlign.Center
                                                )
                                                Image(
                                                    modifier = Modifier
                                                        .size(size = 100.dp)
                                                        .padding(all = 4.dp)
                                                        .align(alignment = Alignment.CenterHorizontally),
                                                    painter = painterResource(resource = Res.drawable.tv),
                                                    contentDescription = "image tv"
                                                )
                                            }
                                        }
                                    }

                                    "audio" -> {
                                        Card(
                                            modifier = Modifier
                                                .padding(top = 8.dp, bottom = 8.dp),
                                            colors = CardDefaults.cardColors(containerColor = Color.White),
                                            elevation = CardDefaults.elevatedCardElevation(
                                                disabledElevation = 8.dp
                                            )
                                        ) {
                                            Column {
                                                Text(
                                                    modifier = Modifier
                                                        .fillMaxWidth(),
                                                    text = category,
                                                    fontSize = 20.sp,
                                                    color = Color.Black,
                                                    fontWeight = FontWeight.ExtraBold,
                                                    textAlign = TextAlign.Center
                                                )
                                                Image(
                                                    modifier = Modifier
                                                        .size(size = 100.dp)
                                                        .padding(all = 4.dp)
                                                        .align(alignment = Alignment.CenterHorizontally),
                                                    painter = painterResource(resource = Res.drawable.audio),
                                                    contentDescription = "image audio"
                                                )
                                            }
                                        }
                                    }

                                    "laptop" -> {
                                        Card(
                                            modifier = Modifier
                                                .padding(top = 8.dp, bottom = 8.dp),
                                            colors = CardDefaults.cardColors(containerColor = Color.White),
                                            elevation = CardDefaults.elevatedCardElevation(
                                                disabledElevation = 8.dp
                                            )
                                        ) {
                                            Column {
                                                Text(
                                                    modifier = Modifier
                                                        .fillMaxWidth(),
                                                    text = category,
                                                    fontSize = 20.sp,
                                                    color = Color.Black,
                                                    fontWeight = FontWeight.ExtraBold,
                                                    textAlign = TextAlign.Center
                                                )
                                                Image(
                                                    modifier = Modifier
                                                        .size(size = 100.dp)
                                                        .padding(all = 4.dp)
                                                        .align(alignment = Alignment.CenterHorizontally),
                                                    painter = painterResource(resource = Res.drawable.laptop),
                                                    contentDescription = "image laptop"
                                                )
                                            }
                                        }
                                    }

                                    "mobile" -> {
                                        Card(
                                            modifier = Modifier
                                                .padding(top = 8.dp, bottom = 8.dp),
                                            colors = CardDefaults.cardColors(containerColor = Color.White),
                                            elevation = CardDefaults.elevatedCardElevation(
                                                disabledElevation = 8.dp
                                            )
                                        ) {
                                            Column {
                                                Text(
                                                    modifier = Modifier
                                                        .fillMaxWidth(),
                                                    text = category,
                                                    fontSize = 20.sp,
                                                    color = Color.Black,
                                                    fontWeight = FontWeight.ExtraBold,
                                                    textAlign = TextAlign.Center
                                                )
                                                Image(
                                                    modifier = Modifier
                                                        .size(size = 100.dp)
                                                        .padding(all = 4.dp)
                                                        .align(alignment = Alignment.CenterHorizontally),
                                                    painter = painterResource(resource = Res.drawable.mobile),
                                                    contentDescription = "image mobile"
                                                )
                                            }
                                        }
                                    }

                                    "gaming" -> {
                                        Card(
                                            modifier = Modifier
                                                .padding(top = 8.dp, bottom = 8.dp),
                                            colors = CardDefaults.cardColors(containerColor = Color.White),
                                            elevation = CardDefaults.elevatedCardElevation(
                                                disabledElevation = 8.dp
                                            )
                                        ) {
                                            Column {
                                                Text(
                                                    modifier = Modifier
                                                        .fillMaxWidth(),
                                                    text = category,
                                                    fontSize = 20.sp,
                                                    color = Color.Black,
                                                    fontWeight = FontWeight.ExtraBold,
                                                    textAlign = TextAlign.Center
                                                )
                                                Image(
                                                    modifier = Modifier
                                                        .size(size = 100.dp)
                                                        .padding(all = 4.dp)
                                                        .align(alignment = Alignment.CenterHorizontally),
                                                    painter = painterResource(resource = Res.drawable.gaming),
                                                    contentDescription = "image gaming"
                                                )
                                            }
                                        }
                                    }

                                    "appliances" -> {
                                        Card(
                                            modifier = Modifier
                                                .padding(top = 8.dp, bottom = 8.dp),
                                            colors = CardDefaults.cardColors(containerColor = Color.White),
                                            elevation = CardDefaults.elevatedCardElevation(
                                                disabledElevation = 8.dp
                                            )
                                        ) {
                                            Column {
                                                Text(
                                                    modifier = Modifier
                                                        .fillMaxWidth(),
                                                    text = category,
                                                    fontSize = 20.sp,
                                                    color = Color.Black,
                                                    fontWeight = FontWeight.ExtraBold,
                                                    textAlign = TextAlign.Center
                                                )
                                                Image(
                                                    modifier = Modifier
                                                        .size(size = 100.dp)
                                                        .padding(all = 4.dp)
                                                        .align(alignment = Alignment.CenterHorizontally),
                                                    painter = painterResource(resource = Res.drawable.appliances),
                                                    contentDescription = "image appliances"
                                                )
                                            }
                                        }
                                    }

                                    else -> {
                                        StateLoading(
                                            contentAlignment = Alignment.Center,
                                            modifier = Modifier
                                                .fillMaxSize()
                                                .padding(all = 8.dp),
                                            color = Color.Black
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
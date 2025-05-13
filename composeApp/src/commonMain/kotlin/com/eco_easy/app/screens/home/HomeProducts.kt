package com.eco_easy.app.screens.home

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
import androidx.compose.material.Card
import androidx.compose.material.FabPosition
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.FilterQuality
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.navigator.LocalNavigator
import com.eco_easy.app.compositions.FABComposition
import com.eco_easy.app.compositions.states.StateData
import com.eco_easy.app.compositions.states.StateError
import com.eco_easy.app.compositions.states.StateLoading
import com.eco_easy.app.screens.category.categories_self.CategoriesScreen
import com.eco_easy.app.screens.details.ProductDetailsScreen
import com.eco_easy.app.view_models.ProductsViewModel
import com.seiko.imageloader.rememberImagePainter
import compose.icons.FeatherIcons
import compose.icons.feathericons.Grid
import ecoeasy.composeapp.generated.resources.Res
import ecoeasy.composeapp.generated.resources.loading

@Composable
fun HomeProducts(
    viewModel: ProductsViewModel
) {

    val uiState by viewModel.uiState.collectAsState()
    val navigator = LocalNavigator.current
    val scope = rememberCoroutineScope()


    Scaffold(floatingActionButton = {
        FABComposition(
            onClick = {
                navigator?.push(item = CategoriesScreen)
            },
            content = {
                Icon(
                    imageVector = FeatherIcons.Grid,
                    contentDescription = "category icon",
                    tint = Color.Gray
                )
            },
            modifier = Modifier.padding(all = 16.dp)
        )
    }, floatingActionButtonPosition = FabPosition.End) {
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
                    StateData(
                        contents = {
                            Column(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(all = 4.dp)
                            ) {
                                Column {
                                    it?.productModels?.forEach { products ->
                                        Card(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .padding(all = 8.dp)
                                                .clickable {
                                                    navigator?.push(
                                                        item = ProductDetailsScreen(
                                                            productModel = products
                                                        )
                                                    )
                                                },
                                            contentColor = Color.White,
                                            elevation = 16.dp
                                        ) {
                                            Column {
                                                val painter = rememberImagePainter(
                                                    url = products.image,
                                                    filterQuality = FilterQuality.Medium,
                                                    placeholderPainter = {
                                                        org.jetbrains.compose.resources.painterResource(
                                                            Res.drawable.loading
                                                        )
                                                    },
                                                    errorPainter = {
                                                        org.jetbrains.compose.resources.painterResource(
                                                            Res.drawable.loading
                                                        )
                                                    }
                                                )
                                                Image(
                                                    modifier = Modifier
                                                        .size(width = 700.dp, height = 400.dp)
                                                        .align(alignment = Alignment.CenterHorizontally),
                                                    painter = painter,
                                                    contentDescription = "product image"
                                                )

                                                Text(
                                                    modifier = Modifier
                                                        .fillMaxWidth(),
                                                    text = products.title,
                                                    fontSize = 17.sp,
                                                    color = Color.Black,
                                                    fontWeight = FontWeight.ExtraBold,
                                                    textAlign = TextAlign.Center
                                                )

                                                Text(
                                                    modifier = Modifier
                                                        .padding(all = 4.dp)
                                                        .align(alignment = Alignment.End),
                                                    text = "${products.price} $",
                                                    fontSize = 15.sp,
                                                    color = Color.Black,
                                                    fontWeight = FontWeight.Bold,
                                                    textAlign = TextAlign.End
                                                )
                                            }
                                        }
                                    }
                                }
                            }
                        },
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(all = 8.dp)
                            .verticalScroll(rememberScrollState()),
                        vertical = Arrangement.Center,
                        horizontal = Alignment.CenterHorizontally
                    )
                }
            }
        }
    }
}
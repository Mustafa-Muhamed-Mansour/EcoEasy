package com.eco_easy.app.screens.category.content_of_categories

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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.FilterQuality
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.navigator.LocalNavigator
import com.eco_easy.app.compositions.states.StateData
import com.eco_easy.app.compositions.states.StateError
import com.eco_easy.app.compositions.states.StateLoading
import com.eco_easy.app.screens.category.categories_self.CategoriesScreen
import com.eco_easy.app.view_models.ContentOfCategoryViewModel
import com.seiko.imageloader.rememberImagePainter
import ecoeasy.composeapp.generated.resources.Res
import ecoeasy.composeapp.generated.resources.loading
import org.jetbrains.compose.resources.painterResource

@Composable
fun ContentOfCategories(
    category: String,
    viewModel: ContentOfCategoryViewModel
) {
    val uiState by viewModel.uiState.collectAsState()
    val navigator = LocalNavigator.current

    LaunchedEffect(Unit) {
        viewModel.fetchContentOfCategory(typeCategory = category)
    }

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
                                .padding(all = 8.dp)
                                .fillMaxSize()
                                .verticalScroll(state = rememberScrollState()),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Column {
                                Image(
                                    modifier = Modifier
                                        .padding(all = 16.dp)
                                        .align(alignment = Alignment.End)
                                        .clickable {
                                            navigator?.push(item = CategoriesScreen)
                                        },
                                    imageVector = Icons.Default.Close,
                                    contentDescription = "close of bottom sheet"
                                )
                                it?.productModels?.forEach { products ->
                                    val painter = rememberImagePainter(
                                        url = products.image,
                                        filterQuality = FilterQuality.Medium,
                                        placeholderPainter = { painterResource(Res.drawable.loading) },
                                        errorPainter = { painterResource(Res.drawable.loading) }
                                    )
                                    Image(
                                        modifier = Modifier
                                            .size(size = 150.dp)
                                            .align(alignment = Alignment.CenterHorizontally),
                                        painter = painter,
                                        contentDescription = "image search of product"
                                    )

                                    Text(
                                        modifier = Modifier.fillMaxWidth(),
                                        text = products.title,
                                        color = Color.Black,
                                        fontSize = 20.sp,
                                        fontWeight = FontWeight.ExtraBold,
                                        textAlign = TextAlign.Center
                                    )

                                    Text(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .align(alignment = Alignment.End),
                                        text = "${products.price} $",
                                        color = Color.Black,
                                        fontSize = 17.sp,
                                        textAlign = TextAlign.End
                                    )

                                    Text(
                                        modifier = Modifier
                                            .fillMaxWidth(),
                                        text = products.description,
                                        color = Color.Black,
                                        fontSize = 15.sp
                                    )
                                }
                            }
                        }
                    }
                )
            }
        }
    }
}
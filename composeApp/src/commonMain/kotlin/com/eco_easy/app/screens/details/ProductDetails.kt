package com.eco_easy.app.screens.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.navigator.LocalNavigator
import com.eco_easy.app.screens.home.HomeProductsScreen
import com.eco_easy.domain.entity.ProductModel
import com.seiko.imageloader.rememberImagePainter
import compose.icons.FeatherIcons
import compose.icons.feathericons.ArrowLeftCircle
import ecoeasy.composeapp.generated.resources.Res
import ecoeasy.composeapp.generated.resources.loading
import org.jetbrains.compose.resources.painterResource

@Composable
fun ProductDetails(
    productModel: ProductModel
) {
    val navigator = LocalNavigator.current


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = 8.dp)
            .verticalScroll(state = rememberScrollState())
    ) {

        Column {
            Image(
                modifier = Modifier
                    .padding(all = 4.dp)
                    .align(alignment = Alignment.Start)
                    .clickable {
                        navigator?.push(item = HomeProductsScreen)
                        navigator?.popUntilRoot()
                    },
                imageVector = FeatherIcons.ArrowLeftCircle,
                contentDescription = "arrow back",
                colorFilter = ColorFilter.tint(color = Color.Gray)
            )

            val painter = rememberImagePainter(
                url = productModel.image,
                placeholderPainter = {
                    painterResource(resource = Res.drawable.loading)
                },
                errorPainter = {
                    painterResource(resource = Res.drawable.loading)
                }
            )
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(height = 300.dp)
                    .align(alignment = Alignment.CenterHorizontally),
                painter = painter,
                contentDescription = "product image",
                contentScale = ContentScale.Crop
            )

            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = productModel.title,
                fontSize = 17.sp,
                color = Color.Black,
                fontWeight = FontWeight.ExtraBold,
                textAlign = TextAlign.Center
            )

            Text(
                modifier = Modifier
                    .align(alignment = Alignment.End),
                text = "${productModel.price} $",
                color = Color.Black,
                fontSize = 15.sp,
                textAlign = TextAlign.End
            )

            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = productModel.description,
                fontSize = 15.sp,
                color = Color.Black
            )
        }
    }
}
package com.eco_easy.app.screens.details

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import com.eco_easy.app.entity.ProductModel

class ProductDetailsScreen(
    private val productModel: ProductModel
): Screen {
    @Composable
    override fun Content() {
        ProductDetails(productModel = productModel)
    }
}
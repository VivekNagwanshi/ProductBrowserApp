package com.example.productbrowserapp

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.productbrowserapp.data.remote.ProductApiImpl
import com.example.productbrowserapp.data.repository.ProductRepositoryImpl
import com.example.productbrowserapp.domain.model.Product
import com.example.productbrowserapp.domain.usecase.GetProductsUseCase
import com.example.productbrowserapp.domain.usecase.SearchProductsUseCase
import com.example.productbrowserapp.network.createHttpClient
import com.example.productbrowserapp.presentation.ui.ProductDetailScreen
import com.example.productbrowserapp.presentation.ui.ProductListScreen
import com.example.productbrowserapp.presentation.viewmodel.ProductViewModel
import org.jetbrains.compose.resources.painterResource
import productbrowserapp.composeapp.generated.resources.Res
import productbrowserapp.composeapp.generated.resources.ic_back
import productbrowserapp.composeapp.generated.resources.ic_search


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App() {

    MaterialTheme {

        // ---------- Dependencies ----------
        val httpClient = remember { createHttpClient() }
        val api = remember { ProductApiImpl(httpClient) }
        val repository = remember { ProductRepositoryImpl(api) }
        val getProductsUseCase = remember { GetProductsUseCase(repository) }
        val searchProductsUseCase = remember { SearchProductsUseCase(repository) }

        val viewModel = remember {
            ProductViewModel(
                getProductsUseCase,
                searchProductsUseCase
            )
        }

        val products by viewModel.uiState.collectAsState()

        var selectedProduct by remember { mutableStateOf<Product?>(null) }

        var isSearchActive by remember { mutableStateOf(false) }
        var searchText by remember { mutableStateOf("") }

        Scaffold(

            topBar = {

                TopAppBar(
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                        titleContentColor = MaterialTheme.colorScheme.primary,
                    ),

                    title = {

                        if (isSearchActive) {

                            TextField(
                                value = searchText,
                                onValueChange = {
                                    searchText = it
                                    viewModel.search(it)
                                },
                                placeholder = { Text("Search products") },
                                singleLine = true
                            )

                        } else {

                            Text(
                                if (selectedProduct == null)
                                    "Products"
                                else
                                    "Product Detail"
                            )
                        }
                    },

                    navigationIcon = {

                        if (selectedProduct != null) {

                            IconButton(onClick = {

                                selectedProduct = null
                                isSearchActive = false

                            }) {
                                Icon(
                                    painter = painterResource(Res.drawable.ic_back),
                                    contentDescription = "back",
                                    modifier = Modifier.size(24.dp)
                                )
                            }
                        }
                    },

                    actions = {

                        if (selectedProduct == null) {

                            IconButton(onClick = { isSearchActive = !isSearchActive }) {
                                Icon(
                                    painter = painterResource(Res.drawable.ic_search),
                                    contentDescription = "Search",
                                    modifier = Modifier.size(24.dp)
                                )
                            }

                        }
                    }
                )
            }

        ) { padding ->

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
            ) {

                if (selectedProduct == null) {

                    ProductListScreen(
                        products = products,
                        onProductClick = {
                            selectedProduct = it
                        }
                    )

                } else {

                    ProductDetailScreen(
                        product = selectedProduct!!
                    )
                }
            }
        }
    }
}
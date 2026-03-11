package com.example.productbrowserapp.presentation.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.productbrowserapp.domain.model.Product
import org.jetbrains.compose.resources.painterResource
import productbrowserapp.composeapp.generated.resources.Res
import productbrowserapp.composeapp.generated.resources.star


@Composable
fun ProductDetailScreen(
    product: Product
) {

    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {

        item {

            Text(
                text = "Product Images",
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.titleSmall
            )
        }

        item {

            LazyRow(
                contentPadding = PaddingValues(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                items(product.images) { image ->
                    AsyncImage(
                        model = image,
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(200.dp)
                            .clip(RoundedCornerShape(12.dp))
                    )
                }
            }
        }

        item {

            Column(
                modifier = Modifier.padding(16.dp)
            ) {

                Text(
                    text = product.title,
                    style = MaterialTheme.typography.titleMedium
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "₹${product.price}",
                    style = MaterialTheme.typography.titleSmall,
                    color = Color(0xFF2E7D32)
                )

                Spacer(modifier = Modifier.height(8.dp))

                Row {

                    Icon(
                        painter = painterResource(Res.drawable.star),
                        contentDescription = "back",
                        modifier = Modifier.size(24.dp)
                    )

                    Spacer(modifier = Modifier.width(4.dp))

                    Text(product.rating.toString())
                }

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Description",
                    style = MaterialTheme.typography.titleSmall
                )

                Spacer(modifier = Modifier.height(6.dp))

                Text(product.description)
            }
        }


    }
}

package com.example.productbrowserapp

import com.example.productbrowserapp.domain.repository.FakeProductRepository
import com.example.productbrowserapp.domain.usecase.GetProductsUseCase
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class ComposeAppCommonTest {

    @Test
    fun example() {
        assertEquals(3, 1 + 2)
    }
    @Test
    fun testGetProducts() = runTest {

        val fakeRepo = FakeProductRepository()

        val useCase = GetProductsUseCase(fakeRepo)

        val result = useCase()

        assertTrue(result.isNotEmpty())
    }
}
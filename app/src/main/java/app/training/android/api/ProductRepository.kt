package app.training.android.api

import javax.inject.Inject

class ProductRepository @Inject constructor(
    private val apiService: FakeStoreApi
) {
    suspend fun getProducts(): List<ProductResponse>{
        return apiService.getProducts()
    }

    suspend fun getProduct(id: Int): ProductResponse{
        return apiService.getProduct(id)
    }

}
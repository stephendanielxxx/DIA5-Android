package app.training.android.api

class ProductRepository(private val apiService: FakeStoreApi) {

    suspend fun getProducts(): List<ProductResponse>{
        return apiService.getProducts()
    }

    suspend fun getProduct(id: Int): ProductResponse{
        return apiService.getProduct(id)
    }

}
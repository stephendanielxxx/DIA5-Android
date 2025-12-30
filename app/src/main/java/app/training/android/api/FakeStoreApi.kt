package app.training.android.api

import retrofit2.http.GET
import retrofit2.http.Path

interface FakeStoreApi {
    // contain all api endpoint that the app will use
    @GET("products")
    suspend fun getProducts(): List<ProductResponse>

    @GET("products/{id}")
    suspend fun getProduct(@Path("id") id: Int): ProductResponse
}
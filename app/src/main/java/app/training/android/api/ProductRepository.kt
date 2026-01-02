package app.training.android.api

import app.training.android.utils.ApiException
import javax.inject.Inject

class ProductRepository @Inject constructor(
    private val apiService: FakeStoreApi
) {
    suspend fun getProducts(): List<ProductResponse>{
        return apiService.getProducts()
    }

    suspend fun getProduct(id: Int): ProductResponse{
        val product = apiService.getProduct(id)
        if(product.isSuccessful){
            val body = product.body()
            if(body != null){
                return body
            }else{
                throw ApiException()
            }
        }else{
            throw ApiException()
        }
    }

}
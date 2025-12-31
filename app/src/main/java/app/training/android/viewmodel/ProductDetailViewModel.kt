package app.training.android.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.training.android.api.ProductRepository
import app.training.android.api.ProductResponse
import app.training.android.api.UserRepository
import app.training.android.entity.Product
import app.training.android.room.AppDatabase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductDetailViewModel @Inject constructor(
    private val productRepository: ProductRepository,
    private val userRepository: UserRepository,
    private val appDatabase: AppDatabase
): ViewModel() {

    private val productMutableLiveData = MutableLiveData<ProductResponse>()
    val productLiveData: LiveData<ProductResponse> = productMutableLiveData

    fun getProductDetail(id: Int){
        viewModelScope.launch {
            val product = productRepository.getProduct(id)
            productMutableLiveData.value = product
        }
    }

    fun saveProduct(productResponse: ProductResponse){
        viewModelScope.launch {

            val checkProduct = appDatabase.productDao().getProduct(productResponse.id)

            if(checkProduct != null){
                //sudah exist
                Log.e("ProductDetailViewModel", "Product exist")
            }else{
                val product = Product(
                    id = productResponse.id,
                    title = productResponse.title,
                    price = productResponse.price,
                    category = productResponse.category,
                    image = productResponse.image,
                    rate = productResponse.rating.rate
                )
                appDatabase.productDao().insertProduct(product)
            }
        }
    }

    fun deleteProduct(productResponse: ProductResponse){
        viewModelScope.launch {
            appDatabase.productDao().deleteProduct(productResponse.id)
        }
    }
}
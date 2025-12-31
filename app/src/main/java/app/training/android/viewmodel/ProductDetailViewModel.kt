package app.training.android.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.training.android.api.ProductRepository
import app.training.android.api.ProductResponse
import app.training.android.api.RetrofitService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductDetailViewModel @Inject constructor(
    private val productRepository: ProductRepository
): ViewModel() {

    private val productMutableLiveData = MutableLiveData<ProductResponse>()
    val productLiveData: LiveData<ProductResponse> = productMutableLiveData

    fun getProductDetail(id: Int){
        viewModelScope.launch {
            val product = productRepository.getProduct(id)
            productMutableLiveData.value = product
        }
    }
}
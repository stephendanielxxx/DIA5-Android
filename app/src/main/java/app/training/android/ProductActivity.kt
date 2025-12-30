package app.training.android

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import app.training.android.databinding.ActivityProductBinding
import app.training.android.viewmodel.ProductDetailViewModel
import com.bumptech.glide.Glide

class ProductActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProductBinding
    private val viewModel: ProductDetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityProductBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val productId = intent.getIntExtra("productId", 0)
        viewModel.getProductDetail(productId)
        setObserver()
    }

    private fun setObserver(){
        viewModel.productLiveData.observe(this){
            it.let { product ->
                binding.tvTitle.text = product.title
                binding.tvPrice.text = "Price $${product.price}"
                binding.tvCategory.text = "Category: ${product.category}"
                binding.tvRating.text = "Rating: ${product.rating.rate.toString()}"
                binding.tvDesc.text = product.description
                Glide.with(this)
                    .load(product.image)
                    .into(binding.ivProduct)
            }
        }
    }
}
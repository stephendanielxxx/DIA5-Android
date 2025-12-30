package app.training.android.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import app.training.android.api.ProductResponse
import app.training.android.databinding.ItemProductBinding
import com.bumptech.glide.Glide

class ProductAdapter(
    private val products: ArrayList<ProductResponse>,
    private val listener: ProductListener
): RecyclerView.Adapter<ProductAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val binding = ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        val product = products[position]
        with(holder.binding){
            tvTitle.text = product.title
            tvPrice.text = "$${product.price}"
            tvCategory.text = product.category
            tvRating.text = product.rating.rate.toString()
            tvDesc.text = product.description
            Glide.with(root.context)
                .load(product.image)
                .into(ivProduct)
        }
    }

    override fun getItemCount(): Int {
        return products.size
    }

    inner class ViewHolder(val binding: ItemProductBinding): RecyclerView.ViewHolder(binding.root){
        init {
            binding.root.setOnClickListener {
                listener.onProductSelected(products[adapterPosition])
            }
        }
    }

    interface ProductListener{
        fun onProductSelected(product: ProductResponse)
    }
}
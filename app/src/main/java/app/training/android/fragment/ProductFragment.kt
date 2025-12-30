package app.training.android.fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import app.training.android.ProductActivity
import app.training.android.adapter.ProductAdapter
import app.training.android.api.ProductResponse
import app.training.android.databinding.FragmentProductBinding
import app.training.android.viewmodel.ProductViewModel


class ProductFragment : Fragment(), ProductAdapter.ProductListener {
    private lateinit var binding: FragmentProductBinding
    private val viewModel: ProductViewModel by viewModels()
    private lateinit var adapter: ProductAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentProductBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvProduct.layoutManager = LinearLayoutManager(requireContext())

        viewModel.getProducts()
        setObserver()
    }

    private fun setObserver(){
        viewModel.productLiveData.observe(viewLifecycleOwner){
            it.let { products ->
                adapter = ProductAdapter(products as ArrayList<ProductResponse>, this)
                binding.rvProduct.adapter = adapter
            }
        }
    }

    override fun onProductSelected(product: ProductResponse) {
        //start detail product activity
        val productIntent = Intent(requireContext(), ProductActivity::class.java)
        productIntent.putExtra("productId", product.id)
        startActivity(productIntent)
    }
}

























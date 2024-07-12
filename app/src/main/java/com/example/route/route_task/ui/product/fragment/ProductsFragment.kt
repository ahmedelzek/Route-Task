package com.example.route.route_task.ui.product.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.route.domain.models.Product
import com.example.route.route_task.R
import com.example.route.route_task.base.showDialog
import com.example.route.route_task.databinding.FragmentProductsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductsFragment : Fragment() {
    private var adapter: ProductAdapter? = null
    private var _binding: FragmentProductsBinding? = null
    private val binding get() = _binding!!
    private val productFragmentViewModel: ProductsViewModel by viewModels<ProductsViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_products, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        getProducts()
        observeLiveData()
    }

    private fun initRecyclerView() {
        adapter = ProductAdapter(listOf())
        binding.content.productsRv.adapter = adapter
    }

    private fun getProducts() {
        productFragmentViewModel.getAllProducts()
    }

    private fun observeLiveData() {
        productFragmentViewModel.loadingLiveData.observe(viewLifecycleOwner) {
            if (it) {
                binding.content.productsShimmerViewContainer.startShimmer()
            } else {
                binding.content.productsShimmerViewContainer.stopShimmer()
            }
        }
        productFragmentViewModel.errorMessage.observe(viewLifecycleOwner) {
            showDialog(
                title = it.title,
                message = it.message,
            )
        }
        productFragmentViewModel.prodcutListLiveData.observe(viewLifecycleOwner) {
            bindProduct(it)
        }
    }

    private fun bindProduct(list: List<Product>) {
        adapter?.updateList(list)
        binding.content.productsRv.adapter = adapter
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
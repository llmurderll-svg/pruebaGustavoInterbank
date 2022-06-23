package com.example.testgustavointerbank.ui.Menu.Details

import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.domain.Entity.ProductEntity
import com.example.testgustavointerbank.R
import com.example.testgustavointerbank.ui.base.BaseFragment
import com.example.testgustavointerbank.databinding.FragmentDetailBinding
import com.example.testgustavointerbank.models.ProductModel
import com.example.testgustavointerbank.ui.adapters.ProductAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailFragment : BaseFragment<FragmentDetailBinding>() {

    private val mViewModel by viewModel<DetailsViewModel>()
    private lateinit var mLayoutManager : LinearLayoutManager
    private lateinit var mAdapter : ProductAdapter

    override fun getLayoutRes(): Int {
        return R.id.navigation_detail
    }

    override fun initView() {
        initRecycler()
        dataBinding.apply {
            swipeRefreshLayout.setOnRefreshListener {
                mViewModel.getUploadProducts()
                swipeRefreshLayout.isRefreshing = false
            }
        }
    }

    override fun onListener() {
        super.onListener()
        mViewModel.products.observe(viewLifecycleOwner){ products ->
            mAdapter.setData(products)
        }
    }

    private fun initRecycler(){
        mLayoutManager = LinearLayoutManager(requireContext())
        mAdapter = ProductAdapter(::onProductClick)
        dataBinding.recyclerViewCars.apply {
            layoutManager = mLayoutManager
            itemAnimator = DefaultItemAnimator()
            addItemDecoration(
                DividerItemDecoration(
                    requireContext(),
                    LinearLayoutManager.VERTICAL
                )
            )
            adapter = mAdapter
        }
    }

    private fun onProductClick(product: ProductModel){
        val action = DetailFragmentDirections.gotoOperations(product)
        findNavController().navigate(action)
    }

}
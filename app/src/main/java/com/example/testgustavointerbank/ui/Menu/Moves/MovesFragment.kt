package com.example.testgustavointerbank.ui.Menu.Moves

import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testgustavointerbank.R
import com.example.testgustavointerbank.ui.base.BaseFragment
import com.example.testgustavointerbank.databinding.FragmentMovesBinding
import com.example.testgustavointerbank.ui.adapters.MoveAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class MovesFragment : BaseFragment<FragmentMovesBinding>() {

    private val args : MovesFragmentArgs by navArgs()
    private val mViewModel by viewModel<MovesViewModel>()
    private lateinit var mLayoutManager : LinearLayoutManager
    private lateinit var mAdapter : MoveAdapter

    override fun getLayoutRes(): Int {
        return R.id.navigation_moves
    }

    override fun initView() {
        initProduct()
        initRecycler()
    }

    override fun onListener() {
        super.onListener()
        mViewModel.moves.observe(viewLifecycleOwner){ moves ->
            mAdapter.setData(moves)
        }
        mViewModel.onLoading.observe(viewLifecycleOwner){ loading ->
            if(loading){
                showProgress("Cargando Movimientos...")
            }
            else{
                hideProgress()
            }
        }
    }

    private fun initProduct() {
        dataBinding.cuentaType.text = args.product.typeAccount
        dataBinding.cuentaMount.text = args.product.mountAccount
        dataBinding.cuentaNumber.text = args.product.numberAccount
    }

    private fun initRecycler(){
        mLayoutManager = LinearLayoutManager(requireContext())
        mAdapter = MoveAdapter()
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

}
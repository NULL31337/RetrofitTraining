package com.null31337.retrofittraining.screens.money

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.null31337.retrofittraining.R

class MoneyFragment : Fragment() {

    lateinit var recyclerView: RecyclerView
    lateinit var adapter: MoneyAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewModel = ViewModelProvider(this)[MoneyViewModel::class.java]
        val view = inflater.inflate(R.layout.fragment_money, container, false)

        recyclerView = view.findViewById(R.id.moneyRecyclerView)
        adapter = MoneyAdapter()
        recyclerView.adapter = adapter
        viewModel.getMoney()
        viewModel.moneyList.observe(viewLifecycleOwner) { list ->
            list.body()?.let { adapter.setData(it) }
        }

        return view
    }
}
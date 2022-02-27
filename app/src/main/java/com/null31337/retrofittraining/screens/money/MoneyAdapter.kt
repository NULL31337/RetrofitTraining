package com.null31337.retrofittraining.screens.money

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.null31337.retrofittraining.R
import com.null31337.retrofittraining.model.money.Money
import com.null31337.retrofittraining.model.money.MoneyItem

class MoneyAdapter : RecyclerView.Adapter<MoneyAdapter.MoneyViewHolder>() {

    private var listMoney = emptyList<MoneyItem>()

    class MoneyViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MoneyAdapter.MoneyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_money, parent, false)
        return MoneyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MoneyViewHolder, position: Int) {
        holder.itemView.findViewById<TextView>(R.id.money_name_value).text = listMoney[position].name
        holder.itemView.findViewById<TextView>(R.id.money_previous_value).text = listMoney[position].previous.toString()
        holder.itemView.findViewById<TextView>(R.id.money_current_value).text = listMoney[position].current.toString()
    }

    override fun getItemCount(): Int {
        return listMoney.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(list: Money) {
        listMoney = list.toList()
        notifyDataSetChanged()
    }

}
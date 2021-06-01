package com.indovision.belanjaseller.ui.dashboard.shop

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.indovision.belanjaseller.databinding.FragmentShopBinding
import com.indovision.belanjaseller.databinding.ItemActionListBinding
import com.indovision.belanjaseller.databinding.ItemSaleListBinding

class ShopFragment : Fragment() {
    private var _binding: FragmentShopBinding? = null
    private val binding get() = _binding as FragmentShopBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentShopBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}

private data class Sales(
    val quantity: Int,
    val price: Int,
    val title: String
) {
    var isShowAction = false
}

private class SalesAdapter(private val listItem: List<Sales>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    inner class SalesViewHolder(private val binding: ItemSaleListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(sales: Sales) {
            with(binding) {
                saleQuantity.text = StringBuilder("Quantity:").append(sales.quantity)
                salePrice.text = StringBuilder("Price:").append(sales.price)
                saleTitle.text = sales.title
                saleTotal.text = StringBuilder("Total:").append(sales.quantity * sales.price)
            }
        }
    }

    inner class ActionViewHolder(private val binding: ItemActionListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(sales: Sales) {
            with(binding) {
                layoutDelete.cvAction.setOnClickListener {
                    Toast.makeText(it.context, "DELETE - ${sales.title}", Toast.LENGTH_SHORT).show()
                }
                layoutEdit.cvAction.setOnClickListener {
                    Toast.makeText(it.context, "EDIT - ${sales.title}", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    fun showAction(position: Int) {
        listItem.forEach { sales ->
            sales.isShowAction = false
        }
        listItem[position].isShowAction = true
        notifyDataSetChanged()
    }

    fun isActionShown(): Boolean {
        listItem.forEach { sales ->
            if (sales.isShowAction) return true
        }
        return false
    }

    fun getActionShownIndex(): Int? {
        listItem.forEachIndexed { index, sales ->
            if (sales.isShowAction) return index
        }
        return null
    }

    fun closeAction() {
        listItem.forEach {
            it.isShowAction = false
        }
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int): Int =
        if (listItem[position].isShowAction) SHOW_ACTION else HIDE_ACTION

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        if (viewType == HIDE_ACTION) SalesViewHolder(
            ItemSaleListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        ) else ActionViewHolder(
            ItemActionListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is SalesViewHolder) holder.bind(listItem[position])
        if (holder is ActionViewHolder) holder.bind(listItem[position])
    }

    override fun getItemCount(): Int = listItem.size

    companion object {
        private const val SHOW_ACTION = 1
        private const val HIDE_ACTION = 2
    }
}

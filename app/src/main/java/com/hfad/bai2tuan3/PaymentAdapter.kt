package com.hfad.bai2tuan3

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hfad.bai2tuan3.databinding.ItemPaymentOptionBinding

class PaymentAdapter(
    private val items: List<PaymentMethod>,
    private val onPick: (PaymentMethod) -> Unit
) : RecyclerView.Adapter<PaymentAdapter.VH>() {

    private var selectedId: String? = null

    fun setSelected(method: PaymentMethod?) {
        selectedId = method?.id
        notifyDataSetChanged()
    }

    inner class VH(val binding: ItemPaymentOptionBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val binding = ItemPaymentOptionBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return VH(binding)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: VH, position: Int) {
        val method = items[position]
        val b = holder.binding

        b.tvName.text = method.displayName
        b.imgLogoSmall.setImageResource(method.smallIconRes)

        val isSelected = (method.id == selectedId)
        b.rbPick.isChecked = isSelected

        // Highlight giống hình: selected có viền xanh
        b.cardRoot.strokeWidth = if (isSelected) 3 else 1
        b.cardRoot.strokeColor = if (isSelected) 0xFF2F6DE1.toInt() else 0x00000000

        b.root.setOnClickListener { onPick(method) }
    }
}

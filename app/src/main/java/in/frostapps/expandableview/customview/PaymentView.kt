package `in`.frostapps.expandableview.views

import `in`.frostapps.expandableview.customview.CustomStackItem
import `in`.frostapps.expandableview.databinding.PaymentLayoutBinding
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout

class PaymentView(context: Context, attributeSet: AttributeSet) :
    LinearLayout(context, attributeSet), CustomStackItem {

    private var binding: PaymentLayoutBinding
    var expanded = true

    init {
        binding = PaymentLayoutBinding.inflate(LayoutInflater.from(context), this, false)
        addView(binding.root)
        collapse()
    }

    override fun collapse() {
        binding.tvPay.visibility = View.VISIBLE
        binding.tvAmount.visibility = View.GONE
        binding.tvTotal.visibility = View.GONE
        binding.tvDesc.visibility = View.GONE
        binding.paymentSpace.visibility = View.VISIBLE
        expanded = false
    }

    override fun expand() {
        binding.tvPay.visibility = View.GONE
        binding.tvAmount.visibility = View.VISIBLE
        binding.tvTotal.visibility = View.VISIBLE
        binding.tvDesc.visibility = View.VISIBLE
        binding.paymentSpace.visibility = View.GONE
        expanded = true
    }
}
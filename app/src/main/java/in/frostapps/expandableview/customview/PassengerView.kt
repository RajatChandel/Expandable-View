package `in`.frostapps.expandableview.views

import `in`.frostapps.expandableview.customview.CustomStackItem
import `in`.frostapps.expandableview.databinding.PassangerSelectLayoutBinding
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout

class PassengerView(context: Context, attributeSet: AttributeSet) :
    LinearLayout(context, attributeSet), CustomStackItem {

    private var binding: PassangerSelectLayoutBinding
    var expanded = true

    init {
        binding = PassangerSelectLayoutBinding.inflate(LayoutInflater.from(context), this, false)
        addView(binding.root)
        binding.numPicker.minValue = 1
        binding.numPicker.maxValue = 10

        binding.numPicker.setOnValueChangedListener { picker, oldVal, newVal ->
            if (newVal == 1) {
                binding.headingCollapsed.text = "$newVal Adult"
                binding.passengerNumber.text = "$newVal Adult"
            } else {
                binding.headingCollapsed.text = "$newVal Adults"
                binding.passengerNumber.text = "$newVal Adults"
            }
        }

        collapse()
    }

    override fun collapse() {
        binding.headingPassenger.visibility = View.GONE
        binding.headingCollapsed.visibility = View.VISIBLE
        binding.numPicker.visibility = View.GONE
        binding.space.visibility = View.VISIBLE
        binding.subHeading.visibility = View.GONE
        binding.passengerNumber.visibility = View.GONE
        expanded = false
    }

    override fun expand() {
        binding.headingPassenger.visibility = View.VISIBLE
        binding.headingCollapsed.visibility = View.GONE
        binding.numPicker.visibility = View.VISIBLE
        binding.space.visibility = View.GONE
        binding.subHeading.visibility = View.VISIBLE
        binding.passengerNumber.visibility = View.VISIBLE
        expanded = true
    }

}
package `in`.frostapps.expandableview.views

import `in`.frostapps.expandableview.databinding.CustomStackViewBinding
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import androidx.transition.Slide
import androidx.transition.TransitionManager

class CustomStackView(context: Context, attributeSet: AttributeSet) :
    LinearLayout(context, attributeSet) {

    private var binding: CustomStackViewBinding

    init {
        binding = CustomStackViewBinding.inflate(LayoutInflater.from(context), this, false)
        addView(binding.root)
        binding.dateSelectView.setOnClickListener {
            if (!binding.dateSelectView.expanded) {
                binding.dateSelectView.expand()
                binding.passengerView.collapse()
                binding.paymentView.collapse()
                showTransition(binding.paymentView)
                binding.paymentView.visibility = View.GONE
            }
        }

        binding.passengerView.setOnClickListener {
            if (!binding.passengerView.expanded) {
                binding.passengerView.expand()
                binding.dateSelectView.collapse()
                binding.paymentView.collapse()
                showTransition(binding.paymentView)
                binding.paymentView.visibility = View.VISIBLE
            }
        }

        binding.paymentView.setOnClickListener {
            if (!binding.paymentView.expanded) {
                binding.paymentView.expand()
                binding.passengerView.collapse()
                binding.dateSelectView.collapse()
            }
        }
    }

    private fun showTransition(view: View) {
        val transition = Slide()
        transition.duration = 200
        transition.addTarget(view)

        TransitionManager.beginDelayedTransition(this, transition)
    }

    fun setSourceAndDestination(city: String, state: String, cityDest: String, stateDest: String) {
        binding.dateSelectView.setTextFields(city, state, cityDest, stateDest)
    }

}
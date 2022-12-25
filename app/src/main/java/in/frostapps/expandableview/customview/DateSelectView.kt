package `in`.frostapps.expandableview.customview

import `in`.frostapps.expandableview.R
import `in`.frostapps.expandableview.databinding.DateSelectLayoutBinding
import android.content.Context
import android.os.Build
import android.text.Html
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import java.text.SimpleDateFormat
import java.util.*

class DateSelectView(context: Context, attributeSet: AttributeSet) : LinearLayout(context, attributeSet), CustomStackItem {

    private lateinit var binding: DateSelectLayoutBinding
    var expanded = true
    private val sdf = SimpleDateFormat("dd MMM, yyyy", Locale.UK)

    init {
        binding = DateSelectLayoutBinding.inflate(LayoutInflater.from(context), this, false)
        addView(binding.root)

        binding.calDateSelect.setOnDateChangeListener { view, year, month, dayOfMonth ->
            val calendar = Calendar.getInstance()
            calendar.set(year, month, dayOfMonth)

            binding.headingDate.text = sdf.format(calendar.time)
        }
    }

    override fun collapse() {
        binding.space.visibility = View.VISIBLE
        binding.headingDate.visibility = View.VISIBLE
        binding.llFrom.visibility = View.GONE
        binding.llDest.visibility = View.GONE
        binding.line.visibility = View.INVISIBLE
        binding.calDateSelect.visibility = View.GONE
        binding.heading.visibility = View.GONE
        expanded = false
    }

    override fun expand() {
        binding.space.visibility = View.GONE
        binding.headingDate.visibility = View.GONE
        binding.llFrom.visibility = View.VISIBLE
        binding.llDest.visibility = View.VISIBLE
        binding.line.visibility = View.VISIBLE
        binding.calDateSelect.visibility = View.VISIBLE
        binding.heading.visibility = View.VISIBLE
        expanded = true
    }

     fun setTextFields(city: String, state: String, cityDest: String, stateDest: String) {
        val redColor = ContextCompat.getColor(context, R.color.radical_red)
        val mintColor = ContextCompat.getColor(context, R.color.mint_cream)
        val textFrom = "<font color=$mintColor>$city, </font> <font color=$redColor>$state</font>"
        val textDest = "<font color=$mintColor>$cityDest, </font> <font color=$redColor>$stateDest</font>"
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            binding.tvFrom.text = Html.fromHtml(textFrom, Html.FROM_HTML_MODE_LEGACY)
            binding.tvDest.text = Html.fromHtml(textDest, Html.FROM_HTML_MODE_LEGACY)
        } else {
            binding.tvFrom.text = Html.fromHtml(textFrom)
            binding.tvDest.text = Html.fromHtml(textDest)
        }
    }

}
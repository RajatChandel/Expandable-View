package `in`.frostapps.expandableview.activities

import `in`.frostapps.expandableview.model.Trip
import `in`.frostapps.expandableview.databinding.ActivityTripDetailsBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class TripDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTripDetailsBinding

    companion object {
        const val TRIP_BUNDLE_KEY = "trip-object-bundle"
        const val TRIP_OBJECT_KEY = "trip-object"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTripDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbarDetails)

        if (supportActionBar != null) {
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }

        val bundle = intent.getBundleExtra(TRIP_BUNDLE_KEY)
        val trip = bundle?.getParcelable<Trip>(TRIP_OBJECT_KEY)

        binding.customStackView.setSourceAndDestination(
            trip!!.fromCity,
            trip.fromState,
            trip.toCity,
            trip.toState
        )

    }


}
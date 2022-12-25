package `in`.frostapps.expandableview.adapter

import `in`.frostapps.expandableview.Trip
import `in`.frostapps.expandableview.activities.TripDetailsActivity
import `in`.frostapps.expandableview.databinding.TripItemLayoutBinding
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class TripAdapter(private val tripList: ArrayList<Trip>, private val context: Context) : RecyclerView.Adapter<TripAdapter.TripViewHolder>() {

   inner class TripViewHolder(binding: TripItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        var tvPlace = binding.tvPlace
        var ivPlace = binding.ivImage
        var btnPrice = binding.btnPrice
        var tvState = binding.tvState
        var root  = binding.root
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TripViewHolder {
        return TripViewHolder(
            TripItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: TripViewHolder, position: Int) {
        val trip = tripList[position]
        holder.tvPlace.text = trip.toCity
        holder.btnPrice.text = "${trip.price} BTC"
        holder.tvState.text = trip.toState

        Glide.with(context).load(ContextCompat.getDrawable(context, trip.imageId)).into(holder.ivPlace)
        holder.ivPlace.setImageResource(trip.imageId)

        holder.root.setOnClickListener {
            val intent = Intent(context, TripDetailsActivity::class.java)
            val bundle = Bundle()
            bundle.putParcelable(TripDetailsActivity.TRIP_OBJECT_KEY, trip)
            intent.putExtra(TripDetailsActivity.TRIP_BUNDLE_KEY, bundle)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return tripList.size
    }
}
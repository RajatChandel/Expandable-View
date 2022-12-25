package `in`.frostapps.expandableview.activities


import `in`.frostapps.expandableview.R
import `in`.frostapps.expandableview.Trip
import `in`.frostapps.expandableview.adapter.TripAdapter
import `in`.frostapps.expandableview.databinding.ActivityMainBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbarMain)
        binding.toolbarMain.title = "Discover"

        val tripKullu = Trip("Dispur", "Assam", "Manali", "Himachal", R.drawable.image_1, 0.02)
        val tripGoa = Trip("Dispur", "Assam", "Gokarna", "Kerala", R.drawable.image_2, 0.05)

        val list = arrayListOf<Trip>(tripKullu, tripGoa)

        val adapter = TripAdapter(list, this)
        binding.recyclerView.layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.setHasFixedSize(true)
    }
}
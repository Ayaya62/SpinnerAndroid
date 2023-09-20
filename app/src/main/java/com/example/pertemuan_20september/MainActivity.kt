package com.example.pertemuan_20september

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewParent
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.pertemuan_20september.databinding.ActivityMainBinding
import java.text.FieldPosition

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val provinsi = arrayOf(
            "Jawa Timur",
            "Jawa Tengah",
            "Jawa Barat",
            "DKI Jakarta",
            "DIY"
        )

        with(binding){
            val adapterProvinsi = ArrayAdapter<String>(this@MainActivity,
            android.R.layout.simple_spinner_item, provinsi)
            spinnerProvinsi.adapter = adapterProvinsi

            val countries = resources.getStringArray(R.array.countries)
            val adapterCountries = ArrayAdapter<String>(this@MainActivity,
                android.R.layout.simple_spinner_item, countries)
            spinnerCountries.adapter = adapterCountries

            spinnerCountries.onItemSelectedListener =
                object : AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(
                        parent: AdapterView<*>,
                        view: View, position: Int, id: Long
                    ){
                        Toast.makeText(
                            this@MainActivity,
                            countries[position], Toast.LENGTH_SHORT
                        ).show()
                    }

                    override fun onNothingSelected(p0: AdapterView<*>?) {
                    }
                }
        }
    }
}
package com.example.pertemuan_20september

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewParent
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.DatePicker
import android.widget.TimePicker
import android.widget.Toast
import com.example.pertemuan_20september.databinding.ActivityMainBinding
import java.text.FieldPosition

class MainActivity : AppCompatActivity(),
    DatePickerDialog.OnDateSetListener,
    TimePickerDialog.OnTimeSetListener {

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

            datePicker.init(
                datePicker.year,
                datePicker.month,
                datePicker.dayOfMonth
            ){ _, year, month, dayOfMonth ->
                val selecteddate = "$dayOfMonth/${month+1}/$year"
                Toast.makeText(this@MainActivity, selecteddate, Toast.LENGTH_SHORT).show()
            }

            timePickerView.setOnTimeChangedListener{_, hourOfDay, minute ->
                val selectedTime = "$hourOfDay:$minute"
                Toast.makeText(
                    this@MainActivity, selectedTime, Toast.LENGTH_SHORT
                ).show()
            }

            btnShowCalendar.setOnClickListener{
                val datePicker = DatePicker()
                datePicker
                    .show(supportFragmentManager,"datePicker")
            }

            btnShowTimePicker.setOnClickListener{
                val timePicker = TimePicker()
                timePicker
                    .show(supportFragmentManager, "timePicker")
            }
        }
    }

    override fun onDateSet(p0: android.widget.DatePicker?, p1: Int, p2: Int, p3: Int) {
        val selectDate = "$p3/${p2+1}/$p1"
        Toast.makeText(
            this@MainActivity,
            selectDate,Toast.LENGTH_SHORT
        ).show()
    }

    override fun onTimeSet(p0: TimePicker?, p1: Int, p2: Int) {
        val selectedTime = "$p1:$p2"
        Toast.makeText(
            this@MainActivity,
            selectedTime, Toast.LENGTH_SHORT
        ).show()
    }
}
package com.example.unittesting

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var mainViewModel: MainViewModel

    private lateinit var edtWidth: EditText
    private lateinit var edtHeight: EditText
    private lateinit var edtLength: EditText
    private lateinit var tvResult: TextView
    private lateinit var btnCalculateVolume: Button
    private lateinit var btnCalculateSurfaceArea: Button
    private lateinit var btnCalculateCircumference: Button
    private lateinit var btnSave: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel = MainViewModel(CubeModel())
        edtWidth = findViewById(R.id.edt_width)
        edtHeight = findViewById(R.id.edt_height)
        edtLength = findViewById(R.id.edt_length)
        tvResult = findViewById(R.id.tv_result)
        btnCalculateVolume = findViewById(R.id.btn_calculate_volume)
        btnCalculateCircumference = findViewById(R.id.btn_calculate_circumference)
        btnCalculateSurfaceArea = findViewById(R.id.btn_calculate_surface_area)
        btnSave = findViewById(R.id.btn_save)

        btnCalculateVolume.setOnClickListener(this)
        btnCalculateCircumference.setOnClickListener(this)
        btnCalculateSurfaceArea.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        val panjang = edtLength.text.toString().trim()
        val lebar = edtWidth.text.toString().trim()
        val tinggi = edtHeight.text.toString().trim()

        when {
            panjang.isEmpty() -> edtLength.error = "Field ini tidak boleh kosong!"
            lebar.isEmpty() -> edtWidth.error = "Field ini tidak boleh kosong!"
            tinggi.isEmpty() -> edtHeight.error = "Field ini tidak boleh kosong!"
            else -> {
                val p = panjang.toDouble()
                val l = lebar.toDouble()
                val t = tinggi.toDouble()

                when {
                    v.id == R.id.btn_save -> {
                        mainViewModel.save(l,p,t)
                        visible()
                    }

                    v.id == R.id.btn_calculate_circumference -> {
                        tvResult.text = mainViewModel.getKeliling().toString()
                        gone()
                    }

                    v.id == R.id.btn_calculate_surface_area -> {
                        tvResult.text = mainViewModel.getLuasPermukaan().toString()
                        gone()
                    }

                    v.id == R.id.btn_calculate_volume -> {
                        tvResult.text = mainViewModel.getVolume().toString()
                        gone()
                    }
                }
            }
        }
    }

    private fun visible() {
        btnCalculateVolume.visibility = View.VISIBLE
        btnCalculateCircumference.visibility = View.VISIBLE
        btnCalculateSurfaceArea.visibility = View.VISIBLE
        btnSave.visibility = View.GONE
    }

    private fun gone() {
        btnCalculateVolume.visibility = View.GONE
        btnCalculateCircumference.visibility = View.GONE
        btnCalculateSurfaceArea.visibility = View.GONE
        btnSave.visibility = View.VISIBLE
    }
}

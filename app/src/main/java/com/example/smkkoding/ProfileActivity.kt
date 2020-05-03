package com.example.smkkoding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        ambilData()
    }

    private fun ambilData() {
        val bundle = intent.extras
        val name = bundle?.getString("name")
        val gender = bundle?.getString("gender")
        val email = bundle?.getString("email")
        val telp = bundle?.getString("telp")
        val alamat = bundle?.getString("alamat")
        tv_name.text = name
        tv_gender.text = gender
        tv_email.text = email
        tv_telp.text = telp
        tv_address.text = alamat
    }
}

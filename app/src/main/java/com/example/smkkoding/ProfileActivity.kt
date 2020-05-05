package com.example.smkkoding

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        ambilData()

        btn_editName.setOnClickListener { navigateEditProfile() }
        btn_call.setOnClickListener { dialPhoneNumber(tv_telp.text.toString()) }
    }

    private fun ambilData() {
        val bundle = intent.extras
        val name = bundle?.getString("name")
        val gender = bundle?.getString("gender")
        val email = bundle?.getString("email")
        val telp = bundle?.getString("telp")
        val alamat = bundle?.getString("alamat")
        val umur = bundle?.getString("umur")
        tv_name.text = name
        tv_gender.text = gender
        tv_email.text = email
        tv_telp.text = telp
        tv_address.text = alamat
        tv_umur.text = umur
    }

    companion object {
        const val REQUEST_CODE = 1000
    }

    private fun navigateEditProfile() {
        val intent = Intent(this, EditProfileActivity::class.java)
        val userName = tv_name.text.toString()
        intent.putExtra("name", userName)
        startActivityForResult(intent, REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                val result = data?.getStringExtra("name")
                tv_name.text = result
                Toast.makeText(this, "Succes edit your name", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Edit failed", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun dialPhoneNumber(phoneNumber: String) {
        val intent = Intent(Intent.ACTION_DIAL).apply {
            data = Uri.parse("tel:$phoneNumber")
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }
}

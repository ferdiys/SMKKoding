package com.example.smkkoding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var namaInput: String = ""
    private var emailInput: String = ""
    private var telpInput: String = ""
    private var alamatInput: String = ""
    private var genderInput: String = ""
    private var umurInput: String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setDataSpinnerGender()

        btn_save.setOnClickListener { validasiInput() }
    }

    private fun goToProfilActivity() {
        val intent = Intent(this, ProfileActivity::class.java)

        val bundle = Bundle()
        bundle.putString("name", namaInput)
        bundle.putString("gender", genderInput)
        bundle.putString("email", emailInput)
        bundle.putString("telp", telpInput)
        bundle.putString("alamat", alamatInput)
        bundle.putString("umur", umurInput)
        intent.putExtras(bundle)

        startActivity(intent)
    }

    private fun validasiInput() {
        namaInput = edt_name.text.toString()
        emailInput = edt_email.text.toString()
        telpInput = edt_telp.text.toString()
        alamatInput = edt_address.text.toString()
        genderInput = spinner_gender.selectedItem.toString()
        umurInput = edt_umur.text.toString()

        when {
            namaInput.isEmpty() -> edt_name.error = "Nama tidak boleh kosong"
            genderInput.equals(
                "Pilih Jenis Kelamin",
                ignoreCase = true
            ) -> tampilToast("Jenis Kelamin harus dipilih")
            emailInput.isEmpty() -> edt_email.error = "Email tidak boleh kosong"
            telpInput.isEmpty() -> edt_telp.error = "Telp tidak boleh kosong"
            alamatInput.isEmpty() -> edt_address.error = "Alamat tidak boleh kosong"
            umurInput.isEmpty() -> edt_umur.error = "Umur tidak boleh kosong"
            else -> {
                tampilToast("Navigasi ke halaman profil")
                goToProfilActivity()
            }
        }

    }

    private fun tampilToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun setDataSpinnerGender() {
        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.gender, android.R.layout.simple_spinner_item
        )

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner_gender.adapter = adapter
    }
}

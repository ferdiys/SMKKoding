package com.example.smkkoding

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_edit_profile.*

class EditProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)

        val intentData = intent.extras
        val userName = intentData?.getString("name")

        edt_profileName.setText(userName)

        btn_editSave.setOnClickListener { saveData() }
    }

    private fun saveData() {
        val editName = edt_profileName.text.toString()

        if (editName.isEmpty()) {
            setResult(Activity.RESULT_CANCELED)
        }
        else {
            val result = Intent()
            result.putExtra("name", editName)
            setResult(Activity.RESULT_OK, result)
        }
        finish()
    }
}

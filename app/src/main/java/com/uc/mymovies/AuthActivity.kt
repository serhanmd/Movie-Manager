package com.uc.mymovies

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.firebase.ui.auth.AuthUI
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class AuthActivity : AppCompatActivity() {
    private var user : FirebaseUser? = null
    private final val AUTH_REQUEST_CODE = 1337 // we are nerds
    private final val PROVIDERS = arrayListOf(
            AuthUI.IdpConfig.EmailBuilder().build()
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val login = findViewById<Button>(R.id.btnLogon)
        setContentView(R.layout.activity_auth)
        val loginBtn = findViewById<Button>(R.id.btnLogon)
        loginBtn.setOnClickListener() {
            startActivityForResult(
                    AuthUI.getInstance().createSignInIntentBuilder().setAvailableProviders(PROVIDERS).build(), AUTH_REQUEST_CODE
            )
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK) {
            if (requestCode == AUTH_REQUEST_CODE) {
                user = FirebaseAuth.getInstance().currentUser
                // they have authenticated/created an account, lets take them to the app now
                val toApp = Intent(this, AuthActivity::class.java)
                startActivity(toApp)
            }
        }
    }
}
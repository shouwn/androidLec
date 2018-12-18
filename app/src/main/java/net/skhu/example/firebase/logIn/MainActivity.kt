package net.skhu.example.firebase.logIn

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.IdpResponse
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_log_in.*
import net.skhu.example.R

class MainActivity : AppCompatActivity() {

    companion object {
        const val RC_SIGN_IN = 337
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)

        btnLogin.setOnClickListener {
            startLoginInActivity()
        }

        btnLogout.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            textView.text = getUserName()
        }

        startLoginInActivity()
    }

    private fun startLoginInActivity() {
        val providers = listOf(
                AuthUI.IdpConfig.EmailBuilder().build(),
                AuthUI.IdpConfig.GoogleBuilder().build()
        )

        startActivityForResult(
                AuthUI.getInstance()
                        .createSignInIntentBuilder()
                        .setAvailableProviders(providers)
                        .build(),
                RC_SIGN_IN)
    }

    private fun getUserName() =
            FirebaseAuth.getInstance().currentUser?.displayName?.also {
                Toast.makeText(this@MainActivity,
                        "Authentication Success. $it",
                        Toast.LENGTH_LONG).show()
            } ?: "Anonymous"

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == RC_SIGN_IN){
            if(resultCode == RESULT_OK)
                textView.text = getUserName()
            else{
                val error = IdpResponse.fromResultIntent(data)?.error

                Toast.makeText(this@MainActivity,
                        "Authentication Failure. ${error?.errorCode} ${error?.message}",
                        Toast.LENGTH_LONG).show()
            }
        }
    }
}

package fr.isen.bosc.apptoolbox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_)


        loginAction.setOnClickListener { it:View!
            val identifiant = loginUser.text.toString()
            val message = "tu as cliqué $identifiant"
            Toast.makeText(context: this, message, Toast.LENGTH_LONG).show()
        }
    }
}

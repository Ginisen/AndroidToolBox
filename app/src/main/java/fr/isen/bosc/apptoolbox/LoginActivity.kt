package fr.isen.bosc.apptoolbox

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.

class LoginActivity : AppCompatActivity() {

     companion object {
         private const vat GOOD_IDENTIFIANT = "admin"
         private const vat GOOD_PASSWORD = "123"
     }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_)


        loginAction.setOnClickListener { it:View!
            /*
            val message = "tu as cliqué $identifiant"
            Toast.makeText(context: this, message, Toast.LENGTH_LONG).show()*/
            doLogin()
        }
    }

    private fun doLogin() {
        val identifiant = loginUser.text.toString()
        val password = loginUser.text.toString()
        if(identifiant == GOOD_IDENTIFIANT && password == GOOD_PASSWORD) {
            startActivity(Intent(packageContext: this@LogActivity))
        }
    }
}

package fr.isen.bosc.apptoolbox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.content.Intent
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    companion object {
        private const val GOOD_IDENTIFIANT = "admin"
        private const val GOOD_PASSWORD = "123"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        button.setOnClickListener {

            val message = "${identifier.text} connected"
            Toast.makeText(this, message, Toast.LENGTH_LONG).show()
            doLogin()
        }
    }

    private fun doLogin() {
        val identifier = identifier.text.toString()
        val password = password.text.toString()
        if(identifier == GOOD_IDENTIFIANT && password == GOOD_PASSWORD) {
            startActivity(Intent(this@LoginActivity, HomeActivity::class.java))
        }
    }
}

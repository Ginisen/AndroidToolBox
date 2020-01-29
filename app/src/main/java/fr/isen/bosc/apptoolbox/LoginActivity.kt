package fr.isen.bosc.apptoolbox

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.content.Intent
import android.content.SharedPreferences
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    lateinit var sharedPreferences: SharedPreferences

    companion object {
        private const val GOOD_IDENTIFIANT = "admin"
        private const val GOOD_PASSWORD = "123"
        const val USER_PREFS = "user_prefs"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        sharedPreferences = getSharedPreferences(USER_PREFS, Context.MODE_PRIVATE)
        val savedIdentifier :String? = sharedPreferences.getString("is", "")
        val savedPassword :String? = sharedPreferences.getString("pwd", "")

        if (savedIdentifier == GOOD_IDENTIFIANT && savedPassword == GOOD_PASSWORD) {
            goToHome(savedIdentifier, true)
        }

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
            //startActivity(Intent(this@LoginActivity, HomeActivity::class.java))
            saveUserCredential(identifier, password)
            goToHome(identifier, true)
        }
        else {
            Toast.makeText(this@LoginActivity, "Identifier or Password not correct", Toast.LENGTH_SHORT).show()
        }
    }

    private fun saveUserCredential(identifier: String, password: String) {
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        editor.putString("id", identifier)
        editor.putString("pwd", password)
        editor.apply()
    }

    private fun goToHome(identifier: String, clearCache: Boolean) {
        val intent = Intent(this@LoginActivity, HomeActivity::class.java)
        intent.putExtra("strIdentifier", identifier)
        if (clearCache) intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
        if (clearCache) finish()
    }
}

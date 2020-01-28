package fr.isen.bosc.apptoolbox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_cycle_de_vie.*

class CycleDeVieActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cycle_de_vie)

        notification("onCreate", true)
    }

    private fun notification(message: String, isActive: Boolean) {
        if(isActive)
            cycleDeVieText.text = message
        else
            Log.d("TAG", message)
    }

    override fun onStart() {
        super.onStart()
        notification("onStart", true)
    }

    override fun onResume() {
        super.onResume()
        notification("onResume", true)
    }

    override fun onPause() {
        super.onPause()
        notification("onPause", false)
    }

    override fun onStop() {
        super.onStop()
        notification("onStop", false)
    }

    override fun onDestroy() {
        super.onDestroy()
        notification("onDestroy", false)
        Toast.makeText(this, "onDestroy", Toast.LENGTH_LONG).show()
    }
}

package fr.isen.bosc.apptoolbox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.app.DatePickerDialog
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_storage.*
import java.util.Calendar


class StorageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_storage)

        val dateOfBirth: TextView = findViewById(R.id.dateOfBirth)

        dateOfBirth.setOnClickListener {
            val cal: Calendar = Calendar.getInstance()
            val calYear = cal.get(Calendar.YEAR)
            val calMonth = cal.get(Calendar.MONTH)
            val calDay = cal.get(Calendar.DAY_OF_MONTH)
            val datePickerDialog = DatePickerDialog(this,
                DatePickerDialog.OnDateSetListener { view, year, monthYear, dayMonth ->
                    dateOfBirth.text = "$dayMonth/${(monthYear + 1)}/$year"
                }, calYear, calMonth, calDay
            )
            datePickerDialog.show()
        }

        buttonStorage.setOnClickListener {
            Toast.makeText(this, "Data saved", Toast.LENGTH_LONG).show()
        }

        buttonReading.setOnClickListener {
            Toast.makeText(this, "File .json displayed", Toast.LENGTH_LONG).show()
        }
    }
}

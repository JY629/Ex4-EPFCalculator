package com.example.ex4epfcalculator

import android.app.DatePickerDialog
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dob_text.setOnClickListener(){
            //datepicker fragment
            //https://stackoverflow.com/questions/45842167/how-to-use-datepickerdialog-in-kotlin
            val c: Calendar = Calendar.getInstance();
            val currentDay = c.get(Calendar.DAY_OF_MONTH);
            val currentMonth = c.get(Calendar.MONTH);
            val currentYear = c.get(Calendar.YEAR);

            val dpd = DatePickerDialog(this,
                DatePickerDialog.OnDateSetListener { view, year, month, day ->
                    dob_text.setText(
                        day.toString() + "/" +
                                (month + 1).toString() + "/" + year.toString()
                    )
                    val myAge = currentYear-year
                    val minSaving = getSaving(myAge)
                    val investment = minSaving * 30 / 100

                    age_text.setText(myAge.toString())
                    salary_text.setText("RM " + minSaving.toString())
                    allowance_text.setText("RM " + investment.toString())

                },currentYear,currentMonth,currentDay)
            dpd.show()
        }
    }

    fun getSaving(age:Int):Int{

        when(age){
            in 16..20->return (5000)
            in 21..25->return (14000)
            in 26..30->return (29000)
            in 31..35->return (50000)
            in 36..40->return (78000)
            in 41..45->return (116000)
            in 46..50->return (165000)
            in 51..55->return (228000)
            else ->return (0)
        }
    }
}

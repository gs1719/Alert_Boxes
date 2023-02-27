package com.example.alertboxes

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.alertboxes.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btn1.setOnClickListener {

            val builder1 = AlertDialog.Builder(this)

            builder1.setTitle("Are you sure?")
            builder1.setMessage("Do you really want to close the app")
            builder1.setIcon(R.drawable.baseline_exit_to_app_24)

            builder1.setPositiveButton(
                "Yes",
                DialogInterface.OnClickListener { dialogInterface, i ->
                    //What action should we perform when above text is pressed
                    finish()
                })

            builder1.setNegativeButton("NO", DialogInterface.OnClickListener { dialogInterface, i ->
                Toast.makeText(this, "Okay", Toast.LENGTH_SHORT).show()
            })

            builder1.show()
        }

        binding.btn2.setOnClickListener {
            val options = arrayOf("Windows xp", "Windows 7", "Windows 8.1","More than one then select type3")
            val builder2 = AlertDialog.Builder(this)
            builder2.setTitle("Which is your favoite OS")
            builder2.setSingleChoiceItems(
                options,
                0,
                DialogInterface.OnClickListener { dialogInterface, which ->
                    Toast.makeText(this, "You Clicked On ${options[which]}", Toast.LENGTH_SHORT)
                        .show()
                })

            builder2.setPositiveButton("Sumbit",DialogInterface.OnClickListener{dialogInterface, i ->

            })
            builder2.setNegativeButton("Deny",DialogInterface.OnClickListener { dialogInterface, i ->
                Toast.makeText(this, "Okay", Toast.LENGTH_SHORT).show()
            })
            builder2.show()
        }

        binding.btn3.setOnClickListener {
            val builder3 = AlertDialog.Builder(this)
            val options = arrayOf("Windows Xp","Windows 7","Windows 8.1","Linux")
            builder3.setTitle("Your Favourite OS is")

            builder3.setMultiChoiceItems(options,null,DialogInterface.OnMultiChoiceClickListener { dialogInterface, i, b ->
                Toast.makeText(this, "You clicked on ${options[i]}", Toast.LENGTH_SHORT).show()
            })

            builder3.setPositiveButton("Submit",DialogInterface.OnClickListener { dialogInterface, i ->

            })
            builder3.show()
        }
    }
}
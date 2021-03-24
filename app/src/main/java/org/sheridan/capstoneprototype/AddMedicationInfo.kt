package org.sheridan.capstoneprototype

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import org.sheridan.capstoneprototype.Classes.Medicine
import org.sheridan.capstoneprototype.Classes.User
import org.sheridan.capstoneprototype.Database.MyDBOpenHelperUser
import org.sheridan.capstoneprototype.databinding.ActivityAddMedicationInfoBinding
import org.sheridan.sqliteandroidkotldemo.MyDBOpenHelper


class AddMedicationInfo : AppCompatActivity() {

    private lateinit var binding: ActivityAddMedicationInfoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddMedicationInfoBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        binding.addMedButton.setOnClickListener {
            var medName = binding.editMed.text.toString()
            var medDosage = binding.editDosage.text.toString().toInt()
            var medFrequency = binding.editFrequency.text.toString().toInt()
            var medQuantity = binding.editQuantity.text.toString().toInt()
            var medDescription = binding.editDescription.text.toString()


            val dbHandler = MyDBOpenHelper(this,null)
            val medicine = Medicine(medName,medDosage,medFrequency,medQuantity,medDescription)

            dbHandler.addName(medicine)
            Toast.makeText(this, "Added ", Toast.LENGTH_SHORT).show()
//            val dbHandler = MyDBOpenHelperUser(this,null)
//            val user = User("vinayak","pavate@gamil.com")
//            dbHandler.addUser(user)


        }




    }
}
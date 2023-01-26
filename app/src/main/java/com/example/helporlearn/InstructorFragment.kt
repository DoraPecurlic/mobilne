package com.example.helporlearn

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


class InstructorFragment : Fragment() {

    private lateinit var name: TextInputEditText
    private lateinit var surname: TextInputEditText
    private lateinit var email: TextInputEditText
    private lateinit var number: TextInputEditText
    private lateinit var subject: TextInputEditText
    private lateinit var registerButton: Button

    private val database = Firebase.firestore

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {

        val view = inflater.inflate(R.layout.fragment_instructor, container, false)


        name = view.findViewById(R.id.editTextName)
        surname = view.findViewById(R.id.editTextSurname)
        email = view.findViewById(R.id.editTextEmail)
        number = view.findViewById(R.id.editTextPhoneNumber)
        subject = view.findViewById(R.id.editTextSubject)
        registerButton = view.findViewById(R.id.addButton)


        registerButton.setOnClickListener{
            val enteredName = name.text.toString().trim()
            val enteredSurname = surname.text.toString().trim()
            val enteredEmail = email.text.toString().trim()
            val enteredNumber = number.text.toString().trim()
            val enteredSubject = subject.text.toString().trim()

            val enteredInfo = hashMapOf(
                "Name" to enteredName,
                "Surname" to enteredSurname,
                "Email" to enteredEmail,
                "Number" to enteredNumber,
                "Subject" to enteredSubject,
            )
            database.collection("1")
                .add(enteredInfo)
                .addOnSuccessListener {
                    Toast.makeText(requireActivity(),"You are added as list_item in our database", Toast.LENGTH_LONG).show()
                    name.text?.clear()
                    surname.text?.clear()
                    email.text?.clear()
                    number.text?.clear()
                    subject.text?.clear()
                }
                .addOnFailureListener{
                    Toast.makeText(requireActivity(),"Registration failed", Toast.LENGTH_LONG).show()
                }

        }

        return view
    }

}
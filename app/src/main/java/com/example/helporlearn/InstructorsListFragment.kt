package com.example.helporlearn


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


class InstructorsListFragment : Fragment() {

   private lateinit var recyclerView: RecyclerView
   private lateinit var personAdapter: PersonRecyclerAdapter
   private lateinit var instructorArrayList: ArrayList<Instructor>
   private  var database = Firebase.firestore

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_instructors_list, container,false)

        recyclerView = view.findViewById(R.id.recyclerView)
        database.collection("1")
            .get()
            .addOnSuccessListener { result ->
                val personList = ArrayList<Instructor>()
                for(data in result.documents){
                    val person = data.toObject(Instructor::class.java)
                    if(person != null){
                        personList.add(person)
                    }
                }
                personAdapter = PersonRecyclerAdapter(personList)
                recyclerView.apply {
                    val manager = LinearLayoutManager(activity)
                    recyclerView.layoutManager = manager
                    recyclerView.setHasFixedSize(true)
                    adapter = personAdapter
                }

            }
            .addOnFailureListener {
                Toast.makeText(requireActivity()," failed", Toast.LENGTH_LONG).show()
            }








       // gettingData()

        return view
    }



    private fun gettingData(){

        val docRef = database.collection("1").document("52ttgkUDNdgWB6uinsGg")
        docRef.get()
            .addOnSuccessListener { document ->
                if (document != null) {

                    Toast.makeText(requireActivity(),"Registration failed", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(requireActivity(),"no document", Toast.LENGTH_LONG).show()
                }
            }
            .addOnFailureListener { exception ->
                Toast.makeText(requireActivity()," failed", Toast.LENGTH_LONG).show()
            }


    }

}
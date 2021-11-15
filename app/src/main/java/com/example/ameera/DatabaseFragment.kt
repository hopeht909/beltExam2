package com.example.ameera

import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ameera.adapters.RVAdapterFav
import com.example.ameera.model.MyViewModel
import com.example.ameera.retrofit.APIClient
import com.example.ameera.retrofit.APIInterface
import com.example.ameera.retrofit.UniversityData

class DatabaseFragment : Fragment() {

    lateinit var viewModel: MyViewModel
    lateinit var rvAdapter: RVAdapterFav
    lateinit var rvFav: RecyclerView
    private lateinit var info: ArrayList<UniversityData.UniversityDataItem>
    var apiInterface = APIClient().getClient()?.create(APIInterface::class.java)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_database, container, false)

        rvFav = view.findViewById(R.id.rvFav)
        viewModel = ViewModelProvider(this).get(MyViewModel::class.java)
        viewModel.getUniversityDB().observe(viewLifecycleOwner, { show ->
            rvAdapter.update(show)
        }
        )
        updateRV()

        return view
    }
    fun updateRV(){
        rvAdapter = RVAdapterFav(this)
        rvFav.adapter = rvAdapter
        rvFav.layoutManager = LinearLayoutManager(requireContext())

    }
    fun updateNote(currentNote: String, id : Int){
        val dialogBuilder = AlertDialog.Builder(requireContext())
        val etNote = EditText(requireContext())
        etNote.hint = "enter notes"

        dialogBuilder
            .setCancelable(false)
            .setPositiveButton("Yes", DialogInterface.OnClickListener {

                    _, _ ->
                run{
                    viewModel.updateUniversityDB("${etNote.text}",id)
                    Toast.makeText(activity,"Notes updated", Toast.LENGTH_LONG).show()
                }
            })
            .setNegativeButton("Cancel", DialogInterface.OnClickListener {
                    dialog, _ -> dialog.cancel()
            })
        val alert = dialogBuilder.create()
        alert.setTitle("Update Notes")
        alert.setView(etNote)
        alert.show()
    }

}
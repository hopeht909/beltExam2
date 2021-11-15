package com.example.ameera.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.ameera.DatabaseFragment
import com.example.ameera.database.UniversityEntity
import com.example.ameera.databinding.FavRowBinding

class RVAdapterFav(private val activity: DatabaseFragment) : RecyclerView.Adapter<RVAdapterFav.ItemViewHolder>() {
    private var university = emptyList<UniversityEntity>()
    class ItemViewHolder(val binding: FavRowBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ItemViewHolder {
        return ItemViewHolder(
            FavRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val uni = university[position]

        holder.binding.apply {
            tvName.text = uni.universityName
            tvCountry.text = uni.country



            btDelete.setOnClickListener {
                activity.viewModel.deleteUniversityDB(uni.id)
                Toast.makeText(activity.activity,"University deleted", Toast.LENGTH_LONG).show()

            }
            layout.setOnClickListener {
                Toast.makeText(activity.activity,"${uni.note}", Toast.LENGTH_LONG).show()
            }
            btUpdate.setOnClickListener {
                activity.updateNote(uni.note, uni.id)

            }
        }
    }

    override fun getItemCount() = university.size

    fun update(university: List<UniversityEntity>){
        println("UPDATING DATA")
        this.university = university
        notifyDataSetChanged()
    }
}
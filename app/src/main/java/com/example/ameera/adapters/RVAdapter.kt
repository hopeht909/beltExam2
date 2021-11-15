package com.example.ameera.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ameera.BrowserFragment
import com.example.ameera.databinding.ItemViewBinding
import com.example.ameera.retrofit.UniversityData

class RVAdapter(
    private val entries: ArrayList<UniversityData.UniversityDataItem>,
    private val activity: BrowserFragment

) : RecyclerView.Adapter<RVAdapter.ItemViewHolder>() {
    class ItemViewHolder(val binding: ItemViewBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            ItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val entry = entries[position]

        holder.binding.apply {
            btItem.text  = entry.name
            if(position%2==0){btItem.setBackgroundColor(Color.parseColor("#BBB0EE"))}
            btItem.setOnClickListener {
                activity.addToDatabase(entry.name,entry.country,"")
            }


        }
    }

    override fun getItemCount() = entries.size

}
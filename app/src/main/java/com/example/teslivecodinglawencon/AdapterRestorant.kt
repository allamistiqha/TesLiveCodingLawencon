package com.example.teslivecodinglawencon

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.teslivecodinglawencon.data.Restoran
import com.example.teslivecodinglawencon.databinding.ItemRestorantBinding

class AdapterRestorant(val onClick:(String)->Unit) : ListAdapter<Restoran, AdapterRestorant.RestoranHolder>(RestoranComparator()){

    inner class RestoranHolder(val items: ItemRestorantBinding): RecyclerView.ViewHolder(items.root){
        fun bindData(data : Restoran, onClick: (String) -> Unit){
            items.data = data
            items.executePendingBindings()
            items.clClick.setOnClickListener {
                onClick(data.name)
//                onClick(Restoran)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestoranHolder {
        val rLayout : ItemRestorantBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context), R.layout.item_restorant, parent, false
        )
        return RestoranHolder(rLayout)
    }

    override fun onBindViewHolder(holder: RestoranHolder, position: Int) {
        val curentItem = getItem(position)
        if (curentItem != null) holder.bindData(curentItem, onClick)
    }

    class RestoranComparator: DiffUtil.ItemCallback<Restoran>(){
        override fun areItemsTheSame(oldItem: Restoran, newItem: Restoran) = oldItem.uid == newItem.uid
        override fun areContentsTheSame(oldItem: Restoran, newItem: Restoran) = oldItem == newItem
    }

}

//    (val listRestoran : List<Restoran>)
//    :  RecyclerView.Adapter<AdapterRestorant.RestoranHolder>(){
//
//    inner class RestoranHolder(val item: View): RecyclerView.ViewHolder(item){
//        fun bindData(data : Restoran){
//
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestoranHolder {
//        val rLayout : ViewDataBinding = DataBindingUtil.inflate(
//            LayoutInflater.from(parent.context), R.layout.item_restorant, parent, false
//        )
//        return RestoranHolder(rLayout.root)
//    }
//
//    override fun onBindViewHolder(holder: RestoranHolder, position: Int) {
//        holder.bindData(listRestoran[position])
//    }
//
//    override fun getItemCount(): Int = listRestoran.size
//
//    class RestoranComparator: DiffUtil.ItemCallback<Restoran>(){
//        override fun areItemsTheSame(oldItem: Restoran, newItem: Restoran) = oldItem.uid == newItem.uid
//
//        override fun areContentsTheSame(oldItem: Restoran, newItem: Restoran) = oldItem == newItem
//
//    }
//}


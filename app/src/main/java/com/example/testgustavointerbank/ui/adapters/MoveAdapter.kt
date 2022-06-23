package com.example.testgustavointerbank.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.Entity.MoveEntity
import com.example.testgustavointerbank.databinding.ItemMoveLayoutBinding
import com.example.testgustavointerbank.models.MoveModel

class MoveAdapter() : RecyclerView.Adapter<MoveAdapter.MoveViewHolder>() {

    private var listMoves : List<MoveModel> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoveViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemMoveLayoutBinding = ItemMoveLayoutBinding.inflate(inflater, parent,false)
        return MoveViewHolder(itemMoveLayoutBinding)
    }

    override fun onBindViewHolder(holder: MoveViewHolder, position: Int) {
        holder.bind(listMoves[position])
    }

    override fun getItemCount(): Int {
       return listMoves.size
    }

    inner class MoveViewHolder(val binding : ItemMoveLayoutBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(move : MoveModel){
            binding.apply {
                moveMount.text = move.mountMove
                moveDate.text = move.dateMove
                moveType.text = move.typeMove
            }
        }
    }

    fun setData(newListMoves : List<MoveModel>){
        listMoves = newListMoves
        notifyDataSetChanged()
    }
}
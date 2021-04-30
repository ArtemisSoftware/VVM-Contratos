package com.artemissoftware.vvmcontratos.ui.acordo.adaptadores

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.artemissoftware.vvmcontratos.baseDados.entidades.Contrato
import com.artemissoftware.vvmcontratos.databinding.ItemAcordoBinding

class AcordosAdaptador(/*private val listener: onItemClickListener*/) : ListAdapter<Contrato, AcordosAdaptador.AcordoViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AcordoViewHolder {
        val binding = ItemAcordoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AcordoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AcordoViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.bind(currentItem)
    }

    inner class AcordoViewHolder(private val binding: ItemAcordoBinding) : RecyclerView.ViewHolder(binding.root) {

//        init {
//            binding.apply {
//                root.setOnClickListener {
//
//                    val position = adapterPosition
//
//                    if(position != RecyclerView.NO_POSITION){
//                        val task = getItem(position)
//                        listener.onItemClick(task)
//                    }
//
//                }

//            }
//        }

        fun bind(registo: Contrato) {
            binding.acordo = registo
        }
    }
//
//    interface  onItemClickListener{
//
//        fun onItemClick(task: Task)
//        fun onCheckboxClick(task: Task, isChecked: Boolean)
//
//    }


    class DiffCallback : DiffUtil.ItemCallback<Contrato>() {
        override fun areItemsTheSame(oldItem: Contrato, newItem: Contrato) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Contrato, newItem: Contrato) =
            oldItem == newItem
    }
}
package com.artemissoftware.vvmcontratos.ui.definicoes.adaptadores

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.artemissoftware.vvmcontratos.databinding.ItemTipoBinding
import com.artemissoftware.vvmcontratos.ui.definicoes.modelos.ResumoTipo

class TipoAdaptador(/*private val listener: onItemClickListener*/) : ListAdapter<ResumoTipo, TipoAdaptador.TipoViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TipoViewHolder {
        val binding = ItemTipoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TipoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TipoViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.bind(currentItem)
    }

    inner class TipoViewHolder(private val binding: ItemTipoBinding) : RecyclerView.ViewHolder(binding.root) {

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

        fun bind(resumoTipo: ResumoTipo) {
            binding.resumo = resumoTipo
        }
    }
//
//    interface  onItemClickListener{
//
//        fun onItemClick(task: Task)
//        fun onCheckboxClick(task: Task, isChecked: Boolean)
//
//    }


    class DiffCallback : DiffUtil.ItemCallback<ResumoTipo>() {
        override fun areItemsTheSame(oldItem: ResumoTipo, newItem: ResumoTipo) =
            oldItem.descricao == newItem.descricao

        override fun areContentsTheSame(oldItem: ResumoTipo, newItem: ResumoTipo) =
            oldItem == newItem
    }
}
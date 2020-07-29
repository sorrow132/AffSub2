package yuresko.affsub2.adapter

import androidx.recyclerview.widget.DiffUtil
import yuresko.affsub2.mainview.model.ItemModel

class DiffUtilCallBack : DiffUtil.ItemCallback<ItemModel>() {

    override fun areItemsTheSame(oldItem: ItemModel, newItem: ItemModel): Boolean {
        return oldItem is ItemModel && newItem is ItemModel
    }

    override fun areContentsTheSame(oldItem: ItemModel, newItem: ItemModel): Boolean {
        return oldItem == newItem
    }
}
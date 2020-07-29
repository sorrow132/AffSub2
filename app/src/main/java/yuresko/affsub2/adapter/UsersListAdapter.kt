package yuresko.affsub2.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import yuresko.affsub2.mainview.model.ItemModel

class UsersListAdapter(private val context: Context) :
    androidx.recyclerview.widget.ListAdapter<ItemModel, RecyclerView.ViewHolder>(DiffUtilCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return CustomViewHolder(parent, context)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is CustomViewHolder) {
            holder.bind(getItem(position) as ItemModel)
        }
    }
}
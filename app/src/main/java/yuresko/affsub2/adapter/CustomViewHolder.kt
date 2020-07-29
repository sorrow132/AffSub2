package yuresko.affsub2.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import yuresko.affsub2.InfoActivity
import yuresko.affsub2.R
import yuresko.affsub2.mainview.model.ItemModel

class CustomViewHolder(parent: ViewGroup, private val context: Context) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(
        R.layout.rv_item, parent, false
    )
) {
    private var image: ImageView? = itemView.findViewById(R.id.appIconItem)
    private var firstName: TextView? = itemView.findViewById(R.id.textViewUserFirstName)
    private var lastName: TextView? = itemView.findViewById(R.id.textViewUserLastName)
    private var selectedItem: LinearLayout? = itemView.findViewById(R.id.linearInCardView)


    fun bind(itemModel: ItemModel) {
        Picasso.get().load(itemModel.image)
            .into(image)

        firstName?.text = itemModel.firstName
        lastName?.text = itemModel.lastName

        selectedItem?.setOnClickListener {
            val intent = Intent(context, InfoActivity::class.java)
            intent.putExtra("image", itemModel.image)
            intent.putExtra("firstName", itemModel.firstName)
            intent.putExtra("lastName", itemModel.lastName)
            intent.putExtra("age", itemModel.age)
            intent.putExtra("number", itemModel.number)
            intent.putExtra("email", itemModel.email)
            intent.putExtra("skype", itemModel.skype)

            context.startActivity(intent)
        }

    }


}
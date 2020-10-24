package com.example.spacex.epoxy

import android.view.View
import android.widget.TextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.example.spacex.R
import kotlinx.android.synthetic.main.entry_item.view.*

@EpoxyModelClass(layout = R.layout.entry_item)
abstract class EntryModel: EpoxyModelWithHolder<EntryModel.EntryHolder>() {

    @EpoxyAttribute
    var name: CharSequence? = ""
    @EpoxyAttribute
    var description: CharSequence? = ""

    override fun bind(holder: EntryHolder) {
        holder.entryName.text = name
        holder.entryDescription.text = name
    }

    inner class EntryHolder: EpoxyHolder() {
        lateinit var entryName: TextView
        lateinit var entryDescription: TextView

        override fun bindView(itemView: View) {
            entryName = itemView.entry_name_item
            entryDescription = itemView.entry_discription_item
        }
    }
}
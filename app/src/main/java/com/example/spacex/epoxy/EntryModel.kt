package com.example.spacex.epoxy

import android.app.Application
import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.example.spacex.R
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.android.synthetic.main.entry_item.view.*
import java.lang.System.load
import kotlin.coroutines.coroutineContext
import com.airbnb.epoxy.EpoxyModelWithHolder as EpoxyModelWithHolder1

@EpoxyModelClass(layout = R.layout.entry_item)
abstract class EntryModel() : EpoxyModelWithHolder1<EntryModel.EntryHolder>() {
    @EpoxyAttribute
    var name: CharSequence? = ""
    @EpoxyAttribute
    var mission: CharSequence? = ""
    @EpoxyAttribute
    var date: CharSequence? = ""
    @EpoxyAttribute
    var imageUrl: CharSequence? = ""

    constructor(parcel: Parcel) : this() {
        name = parcel.readString()
        mission = parcel.readString()
        date = parcel.readString()
        imageUrl = parcel.readString()
    }

    override fun bind(holder: EntryHolder) {

        holder.launch_name.text = name
        holder.launch_date.text = date
        holder.launch_mission.text = mission
        /*Glide
            .with(holder.bedge)
            .load(imageUrl)
            .centerCrop()
            .into(holder?.bedge)*/
    }

    inner class EntryHolder: EpoxyHolder() {
        lateinit var launch_name: TextView
        lateinit var launch_date: TextView
        lateinit var launch_mission: TextView
        lateinit var bedge: ImageView

        override fun bindView(itemView: View) {
            launch_name = itemView.launch_name
            launch_date = itemView.launch_date
            launch_mission = itemView.mission_name
            bedge = itemView.padge
        }
    }



}
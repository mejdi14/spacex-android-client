package com.example.spacex.epoxy

import android.app.Application
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.ShapeDrawable
import android.os.Parcel
import android.os.Parcelable
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.example.spacex.R
import com.example.spacex.function.getListColors
import com.example.spacex.function.upperTheFirstLetter
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.android.synthetic.main.entry_item.view.*
import java.lang.System.load
import kotlin.coroutines.coroutineContext
import kotlin.random.Random
import com.airbnb.epoxy.EpoxyModelWithHolder as EpoxyModelWithHolder1

@EpoxyModelClass(layout = R.layout.entry_item)
abstract class EntryModel() : EpoxyModelWithHolder1<EntryModel.EntryHolder>() {
    @EpoxyAttribute
    var name: CharSequence? = ""

    @EpoxyAttribute
    var mission: CharSequence? = ""

    @EpoxyAttribute
    var date: CharSequence? = ""


    constructor(parcel: Parcel) : this() {
        name = parcel.readString()
        mission = parcel.readString()
        date = parcel.readString()
    }

    override fun bind(holder: EntryHolder) {

        holder.launch_name.text = mission.toString().upperTheFirstLetter()
        holder.launch_date.text = date
        holder.launch_mission.text = "launche site: ${name.toString().upperTheFirstLetter()}"

        val background: Drawable = holder.container.background
        changingBackgroundColor(
            background,
            Color.parseColor(getListColors().get(Random.nextInt(0, 7)))
        )

    }

    inner class EntryHolder : EpoxyHolder() {
        lateinit var launch_name: TextView
        lateinit var container: ConstraintLayout
        lateinit var launch_date: TextView
        lateinit var launch_mission: TextView
        lateinit var bedge: ImageView

        override fun bindView(itemView: View) {
            launch_name = itemView.launch_name
            container = itemView.container
            launch_date = itemView.launch_date
            launch_mission = itemView.mission_name
            bedge = itemView.padge
        }


    }


    private fun changeColorForView(view: View, color: String) {

        val background: Drawable = view.background
        changingBackgroundColor(background, Color.parseColor(color))
    }

    private fun changingBackgroundColor(background: Drawable, color: Int) {
        if (background is ShapeDrawable) {
            // cast to 'ShapeDrawable'
            background.paint.color = color
        } else if (background is GradientDrawable) {
            // cast to 'GradientDrawable'
            background.setColor(color)
        } else if (background is ColorDrawable) {
            // alpha value may need to be set again after this call
            background.color = color
        }
    }

}
package com.marco.pocandroidtvleanback.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.leanback.widget.Presenter
import com.bumptech.glide.Glide
import com.marco.pocandroidtvleanback.R
import com.marco.pocandroidtvleanback.domain.model.movies.Result

class ItemPresenter : Presenter() {
    override fun onCreateViewHolder(parent: ViewGroup?): ViewHolder {

        val view =
            LayoutInflater.from(parent?.context).inflate(R.layout.item_view, parent, false)

        val params = view.layoutParams
        params.width = getWidthInPercent(parent!!.context, 12)
        params.height = getHeightInPercent(parent.context, 32)

        return ViewHolder(view)

    }

    fun getWidthInPercent(context: Context, percent: Int): Int {
        val width = context.resources.displayMetrics.widthPixels
        return (width * percent) / 100
    }

    fun getHeightInPercent(context: Context, percent: Int): Int {
        val width = context.resources.displayMetrics.heightPixels
        return (width * percent) / 100
    }


    override fun onBindViewHolder(viewHolder: ViewHolder?, item: Any?) {
        val content = item as? Result
        val imageview = viewHolder?.view?.findViewById<ImageView>(R.id.poster_image)

        val url = "https://www.themoviedb.org/t/p/w500" + content?.posterPath

        Glide.with(viewHolder?.view?.context!!)
            .load(url)
            .into(imageview!!)
    }

    override fun onUnbindViewHolder(viewHolder: ViewHolder?) {
    }
}
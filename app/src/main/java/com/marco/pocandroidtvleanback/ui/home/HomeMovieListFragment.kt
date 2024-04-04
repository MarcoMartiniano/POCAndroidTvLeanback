package com.marco.pocandroidtvleanback.ui.home

import android.os.Bundle
import android.view.View
import androidx.leanback.app.RowsSupportFragment
import androidx.leanback.widget.ArrayObjectAdapter
import androidx.leanback.widget.FocusHighlight
import androidx.leanback.widget.HeaderItem
import androidx.leanback.widget.ListRow
import androidx.leanback.widget.ListRowPresenter
import androidx.leanback.widget.OnItemViewClickedListener
import androidx.leanback.widget.OnItemViewSelectedListener
import androidx.leanback.widget.Presenter
import androidx.leanback.widget.Row
import androidx.leanback.widget.RowPresenter
import com.marco.pocandroidtvleanback.domain.model.movies.Movies
import com.marco.pocandroidtvleanback.domain.model.movies.Result
import com.marco.pocandroidtvleanback.domain.utils.Constants


class HomeMovieListFragment : RowsSupportFragment() {
    private var itemSelectedListener: ((Result) -> Unit)? = null
    private var itemClickListener: ((Result) -> Unit)? = null

    private var rootAdapter: ArrayObjectAdapter =
        ArrayObjectAdapter(ListRowPresenter(FocusHighlight.ZOOM_FACTOR_MEDIUM))

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = rootAdapter
        onItemViewSelectedListener = ItemViewSelectedListener()
        onItemViewClickedListener = ItemViewClickListener()

        addEmptyListRow()
    }

    private fun addEmptyListRow() {
        val nowPlayingListRow = createListRow(null, Constants.Movies.NOW_PLAYING)
        val popularListRow = createListRow(null, Constants.Movies.POPULAR)
        val topRatedListRow = createListRow(null, Constants.Movies.TOP_RATED)
        val upcomingListRow = createListRow(null, Constants.Movies.UPCOMING)
        rootAdapter.add(nowPlayingListRow)
        rootAdapter.add(popularListRow)
        rootAdapter.add(topRatedListRow)
        rootAdapter.add(upcomingListRow)
    }

    private fun createListRow(moviesList: Movies?, listName: String): ListRow {
        val headerItem = HeaderItem(listName)
        val arrayObjectAdapter = ArrayObjectAdapter(ItemPresenter())
        moviesList.let {
            it?.results?.forEach { result ->
                arrayObjectAdapter.add(result)
            }
        }
        return ListRow(headerItem, arrayObjectAdapter)
    }

    fun bindData(moviesList: Movies?, listName: String) {
        val listRow = createListRow(moviesList, listName)
        val replaceIndex = when (listName) {
            Constants.Movies.NOW_PLAYING -> 0
            Constants.Movies.POPULAR -> 1
            Constants.Movies.TOP_RATED -> 2
            Constants.Movies.UPCOMING -> 3
            else -> {
                -1
            }
        }
        rootAdapter.replace(replaceIndex, listRow)
    }

    fun setOnContentSelectedListener(listener: (Result) -> Unit) {
        this.itemSelectedListener = listener
    }

    fun setOnItemClickListener(listener: (Result) -> Unit) {
        this.itemClickListener = listener
    }

    inner class ItemViewSelectedListener : OnItemViewSelectedListener {
        override fun onItemSelected(
            itemViewHolder: Presenter.ViewHolder?,
            item: Any?,
            rowViewHolder: RowPresenter.ViewHolder?,
            row: Row?,
        ) {
            if (item is Result) {
                itemSelectedListener?.invoke(item)
            }
        }
    }

    inner class ItemViewClickListener : OnItemViewClickedListener {
        override fun onItemClicked(
            itemViewHolder: Presenter.ViewHolder?,
            item: Any?,
            rowViewHolder: RowPresenter.ViewHolder?,
            row: Row?,
        ) {
            if (item is Result) {
                itemClickListener?.invoke(item)
            }
        }
    }

}
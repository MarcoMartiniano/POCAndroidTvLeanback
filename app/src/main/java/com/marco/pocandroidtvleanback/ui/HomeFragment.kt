package com.marco.pocandroidtvleanback.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.google.gson.Gson
import com.marco.pocandroidtvleanback.DataModel
import com.marco.pocandroidtvleanback.ListFragment
import com.marco.pocandroidtvleanback.R
import com.marco.pocandroidtvleanback.databinding.FragmentHomeBinding
import com.marco.pocandroidtvleanback.utils.viewInflateBinding
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader

class HomeFragment : Fragment() {
    private val binding by viewInflateBinding(FragmentHomeBinding::inflate)
    private lateinit var listFragment: ListFragment

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View = binding.root


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {

        listFragment = ListFragment()
        val transaction = childFragmentManager.beginTransaction()
        transaction.add(R.id.list_fragment, listFragment)
        transaction.commit()

        val gson = Gson()
        val i: InputStream = requireContext().assets.open("movies.json")
        val br = BufferedReader(InputStreamReader(i))
        val dataList: DataModel = gson.fromJson(br, DataModel::class.java)

        listFragment.bindData(dataList)

        listFragment.setOnContentSelectedListener {
            updateBanner(it)
        }

//         listFragment.setOnItemClickListener {
//             val intent  = Intent(requireContext(), DetailActivity::class.java)
//             intent.putExtra("id", it.id)
//             startActivity(intent)
//         }
    }

    private fun updateBanner(dataList: DataModel.Result.Detail) {
        binding.title.text = dataList.title
        binding.description.text = dataList.overview
        val url = "https://www.themoviedb.org/t/p/w780" + dataList.backdrop_path
        Glide.with(this).load(url).into(binding.imgBanner)
    }
}
package com.marco.pocandroidtvleanback.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import com.marco.pocandroidtvleanback.ListFragment
import com.marco.pocandroidtvleanback.data_remote.exception.InvalidApiKeyException
import com.marco.pocandroidtvleanback.databinding.FragmentHomeBinding
import com.marco.pocandroidtvleanback.presentation.HomeViewModel
import com.marco.pocandroidtvleanback.utils.isError
import com.marco.pocandroidtvleanback.utils.isSuccess
import com.marco.pocandroidtvleanback.utils.observeLiveData
import com.marco.pocandroidtvleanback.utils.viewInflateBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {
    private val binding by viewInflateBinding(FragmentHomeBinding::inflate)
    // private lateinit var listFragment: ListFragment

    private val viewModel: HomeViewModel by viewModel()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View = binding.root


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addObservers(viewLifecycleOwner)
        init()
    }

    private fun addObservers(owner: LifecycleOwner) {
        viewModel.getNowPlayingMoviesViewState.observeLiveData(owner, false) {
            when {
                it.isSuccess() -> {
                    Log.d("TESTE", "SUCESS $it")
                    Log.d("TESTE", "SUCESS ${it.data}")
                }

                it.isError() -> {
                    when (it.error) {
                        is InvalidApiKeyException -> {
                            Toast.makeText(
                                requireContext(),
                                "Please add A valid ApiKey",
                                Toast.LENGTH_LONG
                            ).show()
                        }

                        else -> {
                            Toast.makeText(
                                requireContext(),
                                "Generic error.",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }
                }
            }
        }
    }

    private fun init() {
        viewModel.getNowPlayingMovies()


//        listFragment = ListFragment()
//        val transaction = childFragmentManager.beginTransaction()
//        transaction.add(R.id.list_fragment, listFragment)
//        transaction.commit()
//
//        val gson = Gson()
//        val i: InputStream = requireContext().assets.open("movies.json")
//        val br = BufferedReader(InputStreamReader(i))
//        val dataList: DataModel = gson.fromJson(br, DataModel::class.java)
//
//        listFragment.bindData(dataList)
//
//        listFragment.setOnContentSelectedListener {
//            updateBanner(it)
//        }

//         listFragment.setOnItemClickListener {
//             val intent  = Intent(requireContext(), DetailActivity::class.java)
//             intent.putExtra("id", it.id)
//             startActivity(intent)
//         }
    }

//    private fun updateBanner(dataList: DataModel.Result.Detail) {
//        binding.title.text = dataList.title
//        binding.description.text = dataList.overview
//        val url = "https://www.themoviedb.org/t/p/w780" + dataList.backdrop_path
//        Glide.with(this).load(url).into(binding.imgBanner)
//    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewModel.clearViewStates()
    }
}
package com.example.androidavanzado.view.tvshows

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidavanzado.R
import com.example.androidavanzado.model.TvShowsBinding
import com.example.androidavanzado.view.movies.MoviesFragment
import com.example.androidavanzado.view.movies.MoviesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TvShowsFragment: Fragment() {

        companion object {
            fun newInstance() = MoviesFragment()
        }

        private lateinit var binding: TvShowsFragmentBinding

        private val viewModel: TvShowsViewModel by viewModels()




        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            val view = inflater.inflate(R.layout.movies_fragment, container, false)
            binding = TvShowsBinding.bind(view)

            return binding.root
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)

            val adapter = TvShowsAdapter(ArrayList())


            binding.tvShowList.adapter = adapter
            binding.tvShowList.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)


            viewModel.getViewModelPopularTvShows()
            viewModel.data.observe(viewLifecycleOwner) {
                adapter.updateMovies(it)
            }
        }
    }
}
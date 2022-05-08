package com.example.androidavanzado.view.movies

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidavanzado.R
import com.example.androidavanzado.model.title
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MoviesFragment : Fragment() {

    companion object {
        fun newInstance() = MoviesFragment()
    }

    private lateinit var binding: MoviesFragmentBinding

    private val viewModel: MoviesViewModel by viewModels()




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.tv_shows_fragment, container, false)
        binding = MoviesFragmentBinding.bind(view)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = MovieAdapter(ArrayList(), { movie ->
            Log.d ("Movie Click", movie, title)
        })


        binding.myRecycler.adapter = adapter
        binding.myRecycler.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)


        viewModel.getViewModelPopularMovies()
        viewModel.data.observe(viewLifecycleOwner) {
            adapter.updateMovies(it)
        }
    }
}
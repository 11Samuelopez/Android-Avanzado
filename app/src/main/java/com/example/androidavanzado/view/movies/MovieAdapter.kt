package com.example.androidavanzado.view

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.androidavanzado.R
import com.example.androidavanzado.model
import com.example.androidavanzado.model.MoviePresentation
import com.example.androidavanzado.modelNetwork
import com.example.androidavanzado.modelPresentation

classAdapter(private val data: ArrayList<MoviePresentation>
private val clickListener: (MoviePresentation)->(Unit)): RecyclerView.Adapter<MovieAdapter.MovieViewHolder>()
{

   inner class MovieViewHolder(itemView: View) RecyclerView.ViewHolder(itemView) {


    private val movieTextView = itemView.findViewById<TextView>(R.id.movie_title)
    private val movieImage = itemView.findViewById<ImageView>(R.id.movie_image)
    private val movieVoteCount = itemView.findViewById<TextView>(R.id.movie_vote_count)
    private val movieTextView = itemView.findViewById<TextView>(R.id.movie_original_lenguage)

}

        fun bind(movie:, position: Int){
            movieTextView.text = movie.title
            val imageUrl = "https://image.tmdb/t/p/w500/$(movie.posterPath)"
            Glide.with(movieImage.context).load(imageUrl).into(movieImage)
            movieVoteCount.text = movie.voteCount.toString()

        }
    }

    fun updateMovies(movie: List<MoviePresentation>){
        data.clear()
        data.addAll(movies)
        notifyDataSetChanged()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        //val binding = IteBinding.bind(view)

        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val element = data[position]
        holder.bind(element,position)

    }

    override fun getItemCount(): Int {
        return data.size
    }
}
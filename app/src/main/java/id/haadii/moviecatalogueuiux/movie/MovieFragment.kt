package id.haadii.moviecatalogueuiux.movie


import android.content.Intent
import android.content.res.TypedArray
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import id.haadii.moviecatalogueuiux.R
import kotlinx.android.synthetic.main.fragment_movie.*
import id.haadii.moviecatalogueuiux.DetailActivity

class MovieFragment : Fragment() {

    private lateinit var dataTitle : Array<String>
    private lateinit var dataDate: Array<String>
    private lateinit var dataOverview: Array<String>
    private lateinit var dataGenre: Array<String>
    private lateinit var dataRuntime: Array<String>
    private lateinit var dataPhoto: TypedArray
    private lateinit var movieAdapter: MovieAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        dataTitle = resources.getStringArray(R.array.data_title)
        dataDate = resources.getStringArray(R.array.data_release)
        dataOverview = resources.getStringArray(R.array.data_overview)
        dataGenre = resources.getStringArray(R.array.data_genre)
        dataRuntime = resources.getStringArray(R.array.data_runtime)
        dataPhoto = resources.obtainTypedArray(R.array.data_photo)

        movie_list.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(activity)
            movieAdapter = MovieAdapter(context!!, addItem()) {
                Toast.makeText(activity, it.title, Toast.LENGTH_SHORT).show()
                val intent = Intent(activity, DetailActivity::class.java)
                intent.putExtra("movie", it)
                startActivity(intent)
            }
            adapter = movieAdapter
        }

    }

    private fun addItem() : ArrayList<Movie> {
        val movies = ArrayList<Movie>()
        for (i in dataTitle.indices) {
            val movie = Movie(
                dataTitle[i],
                dataDate[i],
                dataOverview[i],
                dataGenre[i],
                dataRuntime[i],
                dataPhoto.getResourceId(i, -1)
            )
            movies.add(movie)
        }

        return movies
    }
}

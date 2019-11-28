package id.haadii.moviecatalogueuiux.tv_show


import android.content.Intent
import android.content.res.TypedArray
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import id.haadii.moviecatalogueuiux.R
import id.haadii.moviecatalogueuiux.tv_show.Tv
import id.haadii.moviecatalogueuiux.tv_show.TvShowAdapter
import kotlinx.android.synthetic.main.fragment_tv_show.*
import id.haadii.moviecatalogueuiux.DetailActivity

class TvShowFragment : Fragment() {

    private lateinit var dataTitle : Array<String>
    private lateinit var dataDate: Array<String>
    private lateinit var dataOverview: Array<String>
    private lateinit var dataGenre: Array<String>
    private lateinit var dataRuntime: Array<String>
    private lateinit var dataPhoto: TypedArray
    private lateinit var tvAdapter: TvShowAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tv_show, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        dataTitle = resources.getStringArray(R.array.data_title_tv)
        dataDate = resources.getStringArray(R.array.data_release_tv)
        dataOverview = resources.getStringArray(R.array.data_overview_tv)
        dataGenre = resources.getStringArray(R.array.data_genre_tv)
        dataRuntime = resources.getStringArray(R.array.data_runtime_tv)
        dataPhoto = resources.obtainTypedArray(R.array.data_photo_tv)

        tv_list.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(activity)
            tvAdapter = TvShowAdapter(context!!, addItem()) {
                Toast.makeText(activity, it.title, Toast.LENGTH_SHORT).show()
                val intent = Intent(activity, DetailActivity::class.java)
                intent.putExtra("tv", it)
                startActivity(intent)
            }
            adapter = tvAdapter
        }

    }

    private fun addItem() : ArrayList<Tv> {
        val tvs = ArrayList<Tv>()
        for (i in dataTitle.indices) {
            val movie = Tv(
                dataTitle[i],
                dataDate[i],
                dataOverview[i],
                dataGenre[i],
                dataRuntime[i],
                dataPhoto.getResourceId(i, -1)
            )
            tvs.add(movie)
        }

        return tvs
    }

}

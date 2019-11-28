package id.haadii.moviecatalogueuiux.tv_show

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import id.haadii.moviecatalogueuiux.R
import kotlinx.android.synthetic.main.item_movie.view.*

class TvShowAdapter (private val context: Context, private val tvs: ArrayList<Tv>, private val listener: (Tv) -> Unit) : RecyclerView.Adapter<TvShowAdapter.TvHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvHolder {
        return TvHolder(LayoutInflater.from(context).inflate(R.layout.item_tv, parent, false))
    }

    override fun getItemCount(): Int = tvs.size

    override fun onBindViewHolder(holder: TvHolder, position: Int) {
        holder.bindTv(context, tvs[position], listener)
    }

    inner class TvHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val tvTitle = view.tv_title
        private val tvDate = view.tv_date
        private val tvOverview = view.tv_overview
        private val imgPhoto = view.img_photo

        fun bindTv(context: Context, tv: Tv, listener: (Tv) -> Unit) {
            tvTitle.text = tv.title
            tvDate.text = tv.release
            tvOverview.text = tv.overview
            Glide.with(context)
                .load(tv.photo)
                .into(imgPhoto)

            itemView.setOnClickListener {
                listener(tv)
            }
        }
    }
}
package app.training.android.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import app.training.android.databinding.ItemNewsBinding
import app.training.android.model.NewsModel

class NewsAdapter(
    private val newsList: ArrayList<NewsModel>
): RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemNewsBinding): RecyclerView.ViewHolder(binding.root){
        init {
            //action when the item clicked
            binding.root.setOnClickListener {
                Toast.makeText(binding.root.context, "Item Clicked ${newsList[adapterPosition].title}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val binding = ItemNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        val news = newsList[position]
        with(holder.binding){
            tvTitle.text = news.title
            tvContent.text = news.content
            tvView.text = "Total Views : ${news.totalView}x"
        }
    }

    override fun getItemCount(): Int {
        return newsList.size
    }
}
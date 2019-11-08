package com.example.alalmsyah.youtubeapi.ui.main.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.alalmsyah.youtubeapi.R
import com.example.alalmsyah.youtubeapi.ui.main.Detail.DetailActivity
import com.example.alalmsyah.youtubeapi.ui.main.model.ItemsItem
import com.example.alalmsyah.youtubeapi.ui.main.model.Snippet
import kotlinx.android.synthetic.main.item_video.view.*

class YoutubeAdapter(private val data: List<ItemsItem?>?) : RecyclerView.Adapter<YoutubeAdapter.MyHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_video,parent,false)
        return MyHolder(view)
    }

    override fun getItemCount() = data?.size ?: 0


    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.onBind(data?.get(position)?.snippet)
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailActivity::class.java)
            intent.putExtra("idVideo", data?.get(position)?.id?.videoId)
            holder.itemView.context.startActivity(intent)

        }
    }

    class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun onBind(get: Snippet?) {
            Glide.with(itemView.context)
                .load(get?.thumbnails?.high?.url)
                .into(itemView.itemImage)
            itemView.itemLocation.text = get?.title
            itemView.itemNameLocation.text = get?.channelTitle
        }

    }
}
package com.example.hotumit.tomproject.adapter


import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.hotumit.tomproject.constant.Conts
import com.example.hotumit.tomproject.R
import com.example.hotumit.tomproject.adapter.viewholder.DessertViewHolder
import com.example.hotumit.tomproject.adapter.viewholder.MovieViewHolder
import com.example.hotumit.tomproject.dao.MovieItemDao
import com.example.hotumit.tomproject.utility.ClickListener



class MovieAdapter(private val androidList: List<MovieItemDao>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    companion object {
        public lateinit var clicklistener: ClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        Log.e("MovieViewType","MovieViewType"+viewType)
        if (viewType == Conts.Movie) {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.store_item_row, parent, false)
            return MovieViewHolder(view)
        }else if (viewType == Conts.Dessert) {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_article_featured, parent, false)
            return DessertViewHolder(view)
        }
        throw NullPointerException("View holder for type $viewType not found")
    }



    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        if (holder is MovieViewHolder) {
            (holder as MovieViewHolder).bind(androidList[position])
           /* (holder as MenuViewHolder).bind(androidList!![position])*/
        }
    }

    override fun getItemCount(): Int {
        return androidList.size
    }
    override fun getItemViewType(position: Int): Int {
      /*  if (position%2 ==0){
            return Conts.Dessert
        }else{

        }*/
        return androidList[position].type
    }
    fun setClickListener(listener: ClickListener) {
        clicklistener = listener
    }
}
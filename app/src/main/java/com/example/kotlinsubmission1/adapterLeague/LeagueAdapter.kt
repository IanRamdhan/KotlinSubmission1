package com.example.kotlinsubmission1.adapterLeague

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kotlinsubmission1.R
import com.example.kotlinsubmission1.Ui.DetailLeagueActitivity
import com.example.kotlinsubmission1.modelLeague.LeagueItemData
import kotlinx.android.synthetic.main.list_item.view.*
import org.jetbrains.anko.intentFor

class LeagueAdapter(
    private val context: Context,
    private val leagueItemData: List<LeagueItemData>, private val listener: (LeagueItemData) -> Unit
) : RecyclerView.Adapter<LeagueAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item, parent, false))
    }

    override fun getItemCount() = leagueItemData.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItemLeague(leagueItemData[position], listener)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindItemLeague(leagueItemData: LeagueItemData, listener: (LeagueItemData) -> Unit) {
            itemView.name_league.text = leagueItemData.leagueName
            Glide.with(itemView.context)
                .load(leagueItemData.leagueImage)
                .into(itemView.img_league)

            itemView.setOnClickListener {
                itemView.context.startActivity(
                    itemView.context.intentFor<DetailLeagueActitivity>(
                        "leagueName" to leagueItemData.leagueName,
                        "leagueDesc" to leagueItemData.leagueDesc,
                        "leagueImage" to leagueItemData.leagueImage
                    )
                )
            }
        }
        init {
            view.setOnClickListener {
                view.context.startActivity(view.context.intentFor<DetailLeagueActitivity>())
            }
        }
    }
}
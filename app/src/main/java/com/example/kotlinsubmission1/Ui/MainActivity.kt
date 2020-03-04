package com.example.kotlinsubmission1.Ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinsubmission1.R
import com.example.kotlinsubmission1.adapterLeague.LeagueAdapter
import com.example.kotlinsubmission1.modelLeague.LeagueItemData
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.*

class MainActivity : AppCompatActivity() {

    private val leagueDataItems : MutableList<LeagueItemData> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Menggunakan fungsi Anko Common Dialog
        val progressDialog = indeterminateProgressDialog("Mencari Data...")
        progressDialog.show()

        initData()

        progressDialog.dismiss()
        rv_league.layoutManager = LinearLayoutManager(this)
        rv_league.adapter = LeagueAdapter(this, leagueDataItems){
            toast("You choose ${it.leagueName}")
            startActivity(intentFor<DetailLeagueActitivity>("isSuccess" to true).clearTask())
        }

    }

    private fun initData(){
        val leagueName = resources.getStringArray(R.array.league_name)
        val leagueDesk = resources.getStringArray(R.array.desk_league)
        val leagueImage = resources.obtainTypedArray(R.array.images_league)

        leagueDataItems.clear()

        for (i in leagueName.indices){
            leagueDataItems.add(LeagueItemData(leagueName [i],
                leagueImage.getResourceId(i, 0),
                leagueDesk[i]))


        }
    }
}

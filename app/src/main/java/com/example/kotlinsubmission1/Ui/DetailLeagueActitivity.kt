package com.example.kotlinsubmission1.Ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.ImageView
import android.widget.TextView
import com.example.kotlinsubmission1.R
import kotlinx.android.synthetic.main.list_item.view.*
import org.jetbrains.anko.*

class DetailLeagueActitivity : AppCompatActivity() {

    lateinit var nameLeague : TextView
    lateinit var descLeague : TextView
    lateinit var imageLeague : ImageView

    var leagueName = ""
    var leagueDesc = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_league_actitivity)

        //Menerapkan Fungsi Anko Layout untuk DetailTeam
        verticalLayout {
            imageLeague = imageView {
                setImageResource(R.drawable.english_premier_league)
            }.lparams(300, 300){
                gravity = Gravity.CENTER
                topMargin = dip(20)
            }

            nameLeague = textView("English League"){
                textSize = 20f
            }.lparams(wrapContent, wrapContent){
                gravity = Gravity.CENTER
                margin = dip(15)
            }

            descLeague = textView ("English League is a piece of League"){
                textSize = 15f
            }.lparams(wrapContent, wrapContent){
                gravity = Gravity.CENTER
                margin = dip(15)
            }
        }

        //getIntent
        val i = intent
        leagueName = i.getStringExtra("leagueName")
        leagueDesc = i.getStringExtra("leagueDesc")

        //Set Data
        nameLeague.text = leagueName
        descLeague.text = leagueDesc
        imageLeague.setImageResource(i.getIntExtra("leagueImage", R.drawable.english_premier_league))


    }
}

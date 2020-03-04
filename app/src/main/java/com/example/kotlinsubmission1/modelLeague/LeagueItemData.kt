package com.example.kotlinsubmission1.modelLeague

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

//Membuat Model untuk Menampung Data Sementara
@Parcelize
data class LeagueItemData(val leagueName: String?,
                     val leagueImage: Int?,
                     val leagueDesc: String?) : Parcelable {
}
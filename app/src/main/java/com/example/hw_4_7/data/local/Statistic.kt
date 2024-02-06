package com.example.hw_4_7.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "statistic")
data class Statistic(
    @PrimaryKey(autoGenerate = true)
    var id:Int?=null,
    val status:String?=null,
    val difficulty:String?=null,
    val mistakes:String?=null,
    val result:String?=null,
):Serializable

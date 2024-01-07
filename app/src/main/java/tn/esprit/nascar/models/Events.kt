package tn.esprit.nascar.models

import androidx.annotation.DrawableRes
import androidx.room.Entity
import androidx.room.PrimaryKey

//TODO 8 Change this class to a data class with Entity annotation and the val id to PrimaryKey with auto generation
@Entity(tableName = "eventTable")
data class Events(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    @DrawableRes
    val imageRes:Int,

    val title: String,

    val description: String,
)
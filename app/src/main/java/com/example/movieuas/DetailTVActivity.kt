package com.example.movieuas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.movieuas.model.TV
import kotlinx.android.synthetic.main.activity_tvdetail.*

class DetailTVActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_TvS = "extra_tvs"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tvdetail)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        img_item_photo.clipToOutline = true

        val detailTvs = intent.getParcelableExtra<TV>(DetailTVActivity.EXTRA_TvS)

        if (detailTvs != null){
            val IMAGE_BASE = "https://image.tmdb.org/t/p/w500/"
            Glide.with(this).load(IMAGE_BASE + detailTvs.poster).into(img_item_photo)
            tv_item_name.text = detailTvs.title
            tv_item_description.text = detailTvs.overview

        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}

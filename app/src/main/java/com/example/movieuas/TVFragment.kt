package com.example.movieuas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movieuas.model.TV
import com.example.movieuas.model.TVResponse
import com.example.movieuas.service.TVApiInterface
import com.example.movieuas.service.TVApiService
import kotlinx.android.synthetic.main.fragment_t_v.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response



class TVFragment : Fragment() {
    private val tv = arrayListOf<TV>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_t_v, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv_television_list.layoutManager = LinearLayoutManager(this.context)
        rv_television_list.setHasFixedSize(true)
        getTVData { tv : List<TV> ->
           rv_television_list.adapter = TVAdapter(tv)
        }
        showRecyclerView()
    }

    private fun getTVData(callback: (List<TV>) -> Unit){
        val apiService = TVApiService.getInstance().create(TVApiInterface::class.java)
        apiService.getTVList().enqueue(object : Callback<TVResponse> {
            override fun onFailure(call: Call<TVResponse>, t: Throwable) {

            }

            override fun onResponse(call: Call<TVResponse>, response: Response<TVResponse>) {
                return callback(response.body()!!.tv)
            }

        })
    }

    private fun showRecyclerView() {
        rv_television_list.layoutManager = LinearLayoutManager(this.context)
        rv_television_list.adapter = TVAdapter(tv)
    }

}
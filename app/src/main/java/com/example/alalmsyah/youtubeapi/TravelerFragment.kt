package com.example.alalmsyah.youtubeapi


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.alalmsyah.youtubeapi.ui.main.adapter.YoutubeAdapter
import com.example.alalmsyah.youtubeapi.ui.main.model.ItemsItem
import com.example.alalmsyah.youtubeapi.ui.main.model.ResultYoutube
import com.example.alalmsyah.youtubeapi.ui.main.network.NetworkConfig
import kotlinx.android.synthetic.main.fragment_sports.*
import retrofit2.Call
import retrofit2.Response

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

/**
 * A simple [Fragment] subclass.
 *
 */
class TravelerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_sports, container, false);

        NetworkConfig.service()
            .getVideo("snippet","traveler","AIzaSyCstJrQ44amIu86SjTdCuHnKBTO9bM4IyE")
            .enqueue(object : retrofit2.Callback<ResultYoutube>{
                override fun onFailure(call: Call<ResultYoutube>, t: Throwable) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun onResponse(call: Call<ResultYoutube>, response: Response<ResultYoutube>) {
                    if (response.isSuccessful){
                        showData(response.body()?.items)
                    }
                }

            })
        return view
    }

    private fun showData(items: List<ItemsItem?>?) {
        rvSports.adapter = YoutubeAdapter(items)
    }


}

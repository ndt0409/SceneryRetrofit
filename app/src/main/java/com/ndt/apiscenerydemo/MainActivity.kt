package com.ndt.apiscenerydemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.ndt.apiscenery.adapter.SceneryAdapter
import com.ndt.apiscenery.model.Scenery
import com.ndt.apiscenery.network.SceneryClient
import com.ndt.apiscenerydemo.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var list = arrayListOf<Scenery>()
    private lateinit var adapter: SceneryAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = SceneryAdapter(list, this)
        binding.rvScenery.adapter = adapter
        binding.rvScenery.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        getAllScenery()
    }

    fun getAllScenery() {
        lifecycleScope.launch(Dispatchers.IO) {
            var response: Response<List<Scenery>> = SceneryClient().getAllSecenery().execute()
            if (response.isSuccessful) {
                response.body()?.let {
                    list.addAll((it))
                }
                withContext(Dispatchers.Main) {
                    adapter.notifyDataSetChanged()
                }
            }
        }
    }
}
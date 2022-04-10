package com.example.teslivecodinglawencon

import android.graphics.Color
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.teslivecodinglawencon.base.BaseActBinding
import com.example.teslivecodinglawencon.databinding.MyLayoutBinding
import com.example.teslivecodinglawencon.utils.Resouce
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActBinding<MyLayoutBinding>() {

    override fun layout(): Int = R.layout.my_layout
    private val vModel : ViewModelRestorant by viewModels()
    lateinit var restorantAdapter : AdapterRestorant

    override fun mainCode() {
        b.collpased.setStatusBarScrimColor(Color.TRANSPARENT)
        initAdapter()
        setData()
    }

    private fun initAdapter() {
        restorantAdapter = AdapterRestorant { data: String -> onItemClick(data) }
        b.apply {
            rvRestorant.apply {
                adapter = restorantAdapter
                layoutManager = LinearLayoutManager(this@MainActivity)
            }
        }
    }

    private fun setData() {
        vModel.dataRestoran.observe(this@MainActivity){
            restorantAdapter.submitList(it.data)
            b.pBar.isVisible = it is Resouce.LOAD && it.data.isNullOrEmpty()
            b.tvStatus.isVisible = it is Resouce.ERROR && it.data.isNullOrEmpty()
//            b.tvStatus.text = it.msg
            b.tvStatus.text = "bad connection"
        }
    }

    private fun onItemClick(data : String){
        Toast.makeText(applicationContext, data, Toast.LENGTH_SHORT).show()
    }
}
package com.example.recyclerviewdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.view.View
import androidx.appcompat.app.ActionBar
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewdemo.adapters.DataModel
import kotlinx.android.synthetic.main.activity_main.*
import com.example.recyclerviewdemo.adapters.ItemAdapters

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var actionBar = supportActionBar
        actionBar!!.setDisplayShowHomeEnabled(true)
        actionBar!!.setDisplayHomeAsUpEnabled(true)
        actionBar.setHomeAsUpIndicator(R.drawable.ic_back_arrow)
        actionBar.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM
        actionBar!!.setCustomView(R.layout.center_app_name)
        //Set the layout Manager
        reViewListProduct.layoutManager = LinearLayoutManager(this)

        //Adapter class is initialized and list is passed in the param
        val itemAdapter = ItemAdapters(this, getItemList())

        //Adapter instance is set
        reViewListProduct.adapter = itemAdapter
    }

    private fun getItemList():ArrayList<DataModel>
    {
        val list = ArrayList<DataModel>()
        list.add(DataModel(R.drawable.pixel6,"Mua bán có tâm",8000.0,
            ItemAdapters.CLOSE_GROUP,ItemAdapters.NEW_POSTS_10))
        list.add(DataModel(R.drawable.hot_pot,"Ăn để lăn", 8000.0,
            ItemAdapters.PRIVATE_GROUP,"+ 10 new posts"))
        list.add(
            DataModel(R.drawable.baby,"Chia sẻ kiến thức tài liệu Montessori", 1700.0,
            ItemAdapters.PUBLIC_GROUP,ItemAdapters.NEW_POSTS_10)
        )
        list.add(
            DataModel(R.drawable.diet_meal,"Thực đơn Eat-Clean giảm cân khỏe đẹp", 11000.0,
        ItemAdapters.PUBLIC_GROUP,ItemAdapters.NEW_POSTS_20)
        )
        list.add(
            DataModel(R.drawable.easy_keto,"Easy Keto for bust people",8000.0,
            ItemAdapters.PRIVATE_GROUP, ItemAdapters.NEW_POSTS_10)
        )

        list.add(
            DataModel(R.drawable.offb, "OFFB",8000.0,
            ItemAdapters.PUBLIC_GROUP, ItemAdapters.NEW_POSTS_10)
        )

        list.add(
            DataModel(R.drawable.diet_meal,"Thực đơn Eat-Clean giảm cân khỏe đẹp", 11000.0,
                ItemAdapters.PUBLIC_GROUP,ItemAdapters.NEW_POSTS_20)
        )
        list.add(
            DataModel(R.drawable.easy_keto,"Easy Keto for bust people",8000.0,
                ItemAdapters.PRIVATE_GROUP, ItemAdapters.NEW_POSTS_10)
        )

        return list
    }
}
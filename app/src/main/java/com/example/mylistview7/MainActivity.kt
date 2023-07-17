package com.example.mylistview7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
//	val data = listOf("Apple", "Banana", "Orange")
	val fruitList = ArrayList<Fruit>()

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		initFruits()

		val adpater = FruitAdapter(this, R.layout.fruit_item, fruitList)

		val listView: ListView = findViewById(R.id.listView)
		listView.adapter = adpater
		listView.setOnItemClickListener { parent, view, position, id ->
			val fruit = fruitList[position]
			Toast.makeText(this, fruit.name, Toast.LENGTH_SHORT).show()
		}
	}

	private fun initFruits() {
		repeat(100) {
			fruitList.add(Fruit("apple", R.drawable.apple_pic))
			fruitList.add(Fruit("Banana", R.drawable.banana_pic))
			fruitList.add(Fruit("Pear", R.drawable.pear_pic))
		}
	}
}
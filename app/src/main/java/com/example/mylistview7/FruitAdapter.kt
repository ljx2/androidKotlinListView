package com.example.mylistview7

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class FruitAdapter(val activity: Activity, val resourceId: Int, val data: List<Fruit>):
	ArrayAdapter<Fruit>(activity, resourceId, data){
	inner class ViewHolder(val fruitName: TextView, val fruitImage: ImageView)
	override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
		val view: View
		val viewHolder: ViewHolder

		if (convertView == null) {
			view = LayoutInflater.from(context).inflate(resourceId, parent, false)

			val fruitName: TextView = view.findViewById(R.id.fruitName)
			val fruitImage: ImageView = view.findViewById(R.id.fruitImage)
			viewHolder = ViewHolder(fruitName, fruitImage)
			view.tag = viewHolder
		} else {
			view = convertView
			viewHolder = view.tag as ViewHolder
		}

		val fruit = getItem(position)
		if (fruit != null) {
			viewHolder.fruitImage.setImageResource(fruit.imageId)
			viewHolder.fruitName.text = fruit.name
		}
		return view
	}
}
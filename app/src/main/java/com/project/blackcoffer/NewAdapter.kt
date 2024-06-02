package com.project.blackcoffer

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.recyclerview.widget.RecyclerView

//FOR HORIZONTAL RECYCLERVIEW
class NewAdapter(private var arrayList: ArrayList<ItemsInfo>, var context: Activity) : RecyclerView.Adapter<NewAdapter.MyViewHolder>() {
    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        val appLogo: ImageButton? = itemView.findViewById(R.id.appIcons)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.app_item,parent,false)
        return MyViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = arrayList[position]
        holder.appLogo?.setImageResource(currentItem.appLogo)
        holder.itemView.findViewById<ImageButton>(R.id.appIcons).setOnClickListener {
            val url = currentItem.appLink
            val context = holder.itemView.context
            val intent = Intent(context,WebActivity::class.java)
            intent.putExtra("socialMediaUrl",url)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }


}
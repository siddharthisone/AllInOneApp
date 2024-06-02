package com.project.blackcoffer

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView

class CardAdapter(private var arrayList: ArrayList<ItemsInfo>, var context: Activity):RecyclerView.Adapter<CardAdapter.CardViewHolder>() {
    class CardViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView) {
        val appLogo: ImageButton? = itemView.findViewById(R.id.appCardLogo)
        val appName: TextView? = itemView.findViewById(R.id.appName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.app_item_cards,parent,false)
        return CardViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {

        val currentItem = arrayList[position]
        holder.appName?.text = currentItem.appName
        holder.appLogo?.setImageResource(currentItem.appLogo)

        holder.itemView.findViewById<CardView>(R.id.cards).setOnClickListener{

            val url = currentItem.appLink
            val context = holder.itemView.context
            val intent = Intent(context,WebActivity::class.java)
            intent.putExtra("socialMediaUrl",url)
            context.startActivity(intent)

        }
    }

    override fun getItemCount(): Int {
           return   arrayList.size
    }
}

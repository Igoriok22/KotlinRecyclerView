package com.example.iostr.kotlinrecyclerview

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import java.util.zip.Inflater

/**
 * Created by iostr on 2/13/2018.
 */
class PeopleAdapter(val peaple : List<Person>, val activity : MainActivity): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    interface FragmentCallBack{

        fun setPerson( person : Person)

    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.itemview,parent,false)
        return PeapleViewHolder(view)

    }

    override fun getItemCount(): Int {
       return peaple.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {

        val text1 =  holder?.itemView?.findViewById<TextView>(R.id.textView)
        val text2 = holder?.itemView?.findViewById<TextView>(R.id.textView2)

       text1?.text = peaple.get(position).name
       text2?.text = peaple.get(position).age.toString()

        text1?.setOnClickListener{

            activity.setPerson(peaple.get(position))
        }
    }

    class PeapleViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView)
}
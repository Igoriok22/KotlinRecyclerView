package com.example.iostr.kotlinrecyclerview

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

/**
 * Created by iostr on 2/13/2018.
 */
class PeopleAdapter(val people: List<Person>, val listener: PersonSelectionListener): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.itemview,parent,false)
        return PeopleViewHolder(view)

    }

    override fun getItemCount(): Int {
       return people.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {

        val text1 =  holder?.itemView?.findViewById<TextView>(R.id.textView)
        val text2 = holder?.itemView?.findViewById<TextView>(R.id.textView2)

       text1?.text = people.get(position).name
       text2?.text = people.get(position).age.toString()

        text1?.setOnClickListener{

            listener.setPerson(people.get(position))
        }
    }

    class PeopleViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView)
}
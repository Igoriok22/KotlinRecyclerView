package com.example.iostr.kotlinrecyclerview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.ActionBar
import android.support.v7.widget.LinearLayoutManager
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() , PeopleAdapter.FragmentCallBack {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val people = ArrayList<Person>()

        people.add(Person("Igor", 28))
        people.add(Person("Sasha", 32))
        people.add(Person("Kolya", 20))
        people.add(Person("Yura", 15))
        people.add(Person("Yulja", 45))

        val adapter = PeopleAdapter(people, this)

        recyclerview.adapter = adapter
        recyclerview.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

    }

    override fun setPerson(person: Person) {
        val personFragment = PersonFragment.newInstance(person.name, person.age)
        supportFragmentManager.beginTransaction().replace(R.id.container, personFragment).addToBackStack("PersonFragment").commit()
    }

    override fun onSupportNavigateUp(): Boolean {

        supportFragmentManager.popBackStack()

        return super.onSupportNavigateUp()
    }
}

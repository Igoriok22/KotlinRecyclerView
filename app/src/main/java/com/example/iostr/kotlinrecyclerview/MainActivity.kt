package com.example.iostr.kotlinrecyclerview

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.ActionBar
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() , PersonSelectionListener {


    var personFragment : PersonFragment? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val people = ArrayList<Person>()

        people.add(Person("Igor", 28, listOf("Ноут","Машина")))
        people.add(Person("Sasha", 32, listOf("Кружка")))
        people.add(Person("Kolya", 20, listOf("Чайник")))
        people.add(Person("Yura", 15, listOf("Дріт", "Пакет")))
        people.add(Person("Yulja", 45, listOf("Щур")))

        people.groupBy { it.name }

        fun List<Person>.getListThings():List<String>{
            return this.filter { it.sings[0].equals("")}.flatMap { it.sings }
        }


        fun List<Person>.sumOfYears():Int {
            var sum :Int = 0
            for( args in this){
                sum += args.age
            }
            return sum
        }

        fun Person.exit() = "$name $age"

        Log.d("TAG", people.getListThings().toString())

        val adapter = PeopleAdapter(people.sortedBy { it.name }, this)

        recyclerview.adapter = adapter
        recyclerview.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        constrainlayout.setBackgroundColor(Color.GRAY)

    }

    override fun setPerson(person: Person) {
         personFragment = PersonFragment.newInstance(person.name, person.age)
        supportFragmentManager.beginTransaction().replace(R.id.container, personFragment).addToBackStack("PersonFragment").commit()
    }

    override fun onSupportNavigateUp(): Boolean {

        supportFragmentManager.beginTransaction().remove(personFragment).commit()

        return super.onSupportNavigateUp()
    }
}

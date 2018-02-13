package com.example.iostr.kotlinrecyclerview

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.person_fragment.*
import kotlinx.android.synthetic.main.person_fragment.view.*

/**
 * Created by iostr on 2/13/2018.
 */
class PersonFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.person_fragment,container,false)

        view.textviewname.text = arguments?.getString("name")

        view.textvieage.text = arguments?.getInt("age").toString()

        return view
    }



    companion object {
        fun newInstance(name: String,  age : Int):PersonFragment{

            val personFragment = PersonFragment()

            val bundle = Bundle()

            bundle.putString("name",name)
            bundle.putInt("age",age)

            personFragment.arguments = bundle

            return personFragment
        }
    }
}

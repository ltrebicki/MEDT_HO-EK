package com.example.kotlin_ek3

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.kotlin_ek3.databinding.FragmentAboutAutorBinding
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_about_autor.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [AboutAutorFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [AboutAutorFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AboutAutorFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentAboutAutorBinding>(
            inflater,
            R.layout.fragment_about_autor, container, false
        )
        binding.buttonAutor.setOnClickListener {
            Snackbar.make(
                buttonAutor,
                "Autor: Lukas Trebicki",
                Snackbar.LENGTH_LONG
            ).setAction("Schliessen"){}.setActionTextColor(resources.getColor(R.color.colorAccent)).show()
        }
        // Inflate the layout for this fragment
        return binding.root
    }
}

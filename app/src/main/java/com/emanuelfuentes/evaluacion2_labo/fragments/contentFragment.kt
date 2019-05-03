package com.emanuelfuentes.evaluacion2_labo.fragments

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.emanuelfuentes.evaluacion2_labo.R
import kotlinx.android.synthetic.main.fragment_content.view.*

class contentFragment : Fragment(){

    private var content: String? = null

    private var listener: OnFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            content = it.getString(Companion.ARG_CONTENT)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_content, container, false).apply {
            tv_content_frag.text = content
        }
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }


    interface OnFragmentInteractionListener {
        fun onFragmentInteraction(uri: Uri)
    }

    companion object {
        @JvmStatic
        fun newInstance(content: String) =
            contentFragment().apply {
                arguments = Bundle().apply {
                    putString(Companion.ARG_CONTENT, content)
                }
            }

        private const val ARG_CONTENT = "Content"
    }

}
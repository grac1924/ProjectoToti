package com.grac.projectototi

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment

class InicioFragment() : Fragment() {
    private lateinit var et: EditText
    private lateinit var button: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_inicio, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        et = view.findViewById(R.id.ed_dsn)
        button = view.findViewById(R.id.bt_entre)
        button.setOnClickListener {
            val name = et.text.toString()
            if (name.isBlank()) {
                context?.let { valor ->
                    showErrorMessage(valor)
                }
            } else {
                val tarefasFragment = newInstance()
                parentFragmentManager.beginTransaction()
                    .replace(R.id.fcv_main_activity, tarefasFragment)
                    .addToBackStack(null)
                    .commit()
            }
        }
    }

    private fun showErrorMessage(context: Context) {
        val errorMessage = context.getString(R.string.errorMessage)
        Toast.makeText(context, errorMessage, Toast.LENGTH_SHORT).show()
    }

    companion object{
        fun newInstance(): InicioFragment {
            return InicioFragment()
        }
    }
}


package com.hftamayo.kotlincrudsqlite

import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class StudentAdapter : RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {
    class StudentViewHolder(view: View) : RecyclerView.ViewHolder(view){
        private var id = view.findViewById<TextureView>(R.id.tvId)
        private var name = view.findViewById<TextureView>(R.id.tvName)
        private var email = view.findViewById<TextureView>(R.id.tvEmail)
        private var btnDelete = view.findViewById<TextureView>(R.id.btnDelete)
        fun bindView(std:StudentModel){
            id.text = std.id.toString()
            name.text = std.name
            email.text = std.email

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}
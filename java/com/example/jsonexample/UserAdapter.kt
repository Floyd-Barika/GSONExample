package com.example.jsonexample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.jsonexample.Model.UserModelClass

class UserAdapter(val userList: MutableList<UserModelClass>):RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    inner class UserViewHolder(view: View):RecyclerView.ViewHolder(view){
        val id = view.findViewById<TextView>(R.id.txt_user_id)
        val name = view.findViewById<TextView>(R.id.txt_user_name)
        val email = view.findViewById<TextView>(R.id.txt_user_email)
        val gender = view.findViewById<TextView>(R.id.txt_user_gender)
        val weight = view.findViewById<TextView>(R.id.txt_user_weight)
        val height = view.findViewById<TextView>(R.id.txt_user_height)
        val mobileNumber = view.findViewById<TextView>(R.id.txt_mobile_number)
        val officeNumber = view.findViewById<TextView>(R.id.txt_office_number)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(LayoutInflater
                .from(parent.context)
                .inflate(R.layout.user_preview, parent,false))
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = userList[position]

        holder.id.text = user.id.toString()
        holder.name.text = user.name
        holder.email.text = user.email
        holder.gender.text = user.gender
        holder.weight.text = user.weight.toString()
        holder.height.text = user.height.toString()
        holder.mobileNumber.text = user.phone.mobileNumber
        holder.officeNumber.text = user.phone.officeNumber
    }

    override fun getItemCount(): Int = userList.size
}
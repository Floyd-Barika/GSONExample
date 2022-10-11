package com.example.jsonexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jsonexample.Model.UserModelClass
import com.example.jsonexample.Model.Users
import com.google.gson.Gson
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException
import java.nio.charset.Charset

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclotron = findViewById<RecyclerView>(R.id.recycler_view)

        try{
            val obj = openAndReadJSON()!!
           val users = Gson().fromJson(obj, Users::class.java)

            recyclotron.layoutManager = LinearLayoutManager(this)
            val adapter = UserAdapter(users.users)
            recyclotron.adapter = adapter
        }
        catch (e:JSONException){
            e.printStackTrace()
        }
    }

    private fun openAndReadJSON():String?{
        var json:String? = null
        val charSet: Charset = Charsets.UTF_8

        try{
            val openedFile = assets.open("Users.json")
            val size = openedFile.available() //gets the number of readable bytes in the folder
            val buffer = ByteArray(size) //saves the number of readable bytes in an array
            openedFile.read(buffer) //reads bytes specified from the opened file into the array (buffer, in this case). It reads the same number of bytes as buffer has as its size
            json = String(buffer, charSet) // converts the bytes in buffer to characters using the characters stored in charSet
            openedFile.close()
        }catch (ex: IOException){
            ex.printStackTrace()
            return null
        }

        return json
    }
}
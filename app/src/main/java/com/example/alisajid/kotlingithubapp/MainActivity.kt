package com.example.alisajid.kotlingithubapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.alisajid.kotlingithubapp.model.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofit = Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        val service: GithubService = retrofit.create(GithubService::class.java)

        val call = service.getUser("willbrom")
        call.enqueue(object: Callback<User> {
            /**
             * Invoked for a received HTTP response.
             *
             *
             * Note: An HTTP response may still indicate an application-level failure such as a 404 or 500.
             * Call [Response.isSuccessful] to determine if the response indicates success.
             */
            override fun onResponse(call: Call<User>?, response: Response<User>?) {
                if (response?.body() != null) {
                    Log.d("TAG", response.body().toString())
                }
            }

            /**
             * Invoked when a network exception occurred talking to the server or when an unexpected
             * exception occurred creating the request or processing the response.
             */
            override fun onFailure(call: Call<User>?, t: Throwable?) {
                Log.d("TAG", call?.toString())
            }
        })
    }
}

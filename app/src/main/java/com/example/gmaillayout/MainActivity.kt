package com.example.gmaillayout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gmaillayout.adapters.EmailAdapter
import com.example.gmaillayout.models.Email

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Dữ liệu giả cho danh sách email
        val emailList = listOf(
            Email("Alice Tran", "Exclusive Deal", "Get 50% off on all items today only...", "9:15 AM", R.drawable.ic_email),
            Email("Discord", "Community Survey", "Share your feedback and shape our future...", "8:42 AM", R.drawable.ic_email),
            Email("Coursera", "New Free Courses", "Expand your skills with our latest courses...", "7:30 AM", R.drawable.ic_email),
            Email("Microsoft", "Security Update", "Important security improvements to protect your account...", "6:50 AM", R.drawable.ic_email)

        )

        recyclerView.adapter = EmailAdapter(emailList)
    }
}
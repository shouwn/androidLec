package net.skhu.e01button.firebase

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_e03_firebase.*
import net.skhu.e01button.R

class E03Firebase : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_e03_firebase)

        val myData01 = FirebaseDatabase.getInstance().getReference("myData01")
                .apply {
                    this.addValueEventListener(object: ValueEventListener {
                        override fun onDataChange(dataSnapshot: DataSnapshot) {
                            textView.text = dataSnapshot.getValue(String::class.java)
                        }

                        override fun onCancelled(error: DatabaseError) {
                            Log.e("내태그", "서버 에러: ", error.toException())
                        }
                    })
                }

        btnSaveIntoServer.setOnClickListener {
            myData01.setValue(editText.text.toString())
        }

    }
}

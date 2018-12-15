package net.skhu.example.firebase.recyclerView

import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class FirebaseDbService(
        val myRecyclerViewAdapter: MyRecyclerViewAdapter,
        val itemList: ItemList,
        private val userId: String,
        referencePath: String = "myServerData04",
        private val databaseReference: DatabaseReference =
                FirebaseDatabase.getInstance().getReference(referencePath)
) : ChildEventListener {

    init {
        databaseReference.child(userId).addChildEventListener(this)
    }

    fun addIntoServer(item: Item) {
        val key: String = this.databaseReference.child(userId).push().key!!
        databaseReference.child(userId).child(key).setValue(item)
    }

    fun removeFromServer(key: String) {
        databaseReference.child(userId).child(key).removeValue()
    }

    fun updateInServer(index: Int) {

    }
}
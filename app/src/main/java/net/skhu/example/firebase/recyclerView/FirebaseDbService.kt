package net.skhu.example.firebase.recyclerView

import android.support.v7.widget.RecyclerView
import android.util.Log
import com.google.firebase.database.*

class FirebaseDbService(
        private val recyclerViewAdapter: RecyclerView.Adapter<out RecyclerView.ViewHolder>,
        private val itemList: ItemList<Item>,
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
        val key = itemList.getKey(index)
        val item = itemList.getItem(index)
        databaseReference.child(userId).child(key).setValue(item)
    }

    override fun onChildAdded(dataSnapshot: DataSnapshot, previousChildName: String?) {
        val key = dataSnapshot.key!!
        val item = dataSnapshot.getValue<Item>(Item::class.java)!!

        val index = itemList.add(key, item)

        Log.i("FirebaseDbService: ", "${index}에 ${item.title}가 추가됨")

        recyclerViewAdapter.notifyItemInserted(index)
    }

    override fun onChildChanged(dataSnapshot: DataSnapshot, previousChildName: String?) {
        val key = dataSnapshot.key!!
        val item = dataSnapshot.getValue(Item::class.java)!!

        val index = itemList.update(key, item)

        recyclerViewAdapter.notifyItemChanged(index)
    }

    override fun onChildRemoved(dataSnapshot: DataSnapshot) {
        val key = dataSnapshot.key!!
        val index = itemList.remove(key)

        recyclerViewAdapter.notifyItemRemoved(index)
    }

    override fun onChildMoved(p0: DataSnapshot, p1: String?) {

    }

    override fun onCancelled(databaseError: DatabaseError) {
        Log.e("Firebase Error", databaseError.message)
    }
}
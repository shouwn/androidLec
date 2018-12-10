package net.skhu.e01button

import com.google.firebase.database.*

class FirebaseDbService(
        val recyclerViewAdapter: E06RecyclerViewAdapter,
        val itemList: ItemList,
        var userId: String
) : ChildEventListener {
    var databaseReference: DatabaseReference = FirebaseDatabase.getInstance().getReference("myServerData04").apply {
        child(userId).addChildEventListener(this@FirebaseDbService)
    }

    fun addIntoServer(item: Item) {
        databaseReference.child(userId).apply {
            child(push().key!!).setValue(item)
        }
    }

    fun removeFromServer(key: String) {
        databaseReference.child(userId).child(key).removeValue()
    }

    fun updateInServer(index: Int) {
        val key: String = itemList.getKey(index)
        val item: Item = itemList.get(index)

        databaseReference.child(userId).child(key).setValue(item)
    }

    override fun onChildAdded(dataSnapshot: DataSnapshot, previousChildName: String?) {
        val key: String = dataSnapshot.key!!
        val item: Item = dataSnapshot.getValue(Item::class.java)!!

        databaseReference.child(userId).child(key).setValue(item)
    }

    override fun onChildChanged(dataSnapshot: DataSnapshot, previousChildName: String?) {
        val key: String = dataSnapshot.key!!
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
        Log.e("Firebase Error")
    }
}
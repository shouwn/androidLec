package net.skhu.example.firebase.recyclerView

class ItemList : ArrayList<Pair<String, Item>>(){

    fun getItem(index: Int) =
            this[index].second

    fun getKey(index: Int) =
            this[index].first

    fun getCheckedCount() =
            this.count { it.second.checked }

    private fun findIndex(key: String) =
            this.withIndex().find { it.value.first == key }?.index ?: -1

    fun remove(key: String) =
            this.removeAt(findIndex(key))

    fun add(key: String, item: Item) {
        this.add(Pair(key, item))
    }

    fun update(key: String, item: Item) {
        this[findIndex(key)] = Pair(key, item)
    }
}
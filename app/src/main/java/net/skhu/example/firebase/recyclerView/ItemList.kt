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
            findIndex(key).also {
                this@ItemList.removeAt(it)
            }

    fun add(key: String, item: Item): Int {
        this.add(Pair(key, item))
        return this.size - 1
    }

    fun update(key: String, item: Item): Int =
        findIndex(key).also {
            this@ItemList[it] = Pair(key, item)
        }
}
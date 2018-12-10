package net.skhu.e01button

class ItemList{

    private val keys = mutableListOf<String>()

    private val items = mutableListOf<Item>()

    fun get(index: Int) =
            items[index]

    fun getKey(index: Int) =
            keys[index]

    fun size() =
            keys.size

    fun getCheckedCount() =
            items.count { it.checked }

    fun findIndex(key: String) =
            keys.withIndex()
                    .find { it.value == key }
                    ?.index ?: -1

    fun remove(key: String) =
            this.findIndex(key).also {
                keys.removeAt(it)
                items.removeAt(it)
            }

    fun add(key: String, item: Item): Int {
        keys.add(key)
        items.add(item)
        return items.size - 1
    }

    fun update(key: String, item: Item) =
            this.findIndex(key).also {
                items[it] = item
            }


}
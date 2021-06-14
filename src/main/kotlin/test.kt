import java.util.*

object Cases {
    fun in_place_list_creation(i: String): Boolean = i in mutableListOf<String>().also { it.addAll(words) }
    fun static_list(i: String): Boolean = i in words
    fun static_interned_list(i: String): Boolean = i in internedWords
    fun list_to_set(i: String): Boolean = i in words.toHashSet()
    fun static_set(i: String): Boolean = i in wordsSet
    fun static_list_iterator(i: String): Boolean {
        words.forEach {
            if (it == i) return true
        }
        return false
    }
    fun static_interned_list_iterator(i: String): Boolean {
        val j = i.intern()
        internedWords.forEach {
            if (it === j) return true
        }
        return false
    }

    fun static_interned_list_classic_for(i: String): Boolean {
        val j = i.intern()
        var k = 0
        val last = internedWords.size
        while (k != last) {
            if (internedWords[k] === j) return true
            k++
        }
        return false
    }

    fun static_list_classic_for(i: String): Boolean {
        var k = 0
        val last = words.size
        while (k != last) {
            if (internedWords[k] == i) return true
            k++
        }
        return false
    }
}

val words = (0..100).map { UUID.randomUUID().toString() }
val wordsSet = words.toHashSet()
val internedWords = words.map { it.intern() }

val inputWords = words.toMutableList().also {
    it.addAll((0..100).map { UUID.randomUUID().toString() })
}.also {
    it.shuffle()
}
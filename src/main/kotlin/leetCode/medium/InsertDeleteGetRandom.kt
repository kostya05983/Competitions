package leetCode.medium

class RandomizedSet() {
    private val hashSet = HashSet<Int>()


    fun insert(`val`: Int): Boolean {
        return hashSet.add(`val`)
    }

    fun remove(`val`: Int): Boolean {
        return hashSet.remove(`val`)
    }

    fun getRandom(): Int {
        return hashSet.random()
    }

}
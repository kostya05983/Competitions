package geeks.For.geeks.hashing

/**
 * Итерируемся сквозь массив, получается что-то вроде скользящего окна
 * размером k, если мы ушли дальше, мы удаляем эелемнт из хеша
 */
class DuplicateElementsArray {

    fun solve(k: Int, array: IntArray): Boolean {
        val hash = HashSet<Int>()

        for (i in 0 until array.size) {
            if (hash.contains(array[i])) {
                return true
            } else {
                hash.add(array[i])
                if (i > k) {
                    hash.remove(array[i - k])
                }
            }
        }
        return false
    }
}
package structures

class HashMap<K, V> {

    private class MapNode<K, V> {
        val key: K
        var value: V
        var next: MapNode<K, V>? = null

        constructor(key: K, value: V) {
            this.key = key
            this.value = value
        }
    }

    /**
     * The bucket array where the nodes contains K-V pairs are stored
     */
    private var buckets = ArrayList<MapNode<K, V>?>()

    /**
     * Pairs of stored - n
     */
    private var size: Int = 0

    // Size of the bucketArray - b
    private var numBuckets: Int = 0

    private val DEFAULT_LOAD_FACTOR = 0.75

    constructor() {
        numBuckets = 5

        buckets = ArrayList(numBuckets)

        for (i in 0 until numBuckets) {
            buckets.add(null)
        }
    }

    /**
     * Get buckets index use hash function of key and mod by num of buckets
     */
    private fun getBucketInd(key: K): Int {
        val hashCode = key.hashCode()

        return (hashCode % numBuckets)
    }

    fun insert(key: K, value: V) {
        val bucketInd = getBucketInd(key)

        var head = buckets[bucketInd]

        while (head != null) {
            if (head.key!! == key) { //such node is already exist
                head.value = value //change value and return
                return
            }
            head = head.next
        }

        val newElementNode = MapNode(key, value)

        head = buckets[bucketInd]

        newElementNode.next = head

        buckets[bucketInd] = newElementNode

        size++

        val loadFactor = (1.0 * size) / numBuckets

        //We increase the default value, rehash
        if (loadFactor > DEFAULT_LOAD_FACTOR) {
            rehash()
        }
    }

    /**
     * Rehash our table
     */
    private fun rehash() {
        val temp = buckets

        buckets = ArrayList(2 * numBuckets) //Increase size by 2

        for (i in 0 until 2 * numBuckets) {
            buckets.add(null)
        }

        size = 0
        numBuckets *= 2

        for (i in 0 until temp.size) {
            var head = temp[i]

            while (head != null) {
                val key = head.key
                val value = head.value

                insert(key, value)
                head = head.next
            }
        }
    }

    /**
     * @param key - key to search
     * @return - value, can be null
     */
    fun get(key: K): V? {
        val bucketInd = getBucketInd(key)

        var bucket = buckets[bucketInd]

        while (bucket != null) {
            if (bucket.key == key) {
                return bucket.value
            }
            bucket = bucket.next
        }

        return null
    }
}
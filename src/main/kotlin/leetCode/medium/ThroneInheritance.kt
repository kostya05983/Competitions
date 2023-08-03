package leetCode.medium

import java.util.*

data class Human(
    val name: String,
    val children: MutableList<Human>,
    var isDead: Boolean
)

class ThroneInheritance(private val kingName: String) {
    private val state = mutableMapOf(
        kingName to Human(
            kingName,
            mutableListOf(),
            isDead = false
        )
    )

    fun birth(parentName: String, childName: String) {
        val parent = state[parentName] ?: return
        if (parent.isDead) throw IllegalArgumentException("Zombie apocalypse is real")

        val human = Human(
            name = childName,
            children = mutableListOf(),
            isDead = false
        )
        parent.children.add(human)

        state[childName] = human
    }

    fun death(name: String) {
        state[name]?.isDead = true
    }

    fun getInheritanceOrder(): List<String> {
        val stack = Stack<Human>()
        stack.push(state[kingName])

        val result = mutableListOf<String>()
        while (!stack.isEmpty()) {
            val parent = stack.pop()

            if (!parent.isDead) result.add(parent.name)
            for (i in parent.children.lastIndex downTo 0) {
                val child = parent.children[i]
                stack.push(child)
            }
        }

        return result
    }
}

fun main(args: Array<String>) {
    val solution = ThroneInheritance("king")
    solution.birth("king", "andy")
    solution.birth("king", "bob")
    solution.birth("king", "catherine")
    solution.birth("andy", "matthew")
    solution.birth("bob", "alex")
    solution.birth("bob", "asha")
    val inheritance = solution.getInheritanceOrder()
    println(inheritance)
    solution.death("bob")
    val inheritance2 = solution.getInheritanceOrder()
    println(inheritance2)
}
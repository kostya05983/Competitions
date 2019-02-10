data class Good(var name: String, var price: String, var quantity: String)


fun catalog(s: String, article: String): String {
    // your code
    val goods = parse(s).filter { it.name.contains(article) }
    return if(goods.isEmpty())
        "Nothing"
    else formOutput(goods).toString().replace(Regex("$\n"), "")
}

fun formOutput(goods: List<Good>): StringBuilder {
    val sb = StringBuilder()
    for ((name, price, quantity) in goods) {
        sb.append(name).append(" > prx: $")
            .append(price).append(" qty: ").append(quantity)
            .append("\n")
    }
    return sb
}

fun parse(s: String): ArrayList<Good> {
    val replacement = s.replace("<prod>", "").replace("</prod>", "")
    val list = replacement.split("\n\n")
    val result = ArrayList<Good>()
    for (line in list) {
        val name = line.substring(line.indexOf("<name>") + 6, line.indexOf("</name>"))
        val price = line.substring(line.indexOf("<prx>") + 5, line.indexOf("</prx>"))
        val quantity = line.substring(line.indexOf("<qty>") + 5, line.indexOf("</qty>"))
        result.add(Good(name, price, quantity))
    }
    return result
}



fun main() {
    val s = """<prod><name>drill</name><prx>99</prx><qty>5</qty></prod>

<prod><name>hammer</name><prx>10</prx><qty>50</qty></prod>

<prod><name>screwdriver</name><prx>5</prx><qty>51</qty></prod>

<prod><name>table saw</name><prx>1099.99</prx><qty>5</qty></prod>

<prod><name>saw</name><prx>9</prx><qty>10</qty></prod>

<prod><name>chair</name><prx>100</prx><qty>20</qty></prod>

<prod><name>fan</name><prx>50</prx><qty>8</qty></prod>

<prod><name>wire</name><prx>10.8</prx><qty>15</qty></prod>

<prod><name>battery</name><prx>150</prx><qty>12</qty></prod>

<prod><name>pallet</name><prx>10</prx><qty>50</qty></prod>

<prod><name>wheel</name><prx>8.80</prx><qty>32</qty></prod>

<prod><name>extractor</name><prx>105</prx><qty>17</qty></prod>

<prod><name>bumper</name><prx>150</prx><qty>3</qty></prod>

<prod><name>ladder</name><prx>112</prx><qty>12</qty></prod>

<prod><name>hoist</name><prx>13.80</prx><qty>32</qty></prod>

<prod><name>platform</name><prx>65</prx><qty>21</qty></prod>

<prod><name>car wheel</name><prx>505</prx><qty>7</qty></prod>

<prod><name>bicycle wheel</name><prx>150</prx><qty>11</qty></prod>

<prod><name>big hammer</name><prx>18</prx><qty>12</qty></prod>

<prod><name>saw for metal</name><prx>13.80</prx><qty>32</qty></prod>

<prod><name>wood pallet</name><prx>65</prx><qty>21</qty></prod>

<prod><name>circular fan</name><prx>80</prx><qty>8</qty></prod>

<prod><name>exhaust fan</name><prx>62</prx><qty>8</qty></prod>

<prod><name>window fan</name><prx>62</prx><qty>8</qty></prod>"""

    val result =catalog(s, "ladder")
    println(result)
//    assertEquals("ladder > prx: $112 qty: 12", catalog(s, "ladder"))
//    assertEquals("table saw > prx: $1099.99 qty: 5\nsaw > prx: $9 qty: 10\nsaw for metal > prx: $13.80 qty: 32", catalog(s, "saw"))
//    assertEquals("wood pallet > prx: $65 qty: 21", catalog(s, "wood pallet"))
}


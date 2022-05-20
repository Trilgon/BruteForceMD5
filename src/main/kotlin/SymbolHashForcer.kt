import HashMaker.toMD5

class SymbolHashForcer {
    fun forceMD5(values: Array<Char>, target: String){
        for (value in values) {
            val hash = toMD5(value.toString()).let { it.substring(it.lastIndex - 3..it.lastIndex) }
            if (hash == target) {
                println(value)
            }
        }
        println("Значене не найдено")
    }
}
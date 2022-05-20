import ForceManager.fullForce
import ForceManager.symbolForce

fun main(args: Array<String>){
    val values: MutableList<Char> = initValues()
    val target = readln()
    fullForce(values, target)
}

fun initValues(): MutableList<Char>{
    val values: MutableList<Char> = mutableListOf()
    for (value in 'a'..'z'){
        values.add(value.toChar())
    }
    for (value in 'A'..'Z'){
        values.add(value.toChar())
    }
    for (value in '0'..'9'){
        values.add(value.toChar())
    }
    return values
}
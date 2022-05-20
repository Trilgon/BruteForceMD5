object ForceManager {
    fun symbolForce(values: MutableList<Char>, target: String, threadNumber: Int = 4) {
        val split = countValues(values, threadNumber)

        val threads = mutableListOf<ForcerThread>()
        for (i in 1 until threadNumber) {
            val partedValues: Array<Char> = values.subList((i - 1) * split, i * split).toTypedArray()
            threads.add(ForcerThread(partedValues, target))
        }
        threads.add(ForcerThread(values.subList((threadNumber - 1) * split, values.lastIndex).toTypedArray(), target))

        for (thread in threads) {
            thread.start()
            println("Поток начал работу")
        }
    }

    fun fullForce(values: MutableList<Char>, target: String, threadNumber: Int = 4) {
        val split = countValues(values, threadNumber)

        val threads = mutableListOf<FullHashForcer>()
        for (i in 1 until threadNumber){
            threads.add(FullHashForcer(values.toTypedArray(), target, (i - 1) * split, i * split))
        }
        threads.add(FullHashForcer(values.toTypedArray(), target, (threadNumber - 1) * split, values.lastIndex))

        for (thread in threads) {
            thread.start()
            println("Поток начал работу")
        }
    }

    private fun countValues(values: MutableList<Char>, threadNumber: Int) : Int{
        return if (values.size % threadNumber == 0) {
            values.size / threadNumber
        } else {
            values.size / threadNumber + 1
        }
    }
}
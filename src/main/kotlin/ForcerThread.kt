class ForcerThread(private val values: Array<Char>, private val target: String): Thread() {
    private val forcer = SymbolHashForcer()

    override fun run() {
        super.run()
        forcer.forceMD5(values, target)
    }
}
enum class Genre(val description: String) {
    FICTION("Dragons and co"),
    NON_FICTION("Only reality"),
    SCIENCE("Physics, chemistry and co"),
    HISTORY("War and kings"),
    CHILDREN("Farytails");

    // Funktion, die die Beschreibung der jeweiligen Jahreszeit ausgibt
    fun printDescription() {
        println( description)
    }
}

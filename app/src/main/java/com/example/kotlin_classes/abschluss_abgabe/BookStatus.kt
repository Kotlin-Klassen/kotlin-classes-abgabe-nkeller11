sealed class BookStatus {

    // Status: Buch ist verfügbar
    object Available : BookStatus()

    // Status: Buch ist ausgeliehen mit Rückgabedatum
    data class CheckedOut(val dueDate: String) : BookStatus()

    // Status: Buch ist reserviert, zeigt den Namen der Person an
    data class Reserved(val reservedBy: String) : BookStatus()

    // Methode, die den Status des Buches als lesbare Zeichenkette zurückgibt
    fun getReadableStatus(): String {
        return when (this) {
            is Available -> "Das Buch ist verfügbar."
            is CheckedOut -> "Das Buch ist ausgeliehen. Rückgabedatum: $dueDate"
            is Reserved -> "Das Buch ist reserviert von $reservedBy."
            else -> "Unbekannter Status."
        }
    }
}




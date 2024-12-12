package com.example.kotlin_classes.abschluss_abgabe

import Book

fun main() {
    // Bibliothek erstellen
    val library = Library()

    // Adresse der Bibliothek hinzufügen und ausgeben
    val address = Library.LibraryAddress("Hauptstraße 123", "Berlin", "10115")
    address.printAddress()

    // Verschiedene Bücher zur Bibliothek hinzufügen
    library.addBook(Book("1984", "George Orwell", Genre.FICTION))
    library.addBook(Book("To Kill a Mockingbird", "Harper Lee", Genre.NON_FICTION))
    library.addBook(Book("The Great Gatsby", "F. Scott Fitzgerald", Genre.HISTORY))
    library.addBook(Book("Moby Dick", "Herman Melville", Genre.HISTORY))

    // Bücherstatus anzeigen
    println("\nAktueller Status aller Bücher:")
    library.displayAllBooksStatus()

    // Mitglied erstellen
    val member = library.LibraryMember("Anna Müller", "M001")

    // Buch ausleihen
    println("\nEin Buch ausleihen:")
    val bookToCheckout = library.searchBook("1984").firstOrNull()
    if (bookToCheckout != null) {
        member.checkoutBook(bookToCheckout, "2024-12-31")
    } else {
        println("Das Buch '1984' wurde nicht gefunden.")
    }

    // Ein anderes Buch reservieren
    println("\nEin Buch reservieren:")
    val bookToReserve = library.searchBook("To Kill a Mockingbird").firstOrNull()
    if (bookToReserve != null) {
        member.reserveBook(bookToReserve)
    } else {
        println("Das Buch 'To Kill a Mockingbird' wurde nicht gefunden.")
    }

    // Aktualisierten Bücherstatus anzeigen
    println("\nAktualisierter Status aller Bücher:")
    library.displayAllBooksStatus()
}

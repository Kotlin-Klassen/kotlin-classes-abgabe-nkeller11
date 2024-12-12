package com.example.kotlin_classes.abschluss_abgabe

import Book
import BookStatus

class Library {
    // Liste der Bücher in der Bibliothek
    private val books = mutableListOf<Book>()

    // Nested Class: Repräsentiert die Adresse der Bibliothek
    class LibraryAddress(private val street: String, private val city: String, private val zipCode: String) {
        fun printAddress() {
            println("Bibliotheksadresse: $street, $city, $zipCode")
        }
    }

    // Methode: Ein Buch nach Titel oder Autor durchsuchen
    fun searchBook(query: String): List<Book> {
        return books.filter { it.title.contains(query, ignoreCase = true) || it.author.contains(query, ignoreCase = true) }
    }

    // Methode: Den Status aller Bücher anzeigen
    fun displayAllBooksStatus() {
        if (books.isEmpty()) {
            println("Keine Bücher in der Bibliothek.")
        } else {
            books.forEach { book ->
                // Verwende die getReadableStatus-Methode der BookStatus-Klasse
                val statusDescription = book.status.getReadableStatus()
                println("Titel: ${book.title}, Genre: ${book.genre} (${book.genre.description}, Autor: ${book.author}, Status: $statusDescription")
            }
        }
    }

    // Methode: Ein neues Buch hinzufügen
    fun addBook(book: Book) {
        books.add(book)
        println("Das Buch '${book.title}' mit Genre '${book.genre}:${book.genre.description}' von ${book.author} wurde zur Bibliothek hinzugefügt.")
    }
    
    inner class LibraryMember(val name: String, val memberId: String) {

        // Methode: Buch ausleihen
        fun checkoutBook(book: Book, dueDate: String) {
            if (book.status is BookStatus.Available) {
                book.status = BookStatus.CheckedOut(dueDate)
                println("Das Buch '${book.title}' wurde von $name (ID: $memberId) ausgeliehen. Rückgabedatum: $dueDate.")
            } else {
                println("Das Buch '${book.title}' ist nicht verfügbar. Aktueller Status: ${book.status}.")
            }
        }

        // Methode: Buch reservieren
        fun reserveBook(book: Book) {
            if (book.status is BookStatus.Available) {
                book.status = BookStatus.Reserved(name)
                println("Das Buch '${book.title}' wurde von $name (ID: $memberId) reserviert.")
            } else {
                println("Das Buch '${book.title}' kann nicht reserviert werden. Aktueller Status: ${book.status}.")
            }
        }
    }

}
package com.example.booklist.data;

import com.example.booklist.models.BooksModel;

import java.util.ArrayList;
import java.util.List;

public class TestRepozitory {
    private static List<BooksModel> bookList = new ArrayList<>();
public  static  BooksModel getBookById( int position){
    return bookList.get(position);
}
    public static List<BooksModel> getBook() {
        bookList.add(new BooksModel(
                "Анна Каренина",
                "Автор : Л. Толстой"
        ));
        bookList.add(new BooksModel(
                "Гарри потер",
                "Автор : Дж.Роулинг"
        ));
        bookList.add(new BooksModel(
                "1984",
                "Автор : Дж.Оруэлл"
        ));
        bookList.add(new BooksModel(
                "Записки о Шерлоке Холмсе",
                "Автор : А.К. Доиль"
        ));
        return bookList;
    }
}

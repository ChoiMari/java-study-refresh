package kr.or.kosa;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

//도서 클래스
@Data @Builder
public class Book implements Serializable{

    final String isbn;
    String title;
    int price;

    public Book(String isbn, String title,int price){
           this.isbn = isbn;
           this.title = title;
           this.price = price;
    }

    public String ISBN(){
           return isbn;
    }

    public String toString(){
           return String.format("ISBN:%s 이름:%s 가격:%d", isbn, title,price);        }
}

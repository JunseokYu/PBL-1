package myClass;

/**
 * Book클래스는 책 객체를 생성하는 클래스.
 *
 * @author (2022320026 유준석, 2022320014 정재헌, 2022320018 이성민)
 * @version (2025.09.17)
 */
public class Book extends DB_Element
{
    private String title;
    private String publisher;
    private String author;
    private String BookID;
    private int year;

    /**
     * Book 클래스의 객체 생성자
     */
    public Book(String BookID,String title,String author,String publisher,int year){
        this.author = author;
        this.BookID = BookID;
        this.publisher = publisher;
        this.title = title;
        this.year = year;
    }

    /**
     * BookID를 리턴하는 메소드
     */
    public String getID(){
        return this.BookID;
    }
    /**
     * 상위 클래스인 object 클래스에 오버라이딩하는 클래스. (문자열 반환)
     */
    public String toString(){
        return "("+this.BookID+") "+this.title+", "+this.author+", "+this.publisher+", "+this.year;
    }
}

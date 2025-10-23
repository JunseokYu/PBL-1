import java.util.*;
import java.io.*;
import myClass.*;
import DataBase.*;

/**
 * LibraryManagementSystem 클래스의 설명을 작성하세요.
 *
 * @author (2022320026 유준석, 2022320014 정재헌, 2022320018 이성민)
 * @version (2025.10.23)
 */
public class LibraryManagementSystem
{
    // 인스턴스 변수 - 다음의 예제를 사용자에 맞게 변경하세요.
    LibDB<Book> bookDB;
    HashMap<User, Book> loanDB;
    LibDB<User> userDB;

    /**
     * LibraryManagementSystem 클래스의 객체 생성자
     */
    public LibraryManagementSystem()
    {
        this.bookDB = new LibDB<>();
        this.userDB = new LibDB<>();
        this.loanDB = new HashMap<User, Book>();
    }

    /**
     * 도서 대여 메서드
     */
    public void borrowBook(String userID, String bookID)
    {
        loanDB.put(userDB.findElement(userID), bookDB.findElement(bookID));
    }

    /**
     * DB 전체 출력 메서드
     */
    public <T extends DB_Element> void printDB(LibDB<T> db)
    {
        db.printAllElements();
    }

    /**
     * 대여 목록 출력 메서드
     */
    public void printLoanList()
    {
        Set<User> keys = loanDB.keySet();
        Iterator<User> it = keys.iterator();
        while(it.hasNext()) {
            User userObj = it.next();
            Book bookObj = loanDB.get(userObj);
            System.out.println(userObj + " ===> " + bookObj);
        }
    }

    /**
     * 도서 데이터베이스 설정 메서드
     */
    public LibDB<Book> setBookDB(String bookFile)
    {
        try {
            Scanner scan = new Scanner(new FileReader(bookFile));
            ArrayList<String> line = new ArrayList<String>();
            while(scan.hasNext()) {
                line.add(scan.nextLine());
            }
            scan.close();
            
            Iterator<String> it = line.iterator();
            while(it.hasNext()){
                StringTokenizer stz = new StringTokenizer(it.next(), "/");
                Book bookObj = new Book(
                    stz.nextToken(), 
                    stz.nextToken(), 
                    stz.nextToken(), 
                    stz.nextToken(),
                    Integer.valueOf(stz.nextToken()));
                bookDB.addElement(bookObj);
            }
        } 
        catch(IOException e){
            System.out.println("파일 입력에 오류가 발생했습니다.");
        }
        return bookDB;
    }


    /**
     * 사용자 데이터베이스 설정 메서드
     */
    public LibDB<User> setUserDB(String userFile)
    {
        try {
            Scanner scan = new Scanner(new FileReader(userFile));
            for(; scan.hasNext();) {
                String line = scan.nextLine();
                StringTokenizer stz = new StringTokenizer(line, "/");
                User userObj = new User(Integer.valueOf(stz.nextToken()), stz.nextToken());
                userDB.addElement(userObj);
            }
            scan.close();
        } 
        catch(IOException e){
            System.out.println("파일 입력에 오류가 발생했습니다.");
        }
        return userDB;
    }
}

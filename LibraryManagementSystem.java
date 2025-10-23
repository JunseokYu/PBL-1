import java.util.*;
import java.io.*;
import myClass.*;
import DataBase.*;

/**
 * bookDB, loanDB, userDB를 생성하고 대출 작업 / 각각의 데이터베이스 요소 출력
 * / userDB, bookDB에 요소를 설정하는 메소드
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
     * loanDB에 userID와 bookID를 가진 객체를 찾아 저장하는 메소드
     *
     * @param 찾고싶은 User 객체와 동일한 userID 파라미터
     * @param 찾고싶은 Book 객체와 동일한 bookID 파라미터
     */
    public void borrowBook(String userID, String bookID)
    {
        loanDB.put(userDB.findElement(userID), bookDB.findElement(bookID));
    }

    /**
     * userDB와 bookDB의 요소들을 출력하는 메소드
     *
     * @param 출력하고 싶은 LibDB<T> db 파라미터
     */
    public <T extends DB_Element> void printDB(LibDB<T> db)
    {
        db.printAllElements();
    }

    /**
     * loanDB의 요소들을 출력하는 메소드
     *
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
     * 파라미터로 받은 파일 경로를 스트림으로 한 줄씩 입력받아 토큰화 하여 BOOK객체를 생성하고 
     * LibDB<Book>에 추가하고 반환하는 메소드
     *
     * @param 저장하고 싶은 책 정보 파일의 경로 값 bookFile 파라미터
     * @return 저장된 LibDB<Book>
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
     * 파라미터로 받은 파일 경로를 스트림으로 한 줄씩 입력받아 토큰화 하여 User객체를 생성하고 
     * LibDB<User>에 추가하여 반환하는 메소드
     *
     * @param 저장하고 싶은 책 정보 파일의 경로 값 userFile 파라미터
     * @return 저장된 LibDB<User>
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

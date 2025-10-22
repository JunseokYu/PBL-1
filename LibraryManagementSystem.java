import java.util.*;
import java.io.*;
import myClass.*;
import DataBase.*;

/**
 * LibraryManagementSystem 클래스의 설명을 작성하세요.
 *
 * @author (작성자 이름)
 * @version (버전 번호 또는 작성한 날짜)
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
        this.bookDB = new LibDB<Book>();
        this.userDB = new LibDB<User>();
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
    public <T> void printDB(LibDB<T> db)
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
        while (it.hasNext()) {
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
            while (true) {
                int i = 0;
                line.add(scan.nextLine());
                if (line.get(i).length() == 0)
                    break;
                i++;
            }

            Iterator<String> it = line.iterator();
            while (it.hasNext()) {
                int j = 0;
                StringTokenizer stz = new StringTokenizer(line.get(j), "/");
                Book bookObj = new Book(
                    stz.nextToken(), stz.nextToken(), stz.nextToken(), stz.nextToken(),
                    Integer.valueOf(stz.nextToken())
                );
                j++;
            }
            scan.close();
        } catch (IOException e) {
            System.out.println("입출력 오류");
        }
        bookDB.add(bookObj);
        return bookObj;
    }

    /**
     * 사용자 데이터베이스 설정 메서드
     */
    public LibDB<User> setUserDB(String userFile)
    {
        Scanner scan = new Scanner(System.in);
        FileReader fout = null;
        int c;
        try {
            fout = new FileReader(userFile);
            for (int i = 0; true; i++) {
                String line = scan.nextLine();
                StringTokenizer stz = new StringTokenizer(line, "/");
                String[] userIf = new String[stz.countTokens()];

                for (int i = 0; stz.hasMoreTokens(); i++) {
                    String tok = stz.nextToken();
                    userIf[i] = tok;
                }

                User userObj = new User(userIf[0], Integer.valueOf(userIf[1]));

                if (line.length() == 0)
                    break;
            }
            fout.close();
        } catch (IOException e) {
            System.out.println("입출력 오류");
        }
        scan.close();
        return userObj;
    }
}

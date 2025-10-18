import java.util.*;
import java.io.*;
import myClass.*;

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
     * 예제 메소드 - 이 주석을 사용자에 맞게 바꾸십시오
     *
     * @param  y  메소드의 샘플 파라미터
     * @return    x 더하기 y의 결과값을 반환
     */
    public void borrowBook(String userID, String bookID)
    {
        loanDB.put(userDB.findElement(userID), bookDB.findElement(bookID));
    }

    /**
     * 메소드 예제 - 사용자에 맞게 주석을 바꾸십시오.
     *
     * @param  y  메소드의 샘플 파라미터
     * @return    x 와 y의 합
     */
    public <T> void printDB(LibDB<T> db)
    {
        db.printAllElements();
    }

    /**
     * 메소드 예제 - 사용자에 맞게 주석을 바꾸십시오.
     *
     * @param  y  메소드의 샘플 파라미터
     * @return    x 와 y의 합
     */
    public void printLoanList()
    {
        Set<User> keys = loanDB.keySet();
        Iterator<User> it = keys.iterator();
        while(it.hasNext()){
            User userObj = it.next();
            Book bookObj = loanDB.get(userObj);
            System.out.println(userObj + " ===> " + bookObj);
        }
    }

    /**
     * 메소드 예제 - 사용자에 맞게 주석을 바꾸십시오.
     *
     * @param  y  메소드의 샘플 파라미터
     * @return    x 와 y의 합
     */
    public LibDB<Book> setBookDB(String bookFile)
    {
        try{
            Scanner scan = new Scanner(new FileReader(bookFile));
            while(true){
                String line = scan.nextLine();
                StringTokenizer stz = new StringTokenizer(line, "/");
                String[] bookIf = new String[stz.countTokens()];
                
                for(int i = 0; stz.hasMoreTokens(); i++){
                    String tok = stz.nextToken();
                    bookIf[i] = tok;
                }
                
                Book bookObj = new Book(bookIf[0], bookIf[1], bookIf[2], bookIf[3], Integer.valueOf(bookIf[4]));
                
                if(line.length() == 0)
                    break;
            }
        }
        catch(IOException e){
            System.out.println("입출력 오류");
        }
        finally{
            if(scan != null)
                scan.close();
            }
        }
        bookDB.add(bookObj);
        return bookObj;
    }

     /**
     * 메소드 예제 - 사용자에 맞게 주석을 바꾸십시오.
     *
     * @param  y  메소드의 샘플 파라미터
     * @return    x 와 y의 합
     */
    public LibDB<User> setUserDB(String userFile)
    {
        Scanner scan = new Scanner(System.in);
        FileReader fout = null;
        int c;
        try{
            fout = new FileReader(userFile);
            for(int i = 0; true; i++){
                String line = scan.nextLine();
                StringTokenizer stz = new StringTokenizer(line, "/");
                String[] userIf = new String[stz.countTokens()];
                
                for(int i = 0; stz.hasMoreTokens();i++){
                    String tok = stz.nextToken();
                    userIf[i] = tok;
                }
                
                User userObj = new User(userIf[0], Integer.valueOf(userIf[1]));
                
                if(line.length() == 0)
                    break;
            }
            fout.close();
        }
        catch(IOException e){
            System.out.println("입출력 오류");
        }
        scan.close();
        return userObj;
    }

}
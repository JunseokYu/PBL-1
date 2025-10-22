import DataBase.*;

/**

* App 클래스는 라이브러리 시스템을 실행하여 DB 정보를 출력하는 메인 클래스.
*
* @author (2022320026 유준석, 2022320014 정재헌, 2022320018 이성민)
* @version (2025.09.)
  */
  public class App
  {
  public static void main(String[] args){
  // 1. LibraryManagementSystem 객체 생성
  LibraryManagementSystem lms = new LibraryManagementSystem();

  ```
   // 2. 이용자 정보 등록
   LibDB<User> userDB = lms.setUserDB("C:\\Temp\\UserData2025.txt");

   // 3. 이용자 정보 출력
   System.out.println("----- 이용자 정보 출력 -----");
   LibDB.printDB(userDB);

   // 4. 책 정보 등록
   LibDB<Book> bookDB = lms.setBookDB("C:\\Temp\\BookData2025.txt");

   // 5. 책 정보 출력
   System.out.println("----- 책 정보 출력 -----");
   LibDB.printDB(bookDB);

   // 6. 대출 작업
   lms.borrowBook("202332003", "B04");
   lms.borrowBook("202532001", "B02");
   lms.borrowBook("202432002", "B03");

   // 7. 대출 현황 출력
   lms.printLoanList();
  ```

  }
  }

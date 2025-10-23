package DataBase;
import java.util.*;
import myClass.*;

/**
 * userDB와 bookDB를 생성하는 제네릭한 메소드
 *
 * @author (2022320026 유준석, 2022320014 정재헌, 2022320018 이성민)
 * @version (2025.10.23)
 */
public class LibDB<T extends DB_Element> {
    private ArrayList<T> db;

    /**
     * LibDB의 생성자(ArrayList<T>)
     *
     */
    public LibDB() {
        db = new ArrayList<>();
    }

    /**
     * 해당 db에 요소를 추가하는 메소드
     *
     * @param 추가할 요소인 T 타입의 element 파라미터
     */
    public void addElement(T element) {
        db.add(element);
    }

    /**
     * DB에서 파라미터와 동일한 ID를 가진 객체를 반환하는 메소드  
     *
     * @param 찾고싶은 ID인 s 파라미터
     * @return T 객체
     */
    public T findElement(String s) {
        Iterator<T> it = db.iterator();
        while (it.hasNext()) {
            T obj = it.next();
            if(obj.getID().equals(s)){
                return obj;
            }
        }
        return null;
    }

    /**
     * 메시지를 받은 DB의 모든 요소를 출력하는 메소드
     *
     */
    public void printAllElements() {
        for (T element : db) {
            System.out.println(element.toString());
        }
    }
}
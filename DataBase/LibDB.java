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

    public LibDB() {
        db = new ArrayList<>();
    }

    public void addElement(T element) {
        db.add(element);
    }

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

    public void printAllElements() {
        for (T element : db) {
            System.out.println(element.toString());
        }
    }
}
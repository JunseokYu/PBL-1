package DataBase;
import java.util.*;

/**
 * LibDB 클래스의 설명을 작성하세요.
 *
 * @author ()
 * @version ()
 */
public class LibDB<T> {
    private ArrayList<T>db;

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
            if(obj.toString().equals(s)){
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
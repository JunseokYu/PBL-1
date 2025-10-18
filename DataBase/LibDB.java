package DataBase;
import java.util.*;

/**
 * LibDB 클래스의 설명을 작성하세요.
 *
 * @author ()
 * @version ()
 */
public class LibDB<T> {
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
            T element = it.next();
            if (element instanceof Book) {
                if (((Book) element).getID().equals(s)) {
                    return element;
                }
            } else if (element instanceof User) {
                if (((User) element).getID().equals(s)) {
                    return element;
                }
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
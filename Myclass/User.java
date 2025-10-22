package myClass;

/**
 * User클래스는 이용자 객체를 생성하는 클래스.
 *
 * @author (2022320026 유준석, 2022320014 정재헌, 2022320018 이성민)
 * @version (2025.09.17)
 */
public class User extends DB_Element
{
    private String name;
    private Integer stID;

    /**
     * User클래스의 객체 생성자
     *
     * @param stID 파라미터
     * @param name 파라미터
     */
    public User(Integer stID, String name) {
        this.name = name;
        this.stID = stID;
    }

    /**
     * getID를 Wrapper클래스의 Integer형을 문자열로 반환하는 메소드
     */
    public String getID() {
        return stID.toString();
    }

    /**
     * 상위 클래스인 Object 클래스의 toString 메서드를 오버라이딩 (문자열 반환)
     */
    public String toString() {
        return "[" + stID + "] " + name;
    }
}

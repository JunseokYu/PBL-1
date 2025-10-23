package myClass;

/**
 * Book 클래스와, User 클래스의 상위 클래스이며, 추상화 getID() 메소드를 지닌 추상화 클래스 
 *
 * @author (2022320026 유준석, 2022320014 정재헌, 2022320018 이성민)
 * @version (2025.10.23)
 */
public abstract class  DB_Element
{   
    /**
     * ID의 값을 반환하는 추상메소드
     *
     * @return String 타입의 ID
     */
    public abstract String getID();
}

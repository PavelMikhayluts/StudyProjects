package generics;

public class Gen <T> {

    T object; // Обьявляем обьект типа Т

    Gen(T o) { // Передаем конструктору ссылку на обьект типа Т
        object = o;
    }

    // Возвращаем обьект типа Т из метода
    T getObject() {
        return object;
    }

    // Отобразить Т
    void showType() {
        System.out.println("Тип Т - это " + object.getClass().getName());
    }
}

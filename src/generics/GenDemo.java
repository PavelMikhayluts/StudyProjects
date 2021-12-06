package generics;

public class GenDemo {

    public static void main(String[] args) {
        Gen<Integer> iObject;
        iObject = new Gen<>(88);
        iObject.showType();
        // Получаем значение из обьекта iObject. Обратить внимание на то, что приведения типов здесь не требуется
        int v = iObject.getObject();
        System.out.println("Значение: " + v);
        System.out.println();

        Gen<String> sObject = new Gen<>("Тестирование ообщений");
        sObject.showType();
        String str = sObject.getObject();
        System.out.println("Значение: " + str);
    }
}

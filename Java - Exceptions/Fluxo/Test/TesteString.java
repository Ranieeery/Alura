package Test;

public class TesteString {
    public static void main(String[] args) {
        String name = "Java";
       //String nameOld = new String("Java"); - redundante

        name.replace("J", "j");
        name.toUpperCase(); // imutável

        System.out.println(name);

        String name2 = name.replace("J", "j");
        String name3 = name.toUpperCase();

        System.out.println(name2);
        System.out.println(name3);

    }
}

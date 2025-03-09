import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        int a = 1;
//        double b = 20;
//        float c = 1.1f;
//        //String o = "slowo";
//        //o nie jest typem prostym
//        char d = 'd';
//        boolean e = true;
//        Integer f = 10;
//        String z = "ddd";
//        Double h = 20.5;
//        Float x = 1.1f;

//        System.out.println(a);
//        System.out.println(b);
//        System.out.println(c);
//        //System.out.println(o);
//        System.out.println(d);
//        System.out.println(e);
//        System.out.println(f);
//        System.out.println(g);
//        System.out.println(h);
//        System.out.println(i);
//        Student student1 = new Student();
//        student1.setName("Mateusz");
//
//        Student student2 = new Student();
//        student2.setName("Pawel");

//        if (e == true) {
//            System.out.println("Student student1, name: " + student1.getName());
//            System.out.println("Student student2, name: " + student2.getName());
//        }
//        switch (z) {
//            case "ddd":
//                System.out.println("Student student1, name: " + student1.getName());
//                break;
//            default:
//                System.out.println("default");
//                break;
//        }
//        for (int j = 0; i < 10; i++){
//            System.out.println(i);
//        }
//        List<Integer> integerList = new ArrayList<>();
//        integerList.add(1);
//        integerList.add(2);
//        integerList.add(3);
//        integerList.add(4);
//
//        List<Integer> integerList2 = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
//        integerList.remove(3);
//        //integerList2.remove(2);//ctr + lewy klawisz myszy
//        for(Integer i : integerList2){
//            System.out.println(i);
//        }
//        integerList2.stream()
//                //.forEach(integer -> System.out.println(integer));
//                .filter(i -> i % 2 == 0);
//        List<Integer> list = integerList2.stream()
//                .map(integer -> multiply)
        Mercedes mercedes = new Mercedes();
        mercedes.printname();
        mercedes.moveForward();
        try {
            mercedes.printname();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println("koniec");
        }
    }
}
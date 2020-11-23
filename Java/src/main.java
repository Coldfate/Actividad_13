import java.util.*;

interface AnonSort {
    void abcSort();
    void lengthSort();
}
interface LambdaABCSort {
    String abcSort(ArrayList l);
}
interface LambdaLengthSort {
    String lengthSort(ArrayList l);
}

class MethodSort {
    public static String abcSort(ArrayList list){
        Collections.sort(list);
        System.out.println("Orden alfabetico - Metodo de referencia");
        for (Object i : list) {
            System.out.println(i);
        }
        String message = ("Presiona enter para continuar...");
        return message;
    }
    public static String lengthSort(ArrayList list){
        Collections.sort(list, Comparator.comparingInt(String::length));
        System.out.println("Orden por longitud - Metodo de referencia");
        for (Object i : list) {
            System.out.println(i);
        }
        String message = ("Presiona enter para continuar...");
        return message;
    }
}

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        list.add("Home");
        list.add("Car");
        list.add("Pencil");
        list.add("Sofa");
        list.add("TV");
        list.add("Laptop");
        list.add("Console");
        list.add("Fan");
        list.add("Modem");
        list.add("Keyboard");

        System.out.println("Lista sin ordenar:");
        for (String i : list) {
            System.out.println(i);
        }
        System.out.println("Presiona enter para continuar...");
        sc.nextLine();

        //Clases anonimas
        AnonSort anonSort = new AnonSort() {
            @Override
            public void lengthSort() {
                Collections.sort(list, Comparator.comparingInt(String::length));
                System.out.println("Orden por longitud - clase anonima");
                for (String i : list) {
                    System.out.println(i);
                }
                System.out.println("Presiona enter para continuar...");
                sc.nextLine();
            }
            @Override
            public void abcSort() {
                Collections.sort(list);
                System.out.println("Orden alfabetico - Clase Anonima");
                for (String i : list) {
                    System.out.println(i);
                }
                System.out.println("Presiona enter para continuar...");
                sc.nextLine();
            }
        };

        //Expresiones Lambda
        LambdaABCSort abc = (l) -> {
            Collections.sort(l);
            String a = "Presiona enter para continuar...";
            System.out.println("Orden alfabetico - Expresion Lambda");
            for(String i : list) {
                System.out.println(i);
            }
            return a;
        };
        LambdaLengthSort length = (l) -> {
            Collections.sort(list, Comparator.comparingInt(String::length));
            String a = "Presiona enter para continuar...";
            System.out.println("Orden por longitud - Expresion Lambda");
            for(String i : list) {
                System.out.println(i);
            }
            return a;
        };

        //Metodos de referencia
        LambdaABCSort methodABC = MethodSort::abcSort;
        LambdaLengthSort methodLenght = MethodSort::lengthSort;

        anonSort.lengthSort();
        System.out.println(length.lengthSort(list));
        sc.nextLine();
        System.out.println(methodLenght.lengthSort(list));
        sc.nextLine();

        anonSort.abcSort();
        System.out.println(abc.abcSort(list));
        sc.nextLine();
        System.out.println(methodABC.abcSort(list));
        sc.nextLine();
    }

}

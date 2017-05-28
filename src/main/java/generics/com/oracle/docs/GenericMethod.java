package generics.com.oracle.docs;

/*
The syntax for a generic method includes a type parameter, inside angle brackets, and APPEARS BEFORE THE METHOD'S RETURN TYPE
The generic type is only available to the method (it is SCOPED TO THE METHOD)
*/

public class GenericMethod {

    class Box {
        public <T> void displayType(T t) {
            System.out.println(t + " is a " + t.getClass());
        }
    }

    public static void main(String args[]) {
        GenericMethod outer = new GenericMethod();
        Box box = outer.new Box();

        box.displayType("hello");
        box.displayType(1);
        box.displayType(1.0);
    }

}

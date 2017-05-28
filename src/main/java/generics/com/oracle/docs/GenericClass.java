package generics.com.oracle.docs;

public class GenericClass {

    private class Miel {}

    private class Box<T> { // The generic type is available through the whole class (it is SCOPED TO THE CLASS)
        private T t;

        public Box(T t) {  // The the generic type is set via the constructor
            this.t = t;
        }

        public void displayType() {
            System.out.println(t + " is a " + t.getClass());
        }
    }

    public static void main(String args[]) {
        GenericClass outer  = new GenericClass();

        Box<String> box1    = outer.new Box<>("Hello");
        Box<Integer> box2   = outer.new Box<>(1);
        
        Miel miel           = outer.new Miel();
        Box<Miel> box3      = outer.new Box<>(miel);

        box1.displayType();
        box2.displayType();
        box3.displayType();
    }
}

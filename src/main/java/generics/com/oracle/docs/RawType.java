package generics.com.oracle.docs;
/*
A raw type is the name of a generic class or interface without any type arguments
Raw types show up in legacy code because lots of API classes (such as the Collections classes) were not generic prior to JDK 5.0.
When using raw types, you essentially get pre-generics behavior — a Box gives you Objects
*/

public class RawType {

    private class Box<T> {
        private T t;

        public void set(T t) {
            this.t = t;
        }
    }

    public static void main(String args[]) {

        RawType outer = new RawType();
        Box rawBox = outer.new Box();  // Raw type

        // For backward compatibility, assigning a parameterized type to its raw type is allowed
        Box<String> stringBox1 = outer.new Box<>();
        Box rawBox1 = stringBox1;

        // But if you assign a raw type to a parameterized type, you get a WARNING
        Box rawBox2 = outer.new Box();
        Box<String> stringBox2 = rawBox2;

        // You also get a WARNING if you use a raw type to invoke a generic method
        Box rawBox3 = outer.new Box();
        rawBox3.set("Hello");

        Box<String> stringBox = outer.new Box<>();
        stringBox.set("Hello");  // No warning here

    }

}

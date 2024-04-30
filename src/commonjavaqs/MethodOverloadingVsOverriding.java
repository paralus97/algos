package commonjavaqs;

public class MethodOverloadingVsOverriding extends ExampleClass {
    public static void main(String[] args) {
        MethodOverloadingVsOverriding obj = new MethodOverloadingVsOverriding();
        // This is Overriding
        obj.printStuff();
    }


    // Overloading below
    public void printStuff(int x) {

    }

    // Cant make this!
//    public void printStuff(int x) {
//
//    }

    // Can make this yes
    public void printStuff(long x) {

    }

    // cant do this!
//    public int printStuff(int x) {
//
//    }
}

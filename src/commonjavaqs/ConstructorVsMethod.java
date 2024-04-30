package commonjavaqs;

// having final here means it cant be subclassed
/*final*/ public class ConstructorVsMethod {

    int field;

    // Having final here means that it cant be changed
    final int X = 12;

    //I am the contructor
    ConstructorVsMethod() {
        System.out.println("I'm called by using new keyword and I'm a special method that allocates an object " +
                            "on-heap and returns an object reference");

        this.field = 3; // works here
        //method() does not work here
        this.method(); // works here
    }

    public void method() {

        System.out.println("I'm a method, my call and context will get added to the stack and my return type is specified");
        //side note
        // this key word, is like a constant containing this instance, hence the this
        // I can call
        this.field = 0;
        // or i can call other non static methods
        this.otherMethod();
    }

    public void otherMethod() {
        System.out.println("other method");
    }
}

package commonjavaqs;

// A singleton class is a class that only one instance of the class can exist at one time

// Done by....
// Ensuring constructors are private
// Create instance via static field
// make getter for getSingleton
public class SingletonClass {

    private static SingletonClass singleton = new SingletonClass();

    private SingletonClass() {

    }

    public static SingletonClass getSingleTon() {
        return singleton;
    }
}

package commonjavaqs;

public class ProtectedClass {

    // private means no access to this field in subclass or through field access
    private int field;

    // protected means access to this field in subclass or through field access as long as within the package!
    protected String test;

    // public means field acess inside and outside of package
    public long longers;
}
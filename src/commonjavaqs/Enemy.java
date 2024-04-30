package commonjavaqs;

// Say we're making a game... Enemy should have an attack method
// having final here instead of abstract means Enemy cant be subclassed
/* final */ abstract public class Enemy {

    public void attack() {
        System.out.println("Enemy Attack!");
    }

    public void defend() {
        System.out.println("defend!");
    }

    // Having final here means method cant be overriden in
    public final void cantOverrideMe() {

    }
}

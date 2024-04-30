package commonjavaqs;

public class Ghost extends Enemy {

    public void attack() {
        System.out.println("Ghost attack!");
    }

    public void superClassAttack() {
        super.attack();
    }

//    @Override
//    public void cantOverrideMe() {
//
//    }
}

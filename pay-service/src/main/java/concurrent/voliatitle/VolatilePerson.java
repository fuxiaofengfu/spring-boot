package concurrent.voliatitle;

/**
 * Created by xiaofengfu on 2017/8/20.
 */
public class VolatilePerson {

    public volatile String name;
    public volatile int age;
    public int idcard;

    public volatile boolean state;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getIdcard() {
        return idcard;
    }

    public void setIdcard(int idcard) {
        this.idcard = idcard;
    }

    @Override
    public String toString() {
        return "VolatilePerson{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", idcard=" + idcard +
                ", state=" + state +
                '}';
    }

    public static VolatilePerson getInstance(){
        VolatilePerson volatilePerson =  Inner.volatilePerson;
        //System.out.println("hashcode=="+volatilePerson.hashCode());
        return volatilePerson;
    }

    private static class Inner{
        private static VolatilePerson volatilePerson = new VolatilePerson();
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
}

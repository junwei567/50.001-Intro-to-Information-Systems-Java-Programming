package q3;
//starting code
public class Student implements Observer {
    private String id;
    private Subject subject;
    public static String msg = "";

    public Student(String id, TemperatureAlert subject) {
        this.id = id;
        subject.register(this);

    }

    @Override
    public void update(int temperature) {
        String s = "Fish " + this.id + " receives temperature alert: " + temperature;
        System.out.println(s);
        msg += (s + " ");
    }

}

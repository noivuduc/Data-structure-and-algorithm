package OOP.callcenter;

public class Call {
    private int id;
    private String number;
    private CallState state;

    public Call(int id, String number, CallState state) {
        this.id = id;
        this.number = number;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public CallState getState() {
        return state;
    }

    public void setState(CallState state) {
        this.state = state;
    }
}

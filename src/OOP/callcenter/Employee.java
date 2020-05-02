package OOP.callcenter;

public class Employee {
    private String id;
    private Call call;
    private CallCenter callCenter;

    public void pickupCall(Call call, CallCenter callCenter) {
        call.setState(CallState.IN_PROGRESS);
        this.call = call;
        this.callCenter = callCenter;
    }
    public void releaseCall() {
        this.call = null;
    }

}

package exception;

public class VehicleNotFoundException extends Throwable {
    public VehicleNotFoundException(){
        super("vehicle is not found");
    }
}

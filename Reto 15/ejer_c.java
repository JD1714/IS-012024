//Ejercicio C practica 9.
public class TurnOnDevices {

    public static void main(String[] args) {
   
        turnOnDevice(new Lamp());
        turnOnDevice(new Computer());
    }
   
    private static void turnOnDevice(Connectable device) {
        device.turnOn();
        System.out.println(device.isOn());
    }
}

//Solucion
public class CoffeeMakerAdaptor implements Connectable{
    private CoffeeMaker coffeeMaker = new CoffeeMaker();
   
    public boolean isOn() {
        return ! coffeeMaker.isOff();
    }
   
    public void turnOn() {
        coffeeMaker.on();
    }
   
    public void turnOff() {
        coffeeMaker.off();
    }
   
}

public class TurnOnDevices {
   
    public static void main(String[] args) {
        turnOnDevice(new Lamp());
        turnOnDevice(new Computer());
        turnOnDevice(new CoffeeMakerAdaptor());
    }
   
    private static void turnOnDevice(Connectable device) {
        device.turnOn();
        System.out.println(device.isOn());
    }
}

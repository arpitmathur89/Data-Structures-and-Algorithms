package cerner.patient;

public class Temperature {

    private double temperature;
    private MeasureMethod measureMethod;

    public Temperature(double temp, MeasureMethod measureMethod){
        this.temperature = temperature;
        this.measureMethod = measureMethod;
    }

    public double getTemperature(){
        return temperature;
    }

    public double getCelsius(){
        return ((double)5/9*(temperature-32));
    }

    public double getFahrenheit() {
        return ( temperature * (9/5.0) + 32 );
    }
}

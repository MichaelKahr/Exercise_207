package BL;

import java.io.Serializable;

public class Entry implements Serializable{
    
    private String place;
    private int meter;
    private double temp;
    private int hum;

    public Entry(String place, int meter, double temp, int hum) {
        this.place = place;
        this.meter = meter;
        this.temp = temp;
        this.hum = hum;
    }

    public String getPlace() {
        return place;
    }

    public int getMeter() {
        return meter;
    }

    public double getTemp() {
        return temp;
    }

    public int getHum() {
        return hum;
    }

    public void setTemp(double temp) throws Exception{
        this.temp = temp;
    }

    public void setHum(int hum) throws Exception{
        this.hum = hum;
    }
    
    

}

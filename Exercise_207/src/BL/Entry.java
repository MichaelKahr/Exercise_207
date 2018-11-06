package BL;

import java.io.Serializable;

public class Entry implements Serializable,Comparable{
    
    private String place;
    private int meter;
    private double temp;
    private int hum;

    public Entry(String place, int meter, double temp, int hum) throws Exception{
        this.place = place;
        this.meter = meter;
        setTemp(temp);
        setHum(hum);
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
        if(temp<-35||temp>45){
            throw new Exception("Temperature not possible");
        }
        this.temp = temp;
    }

    public void setHum(int hum) throws Exception{
        if(hum<0||hum>100){
            throw new Exception("Humidity not possible");
        }
        this.hum = hum;
    }

    @Override
    public int compareTo(Object o) {
        Entry e = (Entry)o;
        return this.place.compareToIgnoreCase(e.place);
    }
    
    

}

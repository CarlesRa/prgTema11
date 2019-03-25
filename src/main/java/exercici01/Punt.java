package exercici01;

public class Punt {
    private double x;
    private double y;

    public Punt(){
        x = 0.0;
        y = 0.0;
    }

    public Punt(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" +
                x +
                "," + y
                + ")";
    }

    public double distancia(Punt p2){
        double distancia = Math.sqrt(Math.pow((p2.getX() - this.x),2)
                + Math.pow((p2.getY() - this.y),2));
        return distancia;
    }
}

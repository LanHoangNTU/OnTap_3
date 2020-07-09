package vn.edu.ntu.nguyendinhhoanglan.model;

public class NgoaiTe {
    private String date;
    private String type;
    private int buy;
    private int sell;

    public NgoaiTe(String date, String type, int buy, int sell) {
        this.date = date;
        this.type = type;
        this.buy = buy;
        this.sell = sell;
    }

    public String getDate() {
        return date;
    }

    public String getType() {
        return type;
    }

    public int getBuy() {
        return buy;
    }

    public int getSell() {
        return sell;
    }
}

package logic;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Cost1km {
    int cost;
    int milesOn;

    public Cost1km(int cost, int milesOn)  {
        this.cost = cost;
        this.milesOn = milesOn;
    }

    public float calc() {
        float cost1km  = cost / (float)milesOn;
        cost1km = new BigDecimal(cost1km).setScale(2, RoundingMode.UP).floatValue();
        return cost1km;
    }
}

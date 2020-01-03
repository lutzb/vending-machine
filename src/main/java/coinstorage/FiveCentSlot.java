package main.java.coinstorage;

import main.java.util.Constants;

public class FiveCentSlot implements ICoinSlot {

    private String coinName;
    private int coinValue;
    private int coinCount;

    public FiveCentSlot(int coinCount) {
        this.coinName = Constants.NICKEL;
        this.coinValue = Constants.FIVE_CENTS;
        this.coinCount = coinCount;
    }

    public String getCoinName() {
        return coinName;
    }

    public int getCoinValue() {
        return coinValue;
    }

    public void addCoin() {
        coinCount++;
    }

    public void removeCoin() {
        coinCount--;
    }

    public int getCoinCount() {
        return coinCount;
    }
}

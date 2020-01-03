package main.java.coinstorage;

public interface ICoinSlot {

    public String getCoinName();

    public int getCoinValue();

    public void addCoin();

    public void removeCoin();

    public int getCoinCount();
}

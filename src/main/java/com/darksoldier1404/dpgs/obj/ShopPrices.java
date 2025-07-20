package com.darksoldier1404.dpgs.obj;

public class ShopPrices {
    private int page;
    private int slot;
    private int buyPrice;
    private int sellPrice;

    public ShopPrices(int page, int slot, int buyPrice, int sellPrice) {
        this.page = page;
        this.slot = slot;
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    public int getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(int buyPrice) {
        this.buyPrice = buyPrice;
    }

    public int getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(int sellPrice) {
        this.sellPrice = sellPrice;
    }
}

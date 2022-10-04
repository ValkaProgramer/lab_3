class Profit extends Money{
    private int amount;
    private String currency;    

    public int getAmount() {
        return amount;
    }

    public Profit(){
        this.amount = 0;
    }

    public void Add(int add){
        this.amount += add;
    }
}
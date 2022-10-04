class Menu extends Entity{
    public Beverage[] beverages = new Beverage[5];
    public Menu(){
        this.beverages[0] = new Cappucino();
        this.beverages[1] = new Latte();
        this.beverages[2] = new Frappe();
        this.beverages[3] = new DoubleLatte();
        this.beverages[4] = new IcedCaramelLatte();
    }

    public void get(){
        for (Beverage beverage : beverages) {
            System.out.println(beverage.name);
            System.out.println(beverage.amount + "gr");
            System.out.println(beverage.price + " MDL");
            System.out.println("---------------------------------------");
        }
    }
}
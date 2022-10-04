public class Tips extends Money{

    private int quantity;

    public void getQuantity() {
        System.out.println("Your tips is already " + this.quantity + " " + this.currency + "!!!");
    }

    public void setQuantity(int quantity) {
        this.quantity += quantity;
    }

    public Tips(){
        this.quantity = 0;
    }
    
}

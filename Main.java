import java.util.Random;
import java.util.Date;

class Main{
    public static void main(String[] args){
        Cooldown mainCooldown = new Cooldown();
        Profit todayProfit = new Profit();
        Tips todayTips = new Tips();
        Queue mainQueue = new Queue();
        Date moment = new Date();
        long spawnEnd, workEnd, spawnStart = moment.getTime() / 1000,
        workStart = moment.getTime() / 1000;
        Random rand = new Random();
        int ifVegan, processTime = 100;
        boolean emptiness;
        Menu menuObject = new Menu();
        System.out.print("\033[H\033[2J");
        menuObject.get();
        while(true){
            Date date = new Date();
            spawnEnd = date.getTime() / 1000;
            workEnd = date.getTime() / 1000;
            if(mainCooldown.getInterval() < spawnEnd - spawnStart){
                mainCooldown.setInterval(rand.nextInt(3));
                System.out.println("Next visitor in " + mainCooldown.getInterval() + " seconds!!!");
                spawnStart = spawnEnd;
                emptiness = mainQueue.isEmpty();
                ifVegan = rand.nextInt(2);
                switch(rand.nextInt(8) + 1){
                    case 1: mainQueue.enqueue(ifVegan == 1 ? new Cappucino() : new CappucinoVegan());
                    break;
                    case 2: mainQueue.enqueue(ifVegan == 1 ? new Latte() : new LatteVegan());
                    break;
                    case 3: mainQueue.enqueue(ifVegan == 1 ? new Frappe() : new FrappeVegan());
                    break;
                    case 4: mainQueue.enqueue(ifVegan == 1 ? new DoubleLatte() : new DoubleLatteVegan());
                    break;
                    case 5: mainQueue.enqueue(ifVegan == 1 ? new IcedCaramelLatte() : new IcedCaramelLatteVegan());
                    break;
                    case 6: mainQueue.enqueue(new Lemonade());
                    break;
                    case 7: mainQueue.enqueue(new Milkshake());
                    break;
                    case 8: mainQueue.enqueue(new Smoothie());
                    break;
                    default:
                    break;
                }
                if(emptiness) workStart = date.getTime() / 1000;
            }
            if(mainQueue.isEmpty()){
                System.out.println("Waiting for customers...");
            } else {
                processTime = mainQueue.front().time;
            }
            if(processTime < workEnd - workStart && !mainQueue.isEmpty()){
                mainQueue.dequeue(todayProfit);
                System.out.println("Current profit is " + todayProfit.getAmount() + " " + todayProfit.getCurrency());
                processTime = mainQueue.front().time;
                workStart = workEnd;
                todayTips.setQuantity(rand.nextInt(9));
                todayTips.getQuantity();
            }
        }
    }
}
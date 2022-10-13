import java.util.Scanner;

public class DepositCalculator {

    double calculateComplexPercent(double amount, double yearRate, int depositPeriod) {
        double pay = amount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);
        return round(pay, 2);
    }

    double calculateSimplePercent(double amount, double yearRate, int depositPeriod) {
        return round(amount + amount * yearRate * depositPeriod, 2);
    }

    double round(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }

    void calculateDeposit() {
        int period;
        int action;
        int amount;
        double out = 0; // ++ Как я понял из урока, эту переменную тоже можно переместить вначало метода к другим обяъвлениям переменных
        Scanner scanner = new Scanner(System.in);

        // -- Мне кажется, для улучшения читаемости кода можно разделять переменные ввода пустой строкой
        //Предлагаю оставить вот так, сейчас блок ввода отделён, много пробелов тоже не хорошо
        System.out.println("Введите сумму вклада в рублях:");
        amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:") ;
        period = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();
        
        if (action == 1) {
            out = calculateSimplePercent(amount, 0.06, period);
        } else if (action == 2) {
            out = calculateComplexPercent(amount, 0.06, period);
        }
        
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + out);// ++Думаю, читабельность кода улучшится, если отделить строку вывода пустой строкой
    }
    
    // ++ И здесь я бы поставил пустую строчку
    public static void main(String[] args) {
        new DepositCalculator().calculateDeposit();
    }

}//В остальном, все как учили, молодец!

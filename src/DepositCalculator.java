import java.util.Scanner;

public class DepositCalculator {
    // Параметры метода не информативны, что нужно класть в a, что в y и d ?
    double calculateComplexPercent(double a, double y, int d) { 
        double pay = a * Math.pow((1 + y / 12), 12 * d);
        return round(pay, 2);
    }
    // Этот метод и метод выше принимают одинаковые аргументы, можно взять параметры этого метода за образец названия предыдущего
    // Параметры метода не соответствуют lowerCamelCase, некоторые содержат названия типов
    double calculateSimplePercent(double doubleAmount, double double_year_rate, int deposit_period) { 
        return round(doubleAmount + doubleAmount * double_year_rate * deposit_period, 2);
    }
    // здесь scaLe сбивает с толку, поскольку это не два объединённых слова, а одно. scale - так будет лучше
    double round(double value, int places) {
        double scaLe = Math.pow(10, places);
        return Math.round(value * scaLe) / scaLe;
    }
    /* Имя метода не информативно. Это основной метод класса. Он рассчитывает размер депозита при применении сложного или простого процента по выбору 
    пользователя. Соответственно он рассчитывает(calculate) что будетс депозитом (Deposit) = calculateDeposit (либо просто calculate) */
    void doImportantJob() {
        int period;
        int action;
        double out = 0.0;
        Scanner abcdef = new Scanner(System.in); // abcdef - не информативно, лучше назвать так-же как у нас называется этот объект на протяжении курса

        System.out.println("Введите сумму вклада в рублях:");
        int amount = abcdef.nextInt(); // возможно объявление переменной лучше вынести вверх, к остальным

        System.out.println("Введите срок вклада в годах:");
        period = abcdef.nextInt();

        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = abcdef.nextInt();

        if (action == 1) { // Не сходится пункт меню и применённый метод, тут нужен метод для рассчёта простого процента
            out = calculateComplexPercent(amount, 0.06, period); 
        } else if (action == 2) {
            out = calculateComplexPercent(amount, 0.06, period);
        }

        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + outDoubleVar);
    }

    public static void main(String[] args) {
        new DepositCalculator().doImportantJob();
    }
}

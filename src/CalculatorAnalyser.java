public class CalculatorAnalyser {


    // Вывод всей информации о числе.
    public static void printInfoNum(int number) {
        if (number > 0) {
            System.out.println("Число положительное");
        } else if (number == 0) {
            System.out.println("Число является нулём");
        } else {
            System.out.println("Число отрицательное");
        }

        if (number % 2 == 0) {
            System.out.println("Число чётное");
        } else {
            System.out.println("Число нечётное");
        }

        System.out.printf("Количество цифр в числе %d = %d\n", number, getCountDigits(number));
        System.out.printf("Сумма чисел от 1 до %d = %d\n", number, getSumNum(number));

        getFactorial(number);
        printTableMultiplication(number);
        System.out.println("\nТаблица умножения для числа: ");

    }

    // Вывод таблицы умножения от 1 до 10 для числа
    private static void printTableMultiplication(int number) {
        for (int i = 1; i < 11; i++) {
            if (i % 3 == 1) {
                System.out.println();
            }
            System.out.printf("%d * %d = %d | ", i, number, i * number);
        }
    }


    // Получение суммы чисел от 1 до N
    private static int getSumNum(int number) {
        int sum = 0;

        for (int i = 1; i <= number; i++) {
            sum += i;
        }

        return sum;
    }

    // Получение количества цифр в числе
    private static int getCountDigits(int number) {
        int count = 1;
        int userNum = Math.abs(number);

        if (userNum < 10) {
            return 1;
        } else {

            while (userNum > 10) {
                userNum = userNum / 10;
                count++;
            }
        }
        return count;
    }

    // Получение факториала числа
    private static void getFactorial(int number) {
        int fact = 1;

        if (number < 0) {
            System.out.println("Факториал для отрицательного числа в математике не определён.");
        } else if (number == 0) {
            System.out.println("Факториал числа 0 равен 1");
            return;
        } else {
            for (int i = 1; i <= number; i++) {
                fact *= i;
            }
        }

        System.out.printf("Факториал числа %d равен - %d\n", number, fact);
    }
}

import java.util.Arrays;
import java.util.Scanner;

public class ConsoleHelperStudents {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static boolean isInitialized = false;

    private static int[] marks;
    private static int countMarks;

    private static int minMark;
    private static int maxMark;

    private static double averageMark;
    private static boolean isHaveWeakMarks = false;
    private static double averageMarkIgnoreWeakMark;

    private static int countFiveMark;
    private static int countThreeMark;

    private static String name;
    private static String item;
    private static String markStudent;


    // Общая оценка ученика
    private static void getMarkStudent() {
        if (averageMark > 4.6) {
            markStudent = "Отлично";
        } else if (averageMark > 3.8) {
            markStudent = "Нормально";
        } else {
            markStudent = "Нужно подтянуть";
        }
    }

    // Вычисление кол-ва троек и пятерок
    private static void getCountMarks() {
        for (int mark : marks) {
            if (mark == 3) {
                countThreeMark++;
            } else if (mark == 5) {
                countFiveMark++;
            }
        }
    }


    // Вычисление средней, минимальной, максимальной оценки
    private static void calculateMark() {
        // сортируем массив
        for (int i = 0; i < marks.length - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < marks.length - i - 1; j++) {
                if (marks[j] > marks[j + 1]) {
                    swap(j, j + 1);
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }
        minMark = marks[0];
        maxMark = marks[marks.length - 1];
    }

    // Вычисление средних баллов
    private static void calculateAverageMark() {
        int allSum = 0;

        // Вычисление суммы баллов всех оценок
        for (int mark : marks) {
            allSum += mark;
        }


        if (marks[0] < 4 && marks[marks.length - 1] > marks[0]) {
            isHaveWeakMarks = true;
        }

        if (isHaveWeakMarks) {
            calculateAverageIgnoreWeakMark();
        }
        averageMark = (double) allSum / marks.length;

    }

    // Вычисление средней оценки без учета слабой оценки
    private static void calculateAverageIgnoreWeakMark() {
        int minMark = marks[0];
        int minIndex = 0;
        int sumMark = 0;

        for (int i = 0; i < marks.length; i++) {
            if (marks[i] > minMark) {
                minIndex = i;
                break;
            }
        }

        for (int i = minIndex; i < marks.length; i++) {
            sumMark += marks[i];
        }

        averageMarkIgnoreWeakMark = (double) sumMark / (marks.length - minIndex);
    }

    // свап ячеек
    private static void swap(int first, int second) {
        int current = marks[first];
        marks[first] = marks[second];
        marks[second] = current;
    }

    // Инициализация полей
    public static void initialize() {
        System.out.print("Введите имя ученика: ");
        name = SCANNER.nextLine().trim();

        System.out.print("Введите предмет учащегося: ");
        item = SCANNER.nextLine().trim();

        System.out.print("Введите количество оценок: ");
        countMarks = Integer.parseInt(SCANNER.nextLine().trim());

        System.out.print("Введите оценки учащегося через пробел, пример: 5 5 4 4 3 3 2\n");

        marks = new int[countMarks];
        String userMarks = SCANNER.nextLine();
        String[] studentMarks = userMarks.trim().split(" ");

        if (studentMarks.length != countMarks) {
            System.out.println("Количество введенных оценок не совпадает со значениям кол-ва оценок");
            return;
        } else {
            for (int i = 0; i < studentMarks.length; i++) {
                marks[i] = Integer.parseInt(studentMarks[i]);
            }
        }

        getMarkStudent();
        calculateMark();
        getCountMarks();
        calculateAverageMark();

        System.out.println("Инициализация успешна");
        isInitialized = true;

    }

    // Вывод информации
    public static void printInfoOfStudent() {
        if (!isInitialized) {
            System.out.println("Прежде чем выводить оценки надо провести инициализацию полей");
        } else {

            System.out.printf("\nИмя ученика - %s, предмет учащегося - %s\n", name, item);

            System.out.println("Оценки = " + Arrays.toString(marks));
            System.out.println("Количество оценок = " + countMarks);
            System.out.printf("Минимальная оценка = %d, максимальная = %d\n", minMark, maxMark);
            System.out.println("Средняя оценка ученика = " + averageMark);

            if (!isHaveWeakMarks) {
                System.out.println("У ученика нет слабых оценок.");
            } else {
                System.out.println("Средний балл ученика без учета \"слабой оценки\" = " + averageMarkIgnoreWeakMark);
            }

            System.out.printf("Количество пятерок = %d, количество троек = %d\n", countFiveMark, countThreeMark);
            System.out.println("Общая оценка ученика: " + markStudent);
        }
    }


}

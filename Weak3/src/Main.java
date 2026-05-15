import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final ArrayList<Task> tasks = new ArrayList<>();

    public static void main(String[] args) {
        initializeTasks();

        System.out.println("Общий список всех задач: ");
        ControlTask.printTasks(tasks);

        System.out.println("Количество выполненных задач - " + ControlTask.countDoneTasks(tasks));
        System.out.println("Количество  не выполненных задач - " + ControlTask.countNotDoneTasks(tasks));

        System.out.println("Первая не выполненная задача: " + ControlTask.findFirstImportantNotDoneTask(tasks));
        System.out.println("Средний приоритет по задачам: " + ControlTask.averagePriority(tasks));

        System.out.println("Проверяем есть ли например \"посуда\" в нашем списке задач: " + ControlTask.containsWord(tasks, "посуда"));
        System.out.println("Заключение исходя из ваших задач: " + ControlTask.getSummary(tasks));

        System.out.println("Удаление по индексу, сейчас выведем первую задачу: " + tasks.getFirst());
        ControlTask.deleteTaskByIndex(tasks, 0);
        System.out.println("Теперь выводим задачу которая пришла на место удаленной: " + tasks.getFirst());

        System.out.println("Отсортируем по приоритету...");
        ControlTask.sortByPriority(tasks);
        System.out.println("Выводим отсортированный по приоритету список: ");
        ControlTask.printTasks(tasks);
    }

    private static void initializeTasks() {
        System.out.print("Введите количество задач: ");
        int countTask = Integer.parseInt(SCANNER.nextLine());

        if (countTask <= 0) {
            throw new RuntimeException("Нельзя создавать пустой список или с отрицательным значением");
        }

        for (int i = 0; i < countTask; i++) {
            System.out.print("Введите описание задачи: ");
            String descriptionTask = SCANNER.nextLine();


            System.out.print("Введите приоритет задачи: ");
            int priorityTask = Integer.parseInt(SCANNER.nextLine());

            System.out.print("Введите цифру обозначающую статус задачи\n" +
                    "1 - В ожидании, 2 - Делается сейчас, 3 - Выполнена: ");
            int statusTask = Integer.parseInt(SCANNER.nextLine());

            switch (statusTask) {
                case 1:
                    tasks.add(new Task(descriptionTask, priorityTask, StatusTask.WAITING));
                    break;
                case 2:
                    tasks.add(new Task(descriptionTask, priorityTask, StatusTask.INPROGRESS));
                    break;
                case 3:
                    tasks.add(new Task(descriptionTask, priorityTask, StatusTask.COMPLETED));
                    break;
            }
        }
    }
}

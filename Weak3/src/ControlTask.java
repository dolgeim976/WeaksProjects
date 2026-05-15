import java.util.ArrayList;
import java.util.Comparator;

public class ControlTask {


    // Вывод всего списка задач
    public static void printTasks(ArrayList<Task> tasks) {
        System.out.println();

        for (Task task : tasks) {
            System.out.printf("\tЗадача: %s --- Приоритет: %d --- Статус задачи: %s\n",
                    task.getDescription(), task.getPriority(), task.getStatus());
        }

        System.out.println();
    }

    // возвращает количество выполненных задач
    public static int countDoneTasks(ArrayList<Task> tasks) {
        return Math.toIntExact(tasks.stream().filter(x -> x.getStatus().equals(StatusTask.COMPLETED)).count());
    }

    // возвращает количество невыполненных задач
    public static int countNotDoneTasks(ArrayList<Task> tasks) {
        return Math.toIntExact(tasks.stream().filter(x -> x.getStatus().equals(StatusTask.INPROGRESS) || x.getStatus().equals(StatusTask.WAITING)).count());
    }

    //  возвращает первую важную не выполненную задачу
    public static Task findFirstImportantNotDoneTask(ArrayList<Task> tasks) {
        return tasks.stream().filter(x -> x.getStatus() != StatusTask.COMPLETED).max(Comparator.comparingInt(Task::getPriority)).orElse(null);
    }

    // возвращает средний приоритет
    public static double averagePriority(ArrayList<Task> tasks) {
        return (double) tasks.stream().mapToInt(Task::getPriority).sum() / tasks.size();
    }

    // возвращает булево обозначение
    public static boolean containsWord(ArrayList<Task> tasks, String word) {
        return tasks.stream().anyMatch(x -> x.getDescription().toLowerCase().contains(word.toLowerCase()));
    }

    // возвращает суммарную информацию в виде текста
    public static String getSummary(ArrayList<Task> tasks) {
        if (tasks.isEmpty()) {
            return "список пуст";
        }

        int load = Math.toIntExact(tasks.stream().filter(x -> x.getStatus().equals(StatusTask.WAITING) || x.getStatus().equals(StatusTask.INPROGRESS)).count() * tasks.size());

        if (load >= 0.5) {
            return "дел слишком много";
        } else {
            return "нагрузка нормальная";
        }

    }

    // удаление задачи по индексу
    public static void deleteTaskByIndex(ArrayList<Task> tasks, int index) {
        tasks.remove(index);
    }

    // сортировка по приоритету
    public static void sortByPriority(ArrayList<Task> tasks) {
        for (int i = 0; i < tasks.size() - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < tasks.size() - i - 1; j++) {
                if (tasks.get(j).getPriority() > tasks.get(j + 1).getPriority()) {
                    swap(tasks, j, j + 1);
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }
    }

    private static void swap(ArrayList<Task> tasks, int first, int second) {
        Task current = tasks.get(first);
        tasks.set(first, tasks.get(second));
        tasks.set(second, current);
    }

}

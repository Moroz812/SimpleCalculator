import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator6 {
    public static void main(String[] args) {
        Calculate2 calculate = new Calculate2(); // Создаём экземпляр Calculate

        //добавлен новый режим, для запуска калькулятора в терминале и передачи аргументов в качестве параметров при запуске
        // Если есть аргументы - выполняем одну операцию и выходим
        if (args.length >= 3) {
            try {
                int num1 = Integer.parseInt(args[0]);
                char operator = args[1].charAt(0);
                int num2 = Integer.parseInt(args[2]);

                int result = calculate.calculate(num1, num2, operator);
                System.out.println(num1 + " " + operator + " " + num2 + " = " + result);
                return;
            } catch (Exception e) {

                // System.err.println("Ошибка: " + e.getMessage());
                System.err.println("Использование: java Calculator <число1> <оператор> <число2>");
                return;
            }
        }

        //History history = new History(); //создаём экземпляр history
        Scanner scanner = new Scanner(System.in);
        //Calculate calculate = new Calculate(); // Создаём экземпляр Calculate

        int result = 0;  // Результат предыдущей операции
        //boolean continueCalculating = true;

        while (true) {
            try {
                if (result == 0) {
                    // Если это первая операция, просим ввести первое число
                    System.out.print("Введите первое число: ");
                    result = scanner.nextInt();

                }

                // Просим выбрать оператор
                System.out.print("Введите оператор (+, -, *, /) или 'q' для выхода или 'h' для истории: ");
                char operator = scanner.next().charAt(0);

                // Если введено 'q', выходим из цикла
                if (operator == 'q' || operator == 'Q') {
                    System.out.println("Выход из калькулятора.");
                    break;
                } else if (operator == 'h' || operator == 'H') {
                    calculate.history.printHistory(); // Вывод истории
                    continue;
                }

                // Вводим второе число
                System.out.print("Введите второе число: ");
                int num2 = scanner.nextInt();

                // Выполняем операцию и выводим результат
                //int oldResult = result; // Сохраняем предыдущий результат
                result = calculate.calculate(result, num2, operator);
                System.out.println("Результат: " + result);

                //history.saveHistory(oldResult, operator, num2, result);

            } catch (InputMismatchException e) {
                System.err.println("Ошибка: Введите числовые значения для операндов.");
                scanner.nextLine();  // Очистка буфера ввода
            } catch (ArithmeticException | IllegalArgumentException e) {
                System.err.println("Ошибка: " + e.getMessage());
            }
        }
        scanner.close();
    }
}
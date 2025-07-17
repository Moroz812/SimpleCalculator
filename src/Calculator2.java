import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int result = 0;  // Результат предыдущей операции
        boolean continueCalculating = true;

        while (continueCalculating) {
            try {
                if (result == 0) {
                    // Если это первая операция, просим ввести первое число
                    System.out.print("Введите первое число: ");
                    result = scanner.nextInt();
                }

                // Просим выбрать оператор
                System.out.print("Введите оператор (+, -, *, /) или 'q' для выхода: ");
                char operator = scanner.next().charAt(0);

                // Если введено 'q', выходим из цикла
                if (operator == 'q' || operator == 'Q') {
                    System.out.println("Выход из калькулятора.");
                    break;
                }

                // Вводим второе число
                System.out.print("Введите второе число: ");
                int num2 = scanner.nextInt();

                // Выполняем операцию и выводим результат
                result = Operations.calculate(result, num2, operator);
                System.out.println("Результат: " + result);

            } catch (InputMismatchException e) {
                System.err.println("Ошибка: Введите числовые значения для операндов.");
                scanner.nextLine();  // Очистка буфера ввода
            } catch (ArithmeticException e) {
                System.err.println("Ошибка: " + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.err.println("Ошибка: " + e.getMessage());
            }
        }
        scanner.close();
    }
}
import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {

public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    try {
        System.out.print("Введите первое число: ");
        int num1 = scanner.nextInt();

        System.out.print("Введите оператор (+, -, *, /): ");
        char operator = scanner.next().charAt(0);

        System.out.print("Введите второе число: ");
        int num2 = scanner.nextInt();

        int result = Operations.calculate(num1, num2, operator);
        System.out.println("Результат: " + result);

    } catch (InputMismatchException e) {
        System.err.println("Ошибка: Введите числовые значения для операндов.");
    } catch (ArithmeticException e) {
        System.err.println("Ошибка: " + e.getMessage());
    } catch (IllegalArgumentException e) {
        System.err.println("Ошибка: " + e.getMessage());
    } finally {
        scanner.close();
    }
}
}
public class Operations {
    public static int calculate(int num1, int num2, char operator) {
        switch (operator) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                if (num2 == 0) {
                    throw new ArithmeticException("Деление на ноль недопустимо.");
                }
                return num1 / num2;
            default:
                throw new IllegalArgumentException("Неподдерживаемый оператор: " + operator);
        }
    }
}
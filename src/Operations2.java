public class Operations2 {

    //метод для сложения
    public int summa (int num1, int num2) {
        return num1 + num2;
    }
    //метод для вычитания
    public int raznost (int num1, int num2) {
        return num1 - num2;
    }
    //метод для умножения
    public int proizvedenie (int num1, int num2) {
        return num1 * num2;
    }
    //метод для деления с проверкой на деление на ноль
    public int chastnoe (int num1, int num2) {
        if (num2 == 0) {
            throw new ArithmeticException("Деление на ноль недопустимо.");
        }
        return num1 / num2;
    }

    public int calculate(int num1, int num2, char operator) {
        switch (operator) {
            case '+':
                return summa(num1, num2);
            case '-':
                return raznost(num1, num2);
            case '*':
                return proizvedenie(num1, num2);
            case '/':
                return chastnoe(num1, num2);
            default:
                throw new IllegalArgumentException("Неподдерживаемый оператор: " + operator);
        }
    }
}
public class History {
    String[] history = new String[10]; // Массив для хранения 10 операций
    int operationCount = 0; // Сколько операций уже сохранено

    // Сохраняем операцию в массив history
    public void saveHistory(int num1, char operator, int num2, int result) {
        String entry = num1 + " " + operator + " " + num2 + " = " + result;
        if (operationCount < 10) {
            history[operationCount] = entry; // Добавляем в конец
        } else {
            // Сдвигаем все элементы влево (удаляем самую старую операцию)
            for (int i = 0; i < 9; i++) {
                history[i] = history[i + 1];
            }
            history[9] = entry; // Добавляем новую в конец
        }

        if (operationCount < 10) {
            operationCount++; // Увеличиваем счётчик, пока массив не заполнился
        }
    }

    // Выводим историю операций
    public void printHistory() {
        if (operationCount == 0) {
            System.out.println("История операций пуста.");
            return;
        }

        System.out.println("\n--- История операций ---");
        for (int i = 0; i < operationCount; i++) {
            System.out.println(history[i]);
        }
    }
}

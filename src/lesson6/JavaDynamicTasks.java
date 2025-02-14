package lesson6;

import kotlin.NotImplementedError;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.max;

@SuppressWarnings("unused")
public class JavaDynamicTasks {
    /**
     * Наибольшая общая подпоследовательность.
     * Средняя
     * <p>
     * Дано две строки, например "nematode knowledge" и "empty bottle".
     * Найти их самую длинную общую подпоследовательность -- в примере это "emt ole".
     * Подпоследовательность отличается от подстроки тем, что её символы не обязаны идти подряд
     * (но по-прежнему должны быть расположены в исходной строке в том же порядке).
     * Если общей подпоследовательности нет, вернуть пустую строку.
     * Если есть несколько самых длинных общих подпоследовательностей, вернуть любую из них.
     * При сравнении подстрок, регистр символов *имеет* значение.
     */
    // Трудоемкость и ресурсоемкость - O(n*m), n и m - длины строк
    public static String longestCommonSubSequence(String first, String second) {
        // находим длину
        int[][] maxLength = new int[first.length() + 1][second.length() + 1];
        for (int i = 1; i <= first.length(); i++) {
            for (int j = 1; j <= second.length(); j++) {
                if (first.charAt(i - 1) == second.charAt(j - 1))
                    maxLength[i][j] = maxLength[i - 1][j - 1] + 1;
                else maxLength[i][j] = max(maxLength[i - 1][j], maxLength[i][j - 1]);
            }
        }
        // теперь саму общую подпоследовательность, то есть восстанавливаем ответ
        StringBuilder result = new StringBuilder();
        int i = first.length();
        int j = second.length();
        while (i > 0 && j > 0) {
            if (first.charAt(i - 1) == second.charAt(j - 1)) {
                result.insert(0, first.charAt(i - 1));
                i--;
                j--;
            } else if (maxLength[i - 1][j] == maxLength[i][j])
                i--;
            else
                j--;
        }
        return result.toString();
    }

    /**
     * Наибольшая возрастающая подпоследовательность
     * Сложная
     * <p>
     * Дан список целых чисел, например, [2 8 5 9 12 6].
     * Найти в нём самую длинную возрастающую подпоследовательность.
     * Элементы подпоследовательности не обязаны идти подряд,
     * но должны быть расположены в исходном списке в том же порядке.
     * Если самых длинных возрастающих подпоследовательностей несколько (как в примере),
     * то вернуть ту, в которой числа расположены раньше (приоритет имеют первые числа).
     * В примере ответами являются 2, 8, 9, 12 или 2, 5, 9, 12 -- выбираем первую из них.
     */
    // Трудоемкость - O(n^2), Ресурсоемкость - O(n), n - длина листа
    public static List<Integer> longestIncreasingSubSequence(List<Integer> list) {
        // находим длину
        int startSize = list.size();
        int[] maxLength = new int[startSize];
        int[] previous = new int[startSize];
        for (int i = 0; i < startSize; i++) {
            maxLength[i] = 1;
            previous[i] = -1;
            for (int j = 0; j < i; j++) {
                if (list.get(j) < list.get(i) && maxLength[j] + 1 > maxLength[i]) {
                    maxLength[i] = maxLength[j] + 1;
                    previous[i] = j;
                }
            }
        }
        int position = 0;
        int length = 0;
        for (int i = 0; i < startSize; i++) {
            if (maxLength[i] > length) {
                position = i;
                length = maxLength[i];
            }
        }
        // восстанавливаем ответ
        List<Integer> result = new ArrayList<>();
        if (list.isEmpty()) return result;
        while (position != -1) {
            result.add(0, list.get(position));
            position = previous[position];
        }
        return result;
    }

    /**
     * Самый короткий маршрут на прямоугольном поле.
     * Средняя
     * <p>
     * В файле с именем inputName задано прямоугольное поле:
     * <p>
     * 0 2 3 2 4 1
     * 1 5 3 4 6 2
     * 2 6 2 5 1 3
     * 1 4 3 2 6 2
     * 4 2 3 1 5 0
     * <p>
     * Можно совершать шаги длиной в одну клетку вправо, вниз или по диагонали вправо-вниз.
     * В каждой клетке записано некоторое натуральное число или нуль.
     * Необходимо попасть из верхней левой клетки в правую нижнюю.
     * Вес маршрута вычисляется как сумма чисел со всех посещенных клеток.
     * Необходимо найти маршрут с минимальным весом и вернуть этот минимальный вес.
     * <p>
     * Здесь ответ 2 + 3 + 4 + 1 + 2 = 12
     */
    public static int shortestPathOnField(String inputName) {
        throw new NotImplementedError();
    }

    // Задачу "Максимальное независимое множество вершин в графе без циклов"
    // смотрите в уроке 5
}

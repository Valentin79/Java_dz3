import java.util.ArrayList;

public class вопросики {
    static char[] textGlobal;
    static ArrayList<Integer> signIndexesGlobal = new ArrayList<>();

    public static void main(String[] args) {
        String text = "5? + 1? = ??";
        ArrayList<Integer> signIndexes = new ArrayList<>();
        char[] textChars = text.replaceAll(" ", "").toCharArray();

        for (int i = 0; i < textChars.length; i++) {
            if (textChars[i] == '+' || textChars[i] == '=') {
                textChars[i] = '-';
            }
            if (textChars[i] == '?') {
                signIndexes.add(i);
            }
        }

        textGlobal = textChars;
        signIndexesGlobal = signIndexes;

        generateComb(new int[signIndexes.size()], 0, 9);
    }

    private static void generateComb(int[] arrays, int index, int k) {
        if (index == arrays.length) {
            chekComb(arrays);
            return;
        }
        for (int i = 0; i <= k; i++) {
            arrays[index] = i;
            generateComb(arrays, index + 1, k);
        }
    }

    private static void chekComb(int[] arrays) {
        for (int i = 0; i < arrays.length; i++) {
            textGlobal[signIndexesGlobal.get(i)] = Character.forDigit(arrays[i], 10);
        }
        String[] numbers = String.valueOf(textGlobal).split("-");

        int a = Integer.parseInt(numbers[0]);
        int b = Integer.parseInt(numbers[1]);
        int c = Integer.parseInt(numbers[2]);

        if (a + b == c) {
            System.out.printf("%d + %d = %d", a, b, c);
            System.out.println();

        }
    }
}
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Caesar {

    protected static final char[] ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з',
            'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э', 'ю', 'я', 'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё', 'Ж', 'З', 'И', 'Й', 'К', 'Л', 'М',
            'Н', 'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ъ', 'Ы', 'Ь', 'Э', 'Ю', 'Я',
            '.', ',', '«', '»', '"', '\'', ':', ';', '!', '?', '-', '_', ' ', '%', '(', ')', '}', '{'};
    private static char[] textChar;
    private static ArrayList<Character> arrayList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(" 1 - Зашифровка \n 2 - Расшифровка \n 3 - Взлом");
        System.out.print("Введите номер команды: ");
        int poz = sc.nextInt();

        System.out.println("Введите ссылку на текст: ");

        try (Scanner scan = new Scanner(System.in);
             BufferedReader bufferedReader = new BufferedReader(new FileReader(scan.nextLine()));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(scan.nextLine()))) {


            while (bufferedReader.ready()) {
                String line = bufferedReader.readLine();
                textChar = line.toCharArray();


                if (poz == 1 || poz == 2) {

                    System.out.println("ключ: ");
                    int key = sc.nextInt();

                    if (poz == 1) {

                        char[] econ = Encryption.econ(textChar, key);
                        for (char a : econ) {
                            arrayList.add(a);
                        }

                    }

                   else if (poz == 2) {
                        char[] econ = Decryption.decon(textChar, key);
                        for (char a : econ) {
                            arrayList.add(a);
                        }

                    }
                }


               else if (poz == 3) {

                    for (char a : textChar) {
                        arrayList.add(a);
                    }

                    char[] aa = new char[arrayList.size()];   // из листа в массив
                    for (int i = 0; i < arrayList.size(); i++) {
                        aa[i] = arrayList.get(i);
                    }

                    for (int i = 1; i <= ALPHABET.length; i++) {

                        bufferedWriter.write("Взломанный текст: \"");

                        for (char a : Decryption.decon(aa, i)) {
                            bufferedWriter.write(a);

                        }
                        bufferedWriter.write("\" - Номер ключа: " + i);
                        bufferedWriter.write("\n");
                        bufferedWriter.write("\n");
                    }

                }
            }

            if (poz == 1 || poz == 2) {
                for (char a : arrayList) {

                    bufferedWriter.write(a);
                }
            }


        } catch (
                Exception e) {
            e.printStackTrace();
        }

    }

}





public class Encryption {
    public static char[] econ(char[] text, int shift) {

        char[] newText = new char[text.length];

        for (int i = 0; i < text.length; i++) {

            for (int j = 0; j < Caesar.ALPHABET.length; j++)
                if (Caesar.ALPHABET[j] == text[i]) {
                    newText[i] = Caesar.ALPHABET[(j + shift) % Caesar.ALPHABET.length];
                }
        }
        return newText;
    }
}
//  C:\Users\Aleksandr\IdeaProjects\com.javarush.cryptoanalyzer.Sibrikov
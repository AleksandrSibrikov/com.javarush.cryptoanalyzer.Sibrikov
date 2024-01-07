public class Decryption {

    public static char[] decon(char[] text, int shift) {

        char[] newText = new char[text.length];

        for (int i = 0; i < text.length; i++) {

            for (int j = 0; j < Caesar.ALPHABET.length; j++)
                if (Caesar.ALPHABET[j] == text[i]) {

                    int deVal = j - shift;

                    if (deVal < 0) {
                        deVal = Caesar.ALPHABET.length + deVal;
                    }
                    newText[i] = Caesar.ALPHABET[(deVal) % Caesar.ALPHABET.length];

                }
        }
        return newText;
    }
}

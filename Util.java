package pokemon;

import java.util.Scanner;

public class Util {
    public static int lerInteiro(String mensagem) {
        System.out.print(mensagem);
        return new Scanner(System.in).nextInt();
    }
}
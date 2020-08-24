package Lesson_3.Password;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pw {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите пароль : ");
        String name = in.nextLine();
        in.close();

        if (pwValidator(name)) System.out.println("Ок. Пароль принят.");
        else System.out.println("Пароль не принят!");
    }

    private static  Boolean pwValidator(String s) {
        Pattern pattern = Pattern.compile("^(?=.{8,20})(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).*$");
        Matcher matcher = pattern.matcher(s);
        return matcher.matches();
    }
}
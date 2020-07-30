package view;

import java.util.Scanner;

public class Input {
    private static Scanner scanner = new Scanner(System.in);

    public static int getInt(){
        if (scanner.hasNextInt()){
            int num = scanner.nextInt();
            scanner.nextLine();
            return num;
        }
        System.out.println(scanner.nextLine() + "- вы ввели, а не число. Повторите ввод");
        return getInt();
    }

    public static int getInt(String message){
        System.out.println(message);
        return getInt();
    }

    public static String getString(){
        return scanner.nextLine();
    }

    public static String getString(String message){
        System.out.println(message);
        return getString();
    }

    public static double getDouble(){
        if (scanner.hasNextDouble()){
            double num = scanner.nextDouble();
            scanner.nextLine();
            return num;
        }
        System.out.println(scanner.nextLine() + "- вы ввели, а не число. Повторите ввод");
        return getDouble();
    }

    public static double getDouble(String message){
        System.out.println(message);
        return getDouble();
    }

    public static boolean getBoolean(){
        if (scanner.hasNextBoolean()){
            boolean isBool = scanner.nextBoolean();
            scanner.nextLine();
            return isBool;
        }
        System.out.println(scanner.nextLine() + "- вы ввели, а не число. Повторите ввод");
        return getBoolean();
    }

    public static boolean getBoolean(String message){
        System.out.println(message);
        return getBoolean();
    }
}

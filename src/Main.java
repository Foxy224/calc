import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите выражение");
        String string = scan.nextLine();
        System.out.println(calc(string));

    }

    public static String calc(String input) {
        String res = "";
        String[] strings = input.split(" ");


        if (strings.length < 3) {
            try {
                throw new IOException();
            } catch (IOException e) {
                System.out.println("Строка не является математической операцией");
            }
            System.exit(0);
        }

        if (strings[0].matches("[0-9]+") && strings[2].matches("[0-9]+")) {
             res = arab(strings);

        }
        else if (strings[0].matches("[A-Z]+") && strings[2].matches("[A-Z]+")){
            res=rim(strings);
        }
        else {
            try {throw new IOException();} catch (IOException e) {
                System.out.println("Разные системы счисления");
            }
            System.exit(0);
        }

        return res;


    }

    public static String arab(String[] input){
        String result = "";
        String[] in = input;
        int operand1 = Integer.parseInt(in[0]);
        int operand2 = Integer.parseInt(in[2]);
        if (operand1 > 10 | operand2 > 10 | operand1 <= 0 | operand2 <= 0) {
            try {
                throw new IOException();
            } catch (IOException e) {
                System.out.println("Цифра(ы) не входит(ят) в диапозон");
            }
            System.exit(0);
        }
        if (in.length > 4) {
            try {
                throw new IOException();
            } catch (IOException e) {
                System.out.println("Больще двух операндов и/или больше одного оператора");
            }
            System.exit(0);
        }
        switch (in[1]) {
            case "+": result = String.valueOf(operand1 + operand2);
                break;
            case "-": result = String.valueOf(operand1 - operand2);
                break;
            case "/": result = String.valueOf(operand1 / operand2);
                break;
            case "*": result = String.valueOf(operand1 * operand2);
                break;
            default: try {throw new IOException();} catch (IOException e) {System.out.println("Неизвестный оператор");}

        }

        return  result;
    }


    public static String rim(String[] input){
        String[] rom = input;
        String result = "";
        String operand1 = rom[0];
        String operand2 = rom[2];
        int a=0;
        int b=0;
        int n;
        String[] rom2 = new String[]{"I","II","III", "IV", "V", "VI" ,"VII", "VIII" ,"IX", "X" ,"XI" ,"XII","XIII" ,
                "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI" ,"XXII" ,"XXIII" ,"XXIV" ,"XXV" ,"XXVI" ,"XXVII"
                ,"XXVIII" ,"XXIX", "XXX" ,"XXXI" ,"XXXII" ,"XXXIII" ,"XXXIV", "XXXV", "XXXVI" ,"XXXVII", "XXXVIII",
                "XXXIX", "XL", "XLI", "XLII" ,"XLIII", "XLIV", "XLV" ,"XLVI", "XLVII", "XLVIII", "XLIX" ,"L" ,"LI" ,
                "LII" ,"LIII", "LIV" ,"LV", "LVI" ,"LVII" ,"LVIII" ,"LIX" ,"LX" ,"LXI" ,"LXII", "LXIII" ,"LXIV", "LXV"
                ,"LXVI" ,"LXVII" ,"LXVIII" ,"LXIX", "LXX" ,"LXXI" ,"LXXII", "LXXIII" ,"LXXIV" ,"LXXV" ,"LXXVI" ,
                "LXXVII" ,"LXXVIII" ,"LXXIX", "LXXX", "LXXXI" ,"LXXXII" ,"LXXXIII" ,"LXXXIV" ,"LXXXV" ,"LXXXVI" ,
                "LXXXVII", "LXXXVIII", "LXXXIX" ,"XC" ,"XCI" ,"XCII" ,"XCIII" ,"XCIV" ,"XCV" ,"XCVI" ,"XCVII" ,"XCVIII"
                ,"XCIX" ,"C"};

        if (rom.length > 4) {
            try {throw new IOException();} catch (IOException e) {
                System.out.println("Больще двух операндов и/или больше одного оператора");}
            System.exit(0);
            }

        for(int i = 0; i < 10; i++ ){ if(rom[0].equals(rom2[i])) { a = i+1; } }
        if(a == 0){{try {throw new IOException();} catch (IOException e) {System.out.println("Неверный диапазон");}
            System.exit(0);}}
        for(int i = 0; i < 10; i++ ){ if(rom[2].equals(rom2[i])) { b = i+1; } }
        if(b == 0){{try {throw new IOException();} catch (IOException e) {System.out.println("Неверный диапазон");}
            System.exit(0);}}
        switch (rom[1]){
            case "+": n = a + b - 1; result = rom2[n];
                break;
            case "-": if(a-b >= 1){n = a - b - 1; result = rom2[n];} else {try {throw new IOException();}
            catch (IOException e) {System.out.println("В римской системе счисления нет цифр меньше единицы ");} System.exit(0);}
                break;
            case "/": if(a/b >= 1){n = a / b - 1; result = rom2[n];} else {try {throw new IOException();}
            catch (IOException e) {System.out.println("В римской системе счисления нет цифр меньше единицы ");} System.exit(0);}
                break;
            case "*": n = a * b - 1; result = rom2[n];
                break;
            default: try {throw new IOException();} catch (IOException e) {System.out.println("Неизвестный оператор");}
        }
        return  result;
    }

}
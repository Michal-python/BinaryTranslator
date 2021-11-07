import java.util.Scanner;

public class BinaryTranslator {
    public static void main(String[] args) {
        System.out.println("BinaryTranslator");
        while (true) {
            System.out.println("""
                    1 - Zamień liczbę w systemie dziesiętnym na liczbę w systemie dwójkowym
                    2 - Zamień liczbę w systemie dwójkowym na liczbę w systemie dziesiętnym
                    3 - wyjdź z programu""");
            int option = new Scanner(System.in).nextInt();
            String num = null;
            if(option < 3) {
                System.out.println(
                        "Podaj "+ (option == 1 ? "liczbę w systemie dziesiętnym" : "liczbę w systemie dwójkowym")
                );
                num = new Scanner(System.in).next();
            }
            switch (option) {
                case 1 -> System.out.println("Wynik: "+toBinary(Integer.parseInt(num)));
                case 2 -> System.out.println("Wynik: "+fromBinary(num));
                case 3 -> System.exit(0);
                default -> System.out.println("Nie ma takiej opcji");
            }
        }
    }
    static String toBinary(Integer number) {
        StringBuilder result = new StringBuilder();
        int length = getMaximumTwoPower(number) > 5 ? getMaximumTwoPower(number) : 5;
        while (number != 0) {
            for (int i = length; i >= 0; i--) {
                if(number >= (Math.pow(2, i))) {
                    result.append("1");
                    number -= (int) Math.pow(2, i);
                } else {
                    result.append("0");
                }
            }
        }
        return result.toString();
    }
    static Integer getMaximumTwoPower(Integer number) {
        int power = 0;
        Integer twoMight = 1;
        while (number > twoMight) {
            power++;
            twoMight = (int) Math.pow(2, power);
        }
        return power == 1 ? power : power-1;
    }
    static String fromBinary(String binaryNumber) {
        int result = 0;
        for (int i = 0; i < binaryNumber.length(); i++){
            int number = Integer.parseInt(String.valueOf(binaryNumber.charAt(i)));
            int power = binaryNumber.length()-i-1;
            if(number == 1) {
                result += (int) Math.pow(2, power);
            } else if(number != 0) {
                throw new IllegalArgumentException("Niepoprawna liczba w systemie dwójkowym");
            }
        }
        return Integer.toString(result);
    }
}

package ru.maxvagan;

import java.time.LocalDate;
import java.util.Arrays;

public class Main {

    static short currentYear = (short)LocalDate.now().getYear();

    private static short assignYear(int inpFromYear, int inpToYear) {
        return (short) (inpFromYear + Math.round(Math.random() * (inpToYear - inpFromYear)));
    }

    private static int setRandDist(int inpStart, int inpEnd) {
        return (int)(inpStart + Math.round(Math.random() * (inpEnd - inpStart)));
    }

    private static void isYearLeap(short inpYear) {
        if (inpYear % 4 == 0 && inpYear % 100 != 0 || inpYear % 400 == 0) {
            System.out.println("Год " + inpYear + " - Високосный");
        } else {
            System.out.println("Год " + inpYear + " - Невисокосный");
        }
    }

    private static String defineOsName(byte inpOsNum) {
        if (inpOsNum == 0)
            return "iOS";
        else if (inpOsNum == 1)
            return "Android";
        else return "(Неопределена)";
    }

    private static String defineVersion(short inpYear) {
        if (inpYear < currentYear)
            return "Lite";
        else return "полную";
    }

    private static void getMobileLink(byte inpOsNum, short inpYear) {
        String clientOsName = defineOsName(inpOsNum);
        String appVersion = defineVersion(inpYear);
        if (inpOsNum == 0 || inpOsNum == 1) {
            System.out.println("На вашем смартфоне установлена версия " + clientOsName + " " + inpYear + " года выпуска");
            System.out.println("Установите "+appVersion+" версию приложения");
        } else System.out.println("На вашем смартфоне установлена иная версия ОС.\r\nОбратитесь в тех. поддержку");
    }

    private static short getDeliveryPeriod(int inpDist) {
        int deliveryDays = 1;
        if (inpDist <= 20) {
            deliveryDays += 0;
        } else if (inpDist > 20 && inpDist <= 60) {
            deliveryDays += 1;
        } else if (inpDist > 60 && inpDist <= 100) {
            deliveryDays += 2;
        } else deliveryDays += 3;
        return (short)deliveryDays;
    }

    private static void checkDuplicates(String inpStr) {
        char[] strAsCharArray = inpStr.toCharArray();
        boolean isBoundToStr = false;
        for (int i = 0; i < strAsCharArray.length-1; i++) {
            isBoundToStr = inpStr.substring(i + 1, strAsCharArray.length).contains(inpStr.subSequence(i, i+1));
            if (isBoundToStr) {
                System.out.println("Внимание! В строке найден дубликат символа " + strAsCharArray[i] + "\r\nПоиск прекращён");
                break;
            }
        }
    }

    public static int[] funcGenerateRandomArray(int arrayLenght, int beginValue, int endValue) {
        java.util.Random random = new java.util.Random();
        int[] arr = new int[arrayLenght];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(endValue-beginValue) + beginValue;
        }
        return arr;
    }

    private static void resortArray(int[] inpArray) {
        int buffNum = 0;
        for (int i = 0; i < inpArray.length/2; i++) {
            buffNum = inpArray[i];
            inpArray[i] = inpArray[inpArray.length - 1 - i];
            inpArray[inpArray.length - 1 - i] = buffNum;
        }
    }

    public static void main(String[] args) {
        // Task 1
        System.out.println("Task 1");
        short checkingYear = assignYear(1990, 2030);
        isYearLeap(checkingYear);
        // Task 2
        System.out.println("Task 2");
        byte cliOsNum = (byte)Math.round(Math.random()*2);
        getMobileLink(cliOsNum, checkingYear);
        // Task 3
        System.out.println("Task 3");
        int distance = setRandDist(10, 110);
        short deliveryDays = getDeliveryPeriod(distance);
        System.out.println("Указанная дистанция равна " + distance + " км");
        System.out.println("Карту Вам доставят в течение " + deliveryDays + " дней");
        // Task 4
        System.out.println("Task 4");
        checkDuplicates("aabccddefgghiijjkk");
        // Task 5
        System.out.println("Task 5");
        int[] randArray = funcGenerateRandomArray(5, 1, 10);
        System.out.println("Был массив " + Arrays.toString(randArray));
        resortArray(randArray);
        System.out.println("Стал массив " + Arrays.toString(randArray));
    }
}

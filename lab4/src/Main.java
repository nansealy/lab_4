import Series.Seriesable;
import SeriesExceptions.NullSeriesableObjectException;

import java.util.Scanner;


import static Series.SeriesMenu.*;

class Main {
    public static void main(String[] args) {
        Seriesable[] sArr = null; // сборник серий (сборник сборников)
        Seriesable s = null;

        Scanner scan = new Scanner(System.in);
        String menuItem;

        do {
            System.out.print(
                    "base:\n" +
                    " 1 - вывести полную информацию базы\n" +
                    " 2 - создать базу\n" +
                    " 3 - задание элемента базы\n" +
                    " 4 - найти в базе объекты,\n" +
                    "     функциональный метод которых возвращают одинаковый результат,\n" +
                    "     поместить их в массив\n" +
                    " 5 - разбить базу на два массива,\n" +
                    "     в которых будут храниться однотипные элементы\n" +
                    " 6 - считать базу из байтового потока\n" +
                    " 7 - считать базу из текстового потока\n" +
                    " 8 - десериализовать базу\n" +
                    " 9 - записать базу в байтовый поток\n" +
                    "10 - записать базу в символьный поток\n" +
                    "11 - сериализовать базу\n" +
                    "object:\n" +
                    "12 - показать содержимое объекта\n" +
                    "13 - создать и заполнить объект Seriesable\n" +
                    "14 - считать из байтового потока\n" +
                    "15 - считать из текстового потока\n" +
                    "16 - десериализовать объект\n" +
                    "17 - записать объект в байтовый поток\n" +
                    "18 - записать объект в символьный поток\n" +
                    "19 - сериализовать объект\n" +
                    "test:\n" +
                    "20 - создать и заполнить базу автоматически\n" +
                    "21 - создать и заполнить базу автоматически так,\n" +
                    "     чтобы были элементы,\n" +
                    "     у которых функциональные методы возвращают одинаковый результат\n" +
                    "22 - создать и заполнить объект Seriesable автоматически\n" +
                    "0 - выйти\n");
            menuItem = scan.nextLine();

            switch (menuItem) {
                case "1":
                    print(" 1 -- вывести полную информацию базы\n");
                    printSerArr(sArr);
                    break;

                case "2":
                    print(" 2 -- создать базу\n");
                    print("задание размера базы: ");
                    sArr = printGetSerArr();
                    break;

                case "3":
                    print(" 3 -- задание элемента базы\n");
                    printSerArrAsTitlesOfEls(sArr);
                    System.out.println();
                    printSerArrAsTitlesOfEls(sArr);
                    break;

                case "4":
                    print(" 4 -- найти в базе объекты,\n" +
                            "      функциональный метод которых возвращают одинаковый результат,\n" +
                            "      поместить такие объекты в массив\n");
                    printGetArrWithTwoElsWithSameSumOfPagesWithoutStart(sArr);
                    break;

                case "5":
                    print(" 5 -- разбить базу на два массива,\n" +
                            "      в которых будут храниться однотипные элементы\n");
                    printSplitArrIntoTwoArticlesAndBooksArrs(sArr);
                    break;

                case "6":
                    print(" 6 -- считать базу из байтового потока\n");
                    try {
                        sArr = printInputBytesAsSerArr();
                    } catch (NullSeriesableObjectException exc) {
                        print(exc.getMessage());
                    }
                    break;

                case "7":
                    print(" 7 -- считать базу из текстового потока\n");
                    try {
                        sArr = printReadTextAsSerArr();
                    } catch (NullSeriesableObjectException exc) {
                        print(exc.getMessage());
                    }
                    break;

                case "8":
                    print(" 8 -- десериализовать базу\n");
                    try {
                        sArr = printDeserializeSerArr();
                    } catch (NullSeriesableObjectException exc) {
                        print(exc.getMessage());
                    }
                    break;

                case "9":
                    print(" 9 -- записать базу в байтовый поток\n");
                    printOutputSerArrAsBytes(sArr);
                    break;

                case "10":
                    print("10 -- записать базу в символьный поток\n");
                    printWriteSerArrAsText(sArr);
                    break;

                case "11":
                    print("11 -- сериализовать базу\n");
                    printSerializeSerArr(sArr);
                    break;
                case "12":
                    print("12 -- показать содержимое объекта\n");
                    System.out.println(s);
                    break;

                case "13":
                    print("13 -- создать и заполнить объект Seriesable\n");
                    s = printGetAndSetSer();
                    break;

                case "14":
                    print("14 -- считать из байтового потока\n");
                    try {
                        s = printInputBytesAsSer();

                    } catch (NullSeriesableObjectException exc) {
                        print(exc.getMessage());
                    }
                    break;

                case "15":
                    print("15 -- считать из текстового потока\n");
                    try {
                        s = printReadTextAsSer();
                    } catch (NullSeriesableObjectException exc) {
                        print(exc.getMessage());
                    }
                    break;

                case "16":
                    print("16 -- десериализовать объект\n");
                    try {
                        s = printDeserializeSer();
                    } catch (NullSeriesableObjectException exc) {
                        print(exc.getMessage());
                    }
                    break;

                case "17":
                    print("17 -- записать объект в байтовый поток\n");
                    printOutputSerAsBytes(s);
                    break;

                case "18":
                    print("18 -- записать объект в текстовый поток\n");
                    printWriteSerAsText(s);
                    break;

                case "19":
                    print("19 -- сериализовать объект\n");
                    printSerializeSer(s);
                    break;
                case "20":
                    print("20 -- создать и заполнить базу автоматически\n");
                    sArr = TestingSeries.createAndFillInDbWithFiveElsAutomatically();
                    break;

                case "21":
                    print("21 -- создать и заполнить базу автоматически так,\n" +
                            "      чтобы были элементы,\n" +
                            "      у которых функциональные методы возвращают одинаковый результат\n");
                    sArr = TestingSeries.createAndFillInDbWithFiveElsAutomatically();
                    TestingSeries.setTwoSeriesableWithSameSumOfPagesWithoutStart(sArr);
                    break;

                case "22":
                    print("22 -- создать и заполнить объект Seriesable автоматически\n");
                    s = TestingSeries.createAndFillSerAutomatically();
                    break;

                default:
                    break;
            }
            print("Выход");
            System.out.println();
        } while (!menuItem.equals("0"));
    }
}


import com.sun.xml.internal.ws.api.ha.StickyFeature;
import java.util.Random;
import java.util.Scanner;

public class BubbleSortLearn {

    void BubbleSortNedir() {
        String turkishName = "Kabarcik Siralamasi";
        System.out.println(" Bubble Sort Nedir ?  \n"
                + "*************************************\n"
                + " \033[0;31m Bubble Sort \033[0m : It is called \"\033[0;31m" + turkishName + "\033[0m\" in Turkish."
                + "\n"
                + "Given a sequence, consecutive pairs of elements are sorted such that\n"
                + "the larger one is placed to the right and the smaller one to the left.\n"
                + "*************************************"
                + "\nHow does it work?\n"
                + "For example: arr=[4]={5,1,-5,30}\n"
                + "These values of array will be sorted as following process.\n"
                + " [5  1]  -5  30 --> [1 5]  -5  30 \n"
                + "  1  [5  -5 ] 30 -->  1  [-5  5] 30 ... \n"
                + " and it will be sorted in following sequence\n"
                + "-5  1  5  30.\n\n");
    }

    void OrnekSiralama() {
        Random random = new Random();
        int uzunluk = 4;
        int j, i, m;
        int[] arr = new int[4];
        for (i = 0; i < uzunluk - 1; i++) {
            arr[i] = random.nextInt(50);   // Dizimizin her elemanina 0-50 arasi random sayi atanir 
            for (j = 0; j < i; j++) {

                while (arr[j] == arr[i]) {
                    arr[i] = (int) (Math.random() * 9); //random.nextInt(50);  Eğer random atilan sayimiz 
                    //onceki bir sayi ile esit olursa sayimiz değistirilir 
                    j -= j;
                }
            }
        }
        StringBuilder arrText = new StringBuilder();
        for (int index = 0; index < arr.length; index++) {
            arrText.append(arr[index] + " ");
        }
        arrText.deleteCharAt(arrText.length() - 1);

        System.out.println("Example array :  arr[" + arrText + "]");
        for (i = 0; i < uzunluk - 1; i++) {
            for (j = 0; j < uzunluk - 1 - i; j++) {
                String islemKontrol = "islem yapilmadi";   // eğer asağidaki if de islem gerceklesirse yazmak icin kullanilir yoksa 
                //ayni dizi tekrardan girileceği icin bosuna yazdirmasin diye kullandim
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    islemKontrol = "islem yapildi";
                }

                if (islemKontrol.equals("islem yapildi")) {
                    for (m = 0; m < uzunluk; m++) {
                        System.out.print(arr[m] + " ");
                    }
                    System.out.print(" ->  comparing numbers [ " + arr[j + 1] + " " + arr[j] + " ]  \033[0;32m Updated as "
                            + "-->[ " + arr[j] + " " + arr[j + 1] + " ] \033[0m");    // \033[0;32m gibi degisik seyler renk kodlari 
                    System.out.println();
                } else {
                    for (m = 0; m < uzunluk; m++) {
                        System.out.print(arr[m] + " ");
                    }
                    System.out.print(" ->  karsilastirilan sayilar [ " + arr[j] + " " + arr[j + 1] + " ] ");
                    System.out.println();
                }

            }
        }
    }

    void OrnekCoz(int uzunluk) {
        Scanner scanner = new Scanner(System.in);
        int i, j, m;

        Random random = new Random();
        int[] arr = new int[uzunluk];
        for (i = 0; i < uzunluk - 1; i++) {
            arr[i] = random.nextInt(50);;
            for (j = 0; j < i; j++) {              // Program hata verirse bunu while yaz 

                while (arr[j] == arr[i]) {
                    arr[i] = random.nextInt(50);
                    j -= j;
                }
            }
        }

        System.out.println("Array will be sorted : ");
//        System.out.print("[ ");
//        for (i = 0; i < uzunluk; i++) {
//            System.out.print(" " + arr[i] + " ");
//        }
//        System.out.print(" ]");
//        System.out.println(" Enter 2 number as done in \"Example Solution\"");

        for (i = 0; i < uzunluk - 1; i++) {
            for (j = 0; j < uzunluk - 1 - i; j++) {

                System.out.print("[ ");
                for (m = 0; m < uzunluk; m++) {
                    System.out.print(arr[m] + " ");
                }
                System.out.println(" ]");
                {
                    System.out.print("Compare next two numbers, and type in correct format order: ");
                    System.out.print("");

                    int cevap1 = scanner.nextInt();
                    int cevap2 = scanner.nextInt();
                    if (arr[j] > arr[j + 1]) {
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                    if (cevap1 == arr[j] && cevap2 == arr[j + 1]) {
                        System.out.println(" \033[0;36m ✓ \033[0m");
                    } else {
                        java.awt.Toolkit.getDefaultToolkit().beep();     //Hata yapildiğinda bip sesi cikarmasini saglar
                        System.out.println("\033[0;31m" + "X" + "\033[0;32m" + " Correct : " + "[ \033[0;34m " + arr[j] + " " + arr[j + 1] + "  \033[0;32m ]" + "\033[0m");

                        System.out.println(" ]");
                        System.out.println();
                    }

                }
            }
        }
        System.out.println("\033[0;35m  ✓ ✓ ✓  Array is sorted ✓ ✓ ✓  \033[0m ");
        StringBuilder sortedArr = new StringBuilder();
        for (m = 0; m < uzunluk; m++) {
            sortedArr.append(arr[m] + " ");
        }
        sortedArr.deleteCharAt(sortedArr.length() - 1);
        System.out.println(" \033[0;34m The sorted array is  [" + sortedArr + "]");
        System.out.println("\033[0;31m  ... Congratulations  \033[0m ");
    }

    public static void main(String[] args) {
        //public static final String BLUE = "\033[0;34m";    // BLUE
        System.out.println("\033[0;34m" + " Merhaba" + "\033[0m");
//        System.out.println("\033[0;31m Kabarcik Siralamasidir. \033[0m");
        int[] kkk = new int[5];

        BubbleSortLearn calisma = new BubbleSortLearn();
        Scanner scanner = new Scanner(System.in);
        System.out.println("!!! *** Welcome to BubbleSort Tutorial *** !!!");
        String Secenekler = "1-) What is BubbleSort? How does it work?\n"
                + "2-) Example Solution.\n"
                + "3-) Take a test.\n";
        String islemSec = null;
        while (islemSec==null || !islemSec.equals("exit") ) {
            System.out.println("islemsec : "+islemSec);
            System.out.println(Secenekler);

            System.out.println("Enter the number of the requested process.\n"
                    + "Not : Type `exit` to end program. ");

            islemSec = scanner.nextLine();
            switch (islemSec) {
                case "1":
                    calisma.BubbleSortNedir();
                    break;

                case "2":
                    calisma.OrnekSiralama();
                    break;

                case "3":
                    System.out.print("Enter array lenght :");
                    int uzunluk = scanner.nextInt();
                    scanner.nextLine(); //Dummy code

                    calisma.OrnekCoz(uzunluk);
                    break;
                default:
                    System.out.println("Bilinmeyen islem lutfen tekrar deneyin");

            }

        }
    }

}

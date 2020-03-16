import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            List<String> myList = new ArrayList<>();
            Compare first;
            first = new Compare(myList);
            System.out.println("Wprowadź nazwę pliku do odczytania, bez rozszerzenia: ");
            Scanner scannerNameOfFile = new Scanner(System.in);
            String nameOfFile = scannerNameOfFile.nextLine();
            scannerNameOfFile.close();
            if (nameOfFile != null) {
                first.setNameOrLastname(nameOfFile + ".txt", myList);
                first.quickSort(myList, 0, myList.size() - 1);
                System.out.println(first.getNameOrLastname());
                System.out.println(first.toString());
            }else {
                System.out.println("Podałeś pustą nazwę pliku. ");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}

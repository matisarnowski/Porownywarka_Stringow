import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Compare implements Comparator {
    private List<String> nameOrLastname;

    public Compare(List<String> nameOrLastname) {
        this.nameOrLastname = nameOrLastname;
    }

    public List<String> getNameOrLastname() {
        return nameOrLastname;
    }

    public void setNameOrLastname(String name, List<String> nameOrLastname) throws FileNotFoundException {
        this.nameOrLastname = setList(name);
    }

    public void quickSort(List<String> nameOrLastname, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partitionList(this.nameOrLastname, begin, end);

            quickSort(this.nameOrLastname, begin, partitionIndex - 1);
            quickSort(this.nameOrLastname, partitionIndex + 1, end);
        }
    }

    private int partitionList(List<String> nameOrLastname, int begin, int end) {
        int pivot = end;
        int i = begin - 1;

        for (int j = begin; j < end; j++) {
            if (compare(j, pivot) <= 0) {
                i++;

                String swapTemp = this.nameOrLastname.get(i);
                this.nameOrLastname.set(i, this.nameOrLastname.get(j));
                this.nameOrLastname.set(j, swapTemp);
            }
        }

        String swapTemp = nameOrLastname.get(i + 1);
        nameOrLastname.set(i + 1, nameOrLastname.get(end));
        nameOrLastname.set(end, swapTemp);

        return i + 1;
    }

    @Override
    public int compare(Object ii, Object jj) {
        Integer i = (Integer) ii;
        Integer j = (Integer) jj;
        String word1 = nameOrLastname.get(i);
        String word2 = nameOrLastname.get(j);
        return word1.compareTo(word2);
    }

    public List<String> setList(String nameOfFile) throws FileNotFoundException {
        File file = new File(nameOfFile);
        Scanner scanner = new Scanner(file);
        String word = scanner.nextLine();
        while (scanner.hasNextLine()) {
            this.nameOrLastname.add(word);
            word = scanner.nextLine();
        }
        scanner.close();
        return this.nameOrLastname;
    }

    @Override
    public String toString() {
        return String.valueOf(nameOrLastname);
    }
}

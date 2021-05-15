import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    private final char lookFor;
    private FileReader file01;

    {
        try {
            file01 = new FileReader("C:\\Users\\YN\\IdeaProjects\\t2\\src\\tex.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    Main(FileReader file, char lookFor) throws IOException {
        this.file01 = file;
        this.lookFor = lookFor;

    }

    private String readFile() throws IOException {

        String everything;

        try (BufferedReader br = new BufferedReader(file01)) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();

            }
            everything = sb.toString();
        }
        return everything;
    }

    private int count(String line) {
        int count = 0;

        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == lookFor) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        FileReader file01 = new FileReader("C:\\Users\\YN\\IdeaProjects\\t2\\src\\tex.txt");
        Main cl1 = new Main(file01, 'e');

        System.out.println(cl1.count(cl1.readFile()));
    }


}

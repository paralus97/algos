package commonjavaqs;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

import static java.lang.Integer.parseInt;

public class InputParserBasic {

    /**
     * Manipulate me depending on the kind of input required by solution
     * @param file
     * @throws IOException
     */
    public static List<Integer> parseFile(File file) throws IOException {
        FileInputStream inputStream = null;
        Scanner sc = null;
        List<Integer> input = new ArrayList<>();
        try {
            inputStream = new FileInputStream(file);
            sc = new Scanner(inputStream, "UTF-8");
            while (sc.hasNextLine()) {
                // String line = sc.nextLine().trim();
                int i = sc.nextInt();
                input.add(i);
            }
            // note that Scanner suppresses exceptions
            if (sc.ioException() != null) {
                throw sc.ioException();
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (sc != null) {
                sc.close();
            }
        }
        return input;
    }
}

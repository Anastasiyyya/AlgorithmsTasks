package elements;

import constants.IPathConstants;
import lombok.extern.log4j.Log4j2;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Log4j2
public class MatrixHelpers implements IPathConstants {

    static List<Integer> counts = new ArrayList<>();

    /**
     * This method reads size of matrix from the text file.
     * @return matrixSize
     */
    public static int readMatrixSize() {
        List<String> matrixSize = new ArrayList<>();
        Path path = Paths.get("FirstMatrix.txt");
        try {
            matrixSize = Files.readAllLines(path);
        } catch (IOException e) {
            log.info("End of the text file reached");
        }
        System.out.println();
        return matrixSize.size();
    }

    /**
     * This method reads matrix from the text file.
     * @return matrixBeforeConvert
     */
    public static Integer[][] readFromFile() {
        int matrixSize = MatrixHelpers.readMatrixSize();
        Integer[][] matrixBeforeConvert = new Integer[matrixSize][matrixSize];
        List<String> lines = new ArrayList<>();
        counts = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(READ_FILE_PATH));
            matrixSize = Integer.parseInt(reader.readLine());
            while (reader.ready()) {
                lines.add(reader.readLine());
            }
            matrixBeforeConvert = new Integer[matrixSize][matrixSize];
            for (int i = 0; i < matrixSize; i++) {
                int count = -1;
                for (int j = 0; j < matrixSize; j++) {
                    count++;
                    String[] line = lines.get(i).split(" ");
                    matrixBeforeConvert[i][j] = Integer.parseInt(line[j]);
                    if (matrixBeforeConvert[i][j] == 0) {
                        counts.add(count);
                    }
                }
            }
        } catch (IOException e) {
            log.info("File not found");
        }
        return matrixBeforeConvert;
    }

    /**
     * This method converts a matrix from txt file to new matrix according to the description of the task and
     * and outputs to the console a new matrix.
     *
     * @param matrixBeforeConvert
     * @return matrixAfterConvert
     */
    public static Integer[][] convertMatrix(Integer[][] matrixBeforeConvert) {
        HashMap<Integer, Integer[]> data = new HashMap<>();
        int matrixSize = matrixBeforeConvert.length;
        for (int i = 0; i < matrixSize; i++) {
            data.put(counts.get(i), matrixBeforeConvert[i]);
        }
        Integer[][] matrixAfterConvert = new Integer[matrixSize][matrixSize];
        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                matrixAfterConvert[i] = (data.get(i));
            }
        }
        log.info("Matrix was converted");
        Arrays.stream(matrixAfterConvert)
                .forEach(array -> System.out.println(Arrays.toString(array)));
        return matrixAfterConvert;
    }

    /**
     * This method writes matrixAfterConvert to new text file.
     *
     * @param matrixAfterConvert
     * @return true
     */
    public static boolean matrixWriter(Integer[][] matrixAfterConvert) {
        try {
            FileWriter writer = null;
            try {
                writer = new FileWriter(WRITE_FILE_PATH, false);
            } catch (IOException e) {
                log.info("File not found");
            }
            try {
                for (int i = 0; i < matrixAfterConvert.length; i++) {
                    for (int j = 0; j < matrixAfterConvert.length; j++) {
                        writer.write(String.valueOf(matrixAfterConvert[i][j]));
                        writer.write(" ");
                        if (j == matrixAfterConvert.length - 1) {
                            writer.flush();
                            writer.append("\n");
                        }
                    }
                }
            } catch (IOException e) {
                log.info("Writing file error");
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * This method checks if all elements of new matrix located on main diagonal equals to zero
     *
     * @param matrixAfterConvert
     * @return result
     */
    public static boolean isAllElementsZero(Integer[][] matrixAfterConvert) {
        boolean result = true;
        for (int i = 0; i < matrixAfterConvert.length; i++) {
            if (!(matrixAfterConvert[i][i] == 0)) {
                log.info("The main diagonal has a nonzero element");
                result = false;
                break;
            }
        }
        return result;
    }

    /**
     * This method check that two matrix are the same
     * @param matrixBeforeConvert
     * @param matrixAfterConvert
     * @return compare
     */
    public static boolean compareTwoMatrix(Integer[][] matrixBeforeConvert, Integer[][] matrixAfterConvert) {
        boolean compare = true;
        for (int i = 0; i < matrixAfterConvert.length; i++) {
            for (int j = 0; j < matrixAfterConvert.length; j++) {
                if (!(matrixBeforeConvert[i][j] == matrixAfterConvert[counts.get(i)][j])) {
                    log.info("Matrices aren't the same");
                    compare = false;
                    break;
                }
            }

        }
        return compare;
    }
}
package tests;

import elements.MatrixHelpers;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MatrixTest{

    /**
     * This test checks if all elements of new matrix located on main diagonal are equals to zero
     */
    @Test
    public void isAllMainDiagonalZero() {
        Integer[][] newMatrix = MatrixHelpers.convertMatrix(MatrixHelpers.readFromFile());
        Assert.assertTrue(MatrixHelpers.isAllElementsZero(newMatrix));
    }

    /**
     * This test checks if the matrix has been read from text file.
     */
    @Test
    public void isMatrixReads() {
        Assert.assertNotNull(MatrixHelpers.readFromFile());
    }


    /**
     * This test checks if a new matrix has been written to a text file
     */
    @Test
    public void isMatrixWrites() {
        Integer[][] newMatrix = MatrixHelpers.convertMatrix(MatrixHelpers.readFromFile());
        Assert.assertTrue(MatrixHelpers.matrixWriter(newMatrix));
    }

    /**
     * This test checks that two matrix are the same
     */
    @Test
    public void compareTwoMatrix() {
        Integer[][] matrixBeforeConvert = MatrixHelpers.readFromFile();
        Integer[][] matrixAfterConvert = MatrixHelpers.convertMatrix(matrixBeforeConvert);
        Assert.assertTrue(MatrixHelpers.compareTwoMatrix(matrixBeforeConvert,matrixAfterConvert));
    }
}


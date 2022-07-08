package utility;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;

public class CSVDataProvider {
    private static CSVReader reader = null;
    private static Object[][] data = null;
    private static String[] cell = null;

    private static int getRows(String fileName) throws IOException {
        int rows = 0;
        reader = new CSVReader(new FileReader(fileName));
        while (reader.readNext() != null) {
            rows++;
        }
        return rows;
    }

    private static void getData(String fileName) throws IOException {

        reader = new CSVReader(new FileReader(fileName));

        String[] header = reader.readNext();

        int rows = getRows(fileName);
        int columns = header.length;

        int i = 0;
        int j = 0;

        try {
            data = new Object[rows][columns];
            reader = new CSVReader(new FileReader(fileName));
            while ((cell = reader.readNext()) != null) {
                while (j < columns) {
                    data[i][j] = cell[j];
                    j++;
                }
                j=0;
                i++;
            }

        } catch (Exception e) {
            e.printStackTrace();

        }

    }

    public static Object[][] getCSVData(String fileName) throws IOException {
        getData(fileName);
        return data;
    }


}

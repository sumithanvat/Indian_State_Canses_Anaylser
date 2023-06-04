import java.io.IOException;
import java.util.Iterator;
import java.io.BufferedReader;
        import java.io.FileReader;
        import java.util.ArrayList;
        import java.util.List;

public class CSVStates {
    private List<String[]> records;

    public CSVStates() {
        this.records = new ArrayList<>();
    }

    public void loadCSVData(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] data = line.split(",");
            records.add(data);
        }
        reader.close();
    }

    public int getNumberOfRecords() {
        return records.size();
    }

    public Iterator<String[]> getDataIterator() {
        return records.iterator();
    }

    public static void main(String[] args) {
        String filePath = "C:\\Users\\admin\\IdeaProjects\\Indian_States_Census_Analyser_Problem\\IndianState.csv";

        CSVStates states = new CSVStates();
        try {
            states.loadCSVData(filePath);
            int numberOfRecords = states.getNumberOfRecords();
            System.out.println("Number of records: " + numberOfRecords);

            // Example usage of iterator
            Iterator<String[]> iterator = states.getDataIterator();
            while (iterator.hasNext()) {
                String[] data = iterator.next();
                // Process each data record
                // ...
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


import org.junit.jupiter.api.Assertions;
        import org.junit.jupiter.api.BeforeEach;
        import org.junit.jupiter.api.Test;

        import java.io.IOException;
        import java.util.Iterator;

public class CSVStatesTest {
    private CSVStates states;

    @BeforeEach
    public void setup() {
        states = new CSVStates();
    }

    @Test
    public void testLoadCSVData() throws IOException {
        String filePath = "C:\\Users\\admin\\IdeaProjects\\Indian_States_Census_Analyser_Problem\\IndianState.csv";
        states.loadCSVData(filePath);

        int expectedRecords = 5;
        int actualRecords = states.getNumberOfRecords();
        Assertions.assertEquals(expectedRecords, actualRecords, "Number of records should match");

        Iterator<String[]> iterator = states.getDataIterator();
        int count = 0;
        while (iterator.hasNext()) {
            iterator.next();
            count++;
        }
        Assertions.assertEquals(expectedRecords, count, "Iterator should loop through all records");
    }
}

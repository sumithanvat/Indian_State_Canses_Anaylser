
import com.indianstatescenus.StateCensusAnalyser;
import org.junit.jupiter.api.Assertions;
        import org.junit.jupiter.api.BeforeEach;
        import org.junit.jupiter.api.Test;

        import java.io.IOException;
        import java.util.Iterator;

public class StateCensusAnalyserTest {
    private StateCensusAnalyser analyser;

    @BeforeEach
    public void setup() {
        analyser = new StateCensusAnalyser();
    }

    @Test
    public void testLoadCSVData() throws IOException {
        String filePath = "path/to/state_census.csv";
        analyser.loadCSVData(filePath);

        int expectedRecords = 5;
        int actualRecords = analyser.getNumberOfRecords();
        Assertions.assertEquals(expectedRecords, actualRecords, "Number of records should match");

        Iterator<String[]> iterator = analyser.getDataIterator();
        int count = 0;
        while (iterator.hasNext()) {
            iterator.next();
            count++;
        }
        Assertions.assertEquals(expectedRecords, count, "Iterator should loop through all records");
    }
}

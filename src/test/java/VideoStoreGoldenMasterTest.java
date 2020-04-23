import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class VideoStoreGoldenMasterTest {

    GoldenMasterGenerator goldenMaster = new GoldenMasterGenerator();

    @Test
    void shouldReadAndWriteGoldenMasterFile() throws IOException {
        String result = goldenMaster.goldenMasterData();
        goldenMaster.writeGoldenMasterFile(result);
        var referenceResult = goldenMaster.readGoldenMasterFile();
        assertThat(referenceResult).isEqualTo(result);
    }

}
package videostore;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class VideoStoreGoldenMasterTest {

    GoldenMasterGenerator goldenMaster = new GoldenMasterGenerator();

    @Test
    void shouldGetTheSameResultAsGoldenMaster() throws IOException {
         assertThat(goldenMaster.testedClassOutput()).isEqualTo(goldenMaster.fileContents());
    }

}
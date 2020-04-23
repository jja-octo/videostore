import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.stream.IntStream;

public class GoldenMasterGenerator {
    private static final Path GOLDEN_MASTER_FILE_PATH = Paths.get("./src/test/resources/goldenmaster.txt");

    public String goldenMasterData() {
        var customer = new Customer("Fred");
        IntStream.of(0, 1, 2).forEach(priceCode -> {
            var movie = new Movie("2001: A Space Odyssey " + priceCode, priceCode);
            for (var daysRented = 0; daysRented < 10; daysRented++) {
                customer.addRental(new Rental(movie, daysRented));
            }
        });

        return customer.statement();
    }

    public String readGoldenMasterFile() throws IOException {
        return Files.readString(GOLDEN_MASTER_FILE_PATH);
    }

    public void writeGoldenMasterFile(String result) throws IOException {
        Files.writeString(GOLDEN_MASTER_FILE_PATH, result, StandardOpenOption.CREATE);
    }

}

package videostore;

import videostore.movie.Movie;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

import static videostore.Pricing.*;

public class GoldenMasterGenerator {
    private static final Path GOLDEN_MASTER_FILE_PATH = Paths.get("./src/test/resources/goldenmaster.txt");

    public static void main(String[] args) {
        saveGoldenMasterDataToFile();
    }

    private static void saveGoldenMasterDataToFile() {
        var goldenMaster = new GoldenMasterGenerator();
        String result = goldenMaster.testedClassOutput();
        try {
            goldenMaster.saveToFile(result);
        } catch (IOException e) {
            e.printStackTrace(System.err);
        }
    }

    public String testedClassOutput() {
        var customer = new Customer("Fred");
        List.of(REGULAR, NEW_RELEASE, CHILDREN).forEach(pricing -> {
            var movie = new Movie("2001: A Space Odyssey " + pricing.code(), pricing);
            for (var daysRented = 0; daysRented < 10; daysRented++) {
                customer.addRental(new Rental(movie, daysRented));
            }
        });

        return customer.statement();
    }

    public String fileContents() throws IOException {
        return Files.readString(GOLDEN_MASTER_FILE_PATH);
    }

    public void saveToFile(String result) throws IOException {
        Files.deleteIfExists(GOLDEN_MASTER_FILE_PATH);
        Files.writeString(GOLDEN_MASTER_FILE_PATH, result, StandardOpenOption.CREATE_NEW);
    }

}

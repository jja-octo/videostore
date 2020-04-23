package videostore;

import videostore.movie.ChildrenMovie;
import videostore.movie.Movie;
import videostore.movie.NewReleaseMovie;
import videostore.movie.RegularMovie;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

import static videostore.GoldenMasterGenerator.MovieType.*;

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
            var movie = movie("2001: A Space Odyssey", pricing);
            for (var daysRented = 0; daysRented < 10; daysRented++) {
                customer.addRental(new Rental(movie, daysRented));
            }
        });

        return customer.statement();
    }
    
    public Movie movie(String title, MovieType pricing) {
        String titleWithPriceCode = title + " " + pricing.code();
        switch (pricing) {
            case REGULAR:
                return new RegularMovie(titleWithPriceCode);
            case NEW_RELEASE:
                return new NewReleaseMovie(titleWithPriceCode);
            case CHILDREN:
                return new ChildrenMovie(titleWithPriceCode);
            default:
                throw new IllegalArgumentException();
        }
    }
    
    public String fileContents() throws IOException {
        return Files.readString(GOLDEN_MASTER_FILE_PATH);
    }

    public void saveToFile(String result) throws IOException {
        Files.deleteIfExists(GOLDEN_MASTER_FILE_PATH);
        Files.writeString(GOLDEN_MASTER_FILE_PATH, result, StandardOpenOption.CREATE_NEW);
    }

    enum MovieType {
        REGULAR(0),
        NEW_RELEASE(1),
        CHILDREN(2),
        ;
    
        private final int code;
    
        MovieType(int code) {
            this.code = code;
        }
    
        public String code() {
            return String.valueOf(code);
        }
    }
}

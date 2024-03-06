import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class PalList {
    // list for Pal objects
    private List<Pal> pals;

    // constructor
    public PalList() {
        this.pals = new ArrayList<>();
    }

    // add pal to list
    public void addPal(Pal pal) {
        pals.add(pal);
    }

    // getter for list of pals
    public List<Pal> getPals() {
        return pals;
    }

    // sort pals by ID
    public void sortPalsByPalId() {
        Collections.sort(pals, new Comparator<Pal>() {
            @Override
            public int compare(Pal p1, Pal p2) {
                String palNumber1 = String.format("%03d", p1.getPalNumber()); // format number to ensure proper sorting
                String palNumber2 = String.format("%03d", p2.getPalNumber()); // format number to ensure proper sorting
                return palNumber1.compareToIgnoreCase(palNumber2);
            }
        });
    }

    // sort pals by name
    public void sortPalsByPalName() {
        Collections.sort(pals, Comparator.comparing(Pal::getName));
    }

    // sort pals by element
    public void sortPalsByPalElement() {
        Collections.sort(pals, Comparator.comparing(Pal::getElementType));
    }

    // sort pals by capture count
    public void sortPalsByCapturedCount() {
        Collections.sort(pals, Comparator.comparingInt(Pal::getCapturedCount));
    }

    // populate the PalList from a text file
    public void populateFromTextFile(String filename) {
        try {
            Scanner scanner = new Scanner(new File(filename));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(", "); // Split the line into parts
                if (parts.length == 3) {
                    String palNumberString = parts[0].trim(); // Extract the pal number
                    int palNumber = Integer.parseInt(palNumberString.replaceAll("[^0-9]", ""));
                    String name = parts[1].trim();
                    String elementType = parts[2].trim();
                    int capturedCount = 0; // Set default captured count to 0
                    pals.add(new Pal(palNumber, name, elementType, capturedCount));
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format in file: " + filename);
        }
    }

}

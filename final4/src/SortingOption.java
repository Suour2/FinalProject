import java.util.Comparator;

public class SortingOption {
    // sorting option name
    private String optionName;

    // constructor
    public SortingOption(String optionName) {
        this.optionName = optionName;
    }

    // getter
    public String getOptionName() {
        return optionName;
    }

    // method to get comparator based on sorting option
    public Comparator<Pal> getComparator() {
        switch (optionName) {
            case "ID":
                return Comparator.comparingInt(Pal::getPalNumber);
            case "Name":
                return Comparator.comparing(Pal::getName);
            case "Element":
                return Comparator.comparing(Pal::getElementType);
            case "CapturedCount":
                return Comparator.comparingInt(Pal::getCapturedCount);
            default:
                throw new IllegalArgumentException("Invalid sorting option: " + optionName);
        }
    }
}
public class Pal {
    // Pal ID
    private int palNumber;
    // Pal name
    private String name;
    // Pal element
    private String elementType;
    // Pal capture count
    private int capturedCount;

    // constructor for pal
    public Pal(int palNumber, String name, String elementType, int capturedCount) {
        this.palNumber = palNumber;
        this.name = name;
        this.elementType = elementType;
        this.capturedCount = capturedCount;
    }

    // getter
    public int getPalNumber() {
        return palNumber;
    }

    // getter
    public String getName() {
        return name;
    }

    // getter
    public String getElementType() {
        return elementType;
    }

    // getter
    public int getCapturedCount() {
        return capturedCount;
    }

    // setter
    public void setCapturedCount(int capturedCount) {
        this.capturedCount = capturedCount;
    }
}

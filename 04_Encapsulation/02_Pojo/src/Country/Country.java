public class Country {

    private String countryName;
    private int countryPopulation;
    private int countrySquare;
    private String capitalName;
    private boolean seaAccess;

    public Country(String countryName, int countryPopulation, int countrySquare, String capitalName,
                   boolean seaAccess) {
        this.countryName = countryName;
        this.countryPopulation = countryPopulation;
        this.countrySquare = countrySquare;
        this.capitalName = capitalName;
        this.seaAccess = seaAccess;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public void setCountryPopulation(int countryPopulation) {
        this.countryPopulation = countryPopulation;
    }

    public void setCountrySquare(int countrySquare) {
        this.countrySquare = countrySquare;
    }

    public void setCapitalName(String capitalName) {
        this.capitalName = capitalName;
    }

    public void setSeaAccess(boolean seaAccess) {
        this.seaAccess = seaAccess;
    }

    public String getCountryName() {
        return countryName;
    }

    public int getCountryPopulation() {
        return countryPopulation;
    }

    public int getCountrySquare() {
        return countrySquare;
    }

    public String getCapitalName() {
        return capitalName;
    }

    public boolean isSeaAccess() {
        if (this.seaAccess) {
            System.out.println("Выход к морю есть");
        } else {
            System.out.println("Выхода к морю нет");
        }
        return this.seaAccess;
    }
}

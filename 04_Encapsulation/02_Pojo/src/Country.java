public class Country {

    private String countryName;
    private int countryPopulation;
    private int countrySquare;
    private String capitalName;
    private boolean seaAccess;

    public Country(String countryName) {
        this.countryName = countryName;
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
        return seaAccess;
    }
}

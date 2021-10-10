public class Main {
    public static void main(String[] args) {

        Country country = new Country("Canada", 38131104, 9984670,
                "Toronto", true);

        System.out.println(country.getCountryName());
        System.out.println(country.getCountrySquare());
        System.out.println(country.getCountryPopulation());
        System.out.println(country.getCapitalName());
        country.setCapitalName("Ottawa");
        System.out.println(country.getCapitalName());
        country.isSeaAccess();
    }
}

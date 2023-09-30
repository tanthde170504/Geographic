package Controller;

import Model.Country;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import View.MenuModel;
import View.MenuView;

public class ManageEastAsiaCountries {
    
    private final Scanner scanner;
    private final ArrayList<Country> countries;
    private final Validation validator;
    private final MenuModel model;
    private final MenuView view;

    public ManageEastAsiaCountries(MenuModel model, MenuView view) {
        this.model = model;
        this.view = view;
        this.scanner = new Scanner(System.in);
        this.countries = new ArrayList<>();
        this.validator = new Validation();
    }
    
    public void startMenu() {
        while (true) {
            view.Menu();
            int choice = view.UserChoice();

            switch (choice) {
                case 1:
                    inputCountry();
                    break;
                case 2:
                    printCountries();
                    break;
                case 3:
                    searchByName();
                    break;
                case 4:
                    printCountriesSorted();
                    break;
                case 5:
                    System.out.println("Exiting the program.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    
    public void inputCountry() {
        System.out.print("Enter code of country: ");
        String countryCode = validator.checkInputString();
        if (!validator.checkCountryExist(countries, countryCode)) {
            System.err.println("Country already exists.");
            return;
        }
        System.out.print("Enter name of country: ");
        String countryName = validator.checkInputString();
        System.out.print("Enter total area: ");
        double countryArea = validator.checkInputDouble();
        System.out.print("Enter terrain of country: ");
        String countryTerrain = validator.checkInputString();
        countries.add(new Country(countryTerrain, countryCode, countryName, countryArea));
        System.err.println("Add successful.");
    }
    
    public void printCountries() {
        System.out.printf("%-10s%-25s%-20s%-25s\n", "ID", "Name", "Total Area", "Terrain");
        for (Country country : countries) {
            country.display();
        }
    }
    
    public void printCountriesSorted() {
        ArrayList<Country> sortedCountries = new ArrayList<>(countries);
        Collections.sort(sortedCountries);
        System.out.printf("%-10s%-25s%-20s%-25s\n", "ID", "Name", "Total Area", "Terrain");
        for (Country country : sortedCountries) {
            country.display();
        }
    }
    
    public void searchByName() {
        System.out.print("Enter the name you want to search for: ");
        String countryName = validator.checkInputString();
        System.out.printf("%-10s%-25s%-20s%-25s\n", "ID", "Name", "Total Area", "Terrain");
        for (Country country : countries) {
            if (country.getCountryName().equalsIgnoreCase(countryName)) {
                country.display();
            }
        }
    }
    
}
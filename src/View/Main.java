package view;

import Model.Country;
import Controller.ManageEastAsiaCountries;
import java.util.ArrayList;
import View.MenuModel;
import View.MenuView;

public class Main {
    public static void main(String[] args) {
        MenuModel model = new MenuModel();
        MenuView view = new MenuView(model);
        ManageEastAsiaCountries manager = new ManageEastAsiaCountries(model, view);
        manager.startMenu();
}
}
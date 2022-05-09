package learn.solar.ui;

import learn.solar.domain.PanelResult;
import learn.solar.models.Material;
import learn.solar.models.Panel;

import java.util.List;
import java.util.Scanner;

public class View {
    private Scanner console = new Scanner(System.in);

    public void printHeader(String message) {
        int length = message.length();
        System.out.println(message);
        System.out.println("-".repeat(length));
    }

    public int chooseOptionFromMenu() {
        printHeader("Main Menu:");
        System.out.println("0. Exit");
        System.out.println("1. Display Panels By Section");
        System.out.println("2. Add a Panel");
        System.out.println("3. Update a Panel");
        System.out.println("4. Delete a Panel");
        System.out.println();
        return readInt("Select an Option [0-4]: ", 0, 4);
    }

    public void printResult(PanelResult result) {
        if (result.isSuccess()) {
            System.out.println("Operation Successful.");
        } else {
            printHeader("Errors");
            for (String msg : result.getMessages()) {
                System.out.printf("%s%n", msg);
                System.out.println("Could not perform operation. Please try again.");
            }
        }
    }

    public void printPanels(String sectionName, List<Panel> panels) {
        if (panels == null || panels.size() == 0) {
            System.out.println();
            System.out.println("No Panels Found.");
        } else {
            for (Panel p : panels) {
                System.out.println();
                System.out.printf("ID: %s | Section: %s | Row: %s | Column: %s | Year: %s | Material: %s | Tracking: %s%n",
                        p.getPanelId(),
                        p.getSection(),
                        p.getRow(),
                        p.getColumn(),
                        p.getYear(),
                        p.getMaterial().getAbbreviation(),
                        p.isTracking());
            }
        }
    }

    public Panel choosePanel(List<Panel> panels) {
        System.out.println("Select a Panel To Update:");
        Panel result = null;
        if (panels.size() > 0) {
            int panelId = readInt("Select a Panel ID");
            for (Panel panel : panels) {
                if (panel.getPanelId() == panelId) {
                    return panel;
                }
            }
        }
        return null;
    }

    public Panel makePanel() {
        Panel newPanel = new Panel();
        newPanel.getPanelId();
        newPanel.setSection(readRequiredString("Section: "));
        newPanel.setRow(readInt("Row: ", 1, 250));
        newPanel.setColumn(readInt("Column: ", 1, 250));
        newPanel.setYear(readInt("Year installed: ", 1700, 2022));
        newPanel.setMaterial(readMaterial());
        newPanel.setTracking(readBoolean("Panel tracked? [y/n]"));
        System.out.println();
        return newPanel;
    }

    private boolean readBoolean(String prompt) {
        String choice = "";
        do {
            choice = readString(prompt);
            if(!choice.equalsIgnoreCase("y") && !choice.equalsIgnoreCase("n")) {
                System.out.println("Invalid input. Please enter either 'y' or 'n'.");
            }
        } while (!choice.equalsIgnoreCase("y") && !choice.equalsIgnoreCase("n"));

        if (choice.equalsIgnoreCase("y")) {
            return true;
        } else {
            return false;
        }
    }
    public String readSection() {
        String userSelection = readRequiredString("Which section would you like to view?");
        return userSelection;
    }

    private String readString(String prompt) {
        System.out.print(prompt);
        return console.nextLine();
    }

    private String readRequiredString(String prompt) {
        String result = null;
        do {
            result = readString(prompt).trim();
            if (result.isEmpty()) {
                System.out.println("Sorry, value is required");
            }
        } while (result.length() == 0);
        return result;

    }

    private int readInt(String prompt) {
        int result = 0;
        boolean isValid = false;
        while (!isValid) {
            try {
                result = Integer.parseInt(readRequiredString(prompt));
                isValid = true;
            } catch (NumberFormatException ex) {
                System.out.println("Value must be a number");
            }
        }
        return result;
    }

    private int readInt(String prompt, int min, int max) {
        int result = 0;
        do {
            result = readInt(prompt);
            if (result < min || result > max) {
                System.out.printf("Value must be between %s and %s", min, max);
            }
        } while (result < min || result > max);
        return result;
    }

    private Material readMaterial() {
        System.out.println("Material Selection:");
        Material[] materials = Material.values();
        Material result = null;
        for (int i = 0; i < materials.length; i++) {
            System.out.println((i+1) + ". " + materials[i].getAbbreviation());
        }
        int choice = readInt("Choose Material [1-5]: ", 1, 5);
        switch (choice) {
            case 1:
                result = Material.MULTICRYSTALLINE_SILICON;
                break;
            case 2:
                result = Material.MONOCRYSTALLINE_SILICON;
                break;
            case 3:
                result = Material.AMORPHOUS_SILICON;
                break;
            case 4:
                result = Material.CADMIUM_TELLURIDE;
                break;
            case 5:
                result = Material.COPPER_INDIUM_GALLIUM_SELENIDE;
                break;
        }
        return result;
    }
}
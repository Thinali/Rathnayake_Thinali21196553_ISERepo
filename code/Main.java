import java.util.Scanner;

public class SeasonFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the country name: ");
        String country = scanner.nextLine();
        
        if (!isValidCountry(country)) {
            System.out.println("Invalid country name. Please try again.");
            scanner.close();
            return;
        }
        
        System.out.print("Enter the month (1-12): ");
        int month;
        try {
            month = scanner.nextInt();
            if (!isValidMonth(month)) {
                System.out.println("Invalid month. Please try again.");
                scanner.close();
                return;
            }
        } catch (Exception e) {
            System.out.println("Invalid month. Please try again.");
            scanner.close();
            return;
        }
        
        String season = findSeason(country, month);
        System.out.println("The season in " + country + " during month " + month + " is " + season);
        
        scanner.close();
    }
    
    public static String findSeason(String country, int month) {
        String season;
        if (country.equalsIgnoreCase("Australia")) {
            season = getSeasonInAustralia(month);
        } else if (country.equalsIgnoreCase("Canada")) {
            season = getSeasonInCanada(month);
        } else if (country.equalsIgnoreCase("India")) {
            season = getSeasonInIndia(month);
        } else {
            season = "Unknown";
        }
        return season;
    }
    
    public static String getSeasonInAustralia(int month) {
        if (month >= 9 && month <= 11) {
            return "Spring";
        } else if (month >= 12 || (month >= 1 && month <= 2)) {
            return "Summer";
        } else if (month >= 3 && month <= 5) {
            return "Autumn";
        } else {
            return "Winter";
        }
    }
    
    public static String getSeasonInCanada(int month) {
        if (month >= 3 && month <= 5) {
            return "Spring";
        } else if (month >= 6 && month <= 8) {
            return "Summer";
        } else if (month >= 9 && month <= 11) {
            return "Autumn";
        } else {
            return "Winter";
        }
    }
    
    public static String getSeasonInIndia(int month) {
        if (month >= 3 && month <= 6) {
            return "Summer";
        } else if (month >= 7 && month <= 9) {
            return "Monsoon";
        } else if (month >= 10 && month <= 11) {
            return "Post-Monsoon";
        } else {
            return "Winter";
        }
    }
    
    public static boolean isValidCountry(String country) {
        return country.equalsIgnoreCase("Australia") ||
               country.equalsIgnoreCase("Canada") ||
               country.equalsIgnoreCase("India");
    }
    
    public static boolean isValidMonth(int month) {
        return month >= 1 && month <= 12;
    }
}
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

        System.out.print("Display Noongar Season (Only applicable for Australia) Y/N: ");
        String NoongarSeason = scanner.nextLine();

        boolean noongarBit;
        if (NoongarSeason == "Y"){
            noongarBit = true;
        }
        else{
            noongarBit = false;
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
        String season;
        if(!noongarBit){
            season = findSeason(country, month);
        }
        else{
            season = findSeason(country, month, noongarBit);
            if(season == "inexistent"){
                System.out.println("Noongar Seasons do not apply to entered Country. Please try again.");
                scanner.close();
                return;
            }
        }
         
        System.out.println("The season in " + country + " during month " + month + " is " + season);

        scanner.close();
    }

    public static String findSeason(String country, int month) {
        String season;
        if (country.equalsIgnoreCase("Australia")) {
            season = getSeasonInAustralia(month);
        } else if (country.equalsIgnoreCase("Spain") || country.equalsIgnoreCase("Japan")) {
            season = getSeasonInSpainJapan(month);
        } else if (country.equalsIgnoreCase("Malaysia") || country.equalsIgnoreCase("Sri Lanka")) {
            season = getSeasonInMalaysiaSriLanka(month);
        } else if (country.equalsIgnoreCase("Mauritius")) {
        season = getSeasonInMauritius(month);
        } else {
            season = "Unknown";
        }
        return season;
    }

    public static String findSeason(String country, int month, boolean noongarBit) {
    String season;
    if (country.equalsIgnoreCase("Australia")) {
        if (!noongarBit) {
            season = getSeasonInAustralia(month);
        } else {
            season = getNoongarSeason(month);
        }
    }
    else{
        season = "inexistent";
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
        } else if (month >= 6 && month <= 8) {
            return "Winter";
        } else {
            return "Unknown";
        }
    }

    public static String getSeasonInSpainJapan(int month) {
        if (month >= 3 && month <= 5) {
            return "Spring";
        } else if (month >= 6 && month <= 8) {
            return "Summer";
        } else if (month >= 9 && month <= 11) {
            return "Autumn";
        } else if (month >= 12 || (month >= 1 && month <= 2)) {
            return "Winter";
        } else {
            return "Unknown";
        }
    }

    public static String getSeasonInMauritius(int month) {
        if (month == 5) {
            return "Autumn";
        } else if (month >= 6 && month <= 9) {
            return "Winter";
        } else if (month == 10) {
            return "Spring";
        } else if ((month >= 11 && month <= 12) || (month >= 1 && month <= 4)) {
            return "Summer";
        } else {
            return "Unknown";
        }
    }

    public static String getSeasonInMalaysiaSriLanka(int month) {
        if (month >= 3 && month <= 4) {
            return "Inter-monsoon";
        } else if (month >= 5 && month <= 9) {
            return "Southeast Monsoon";
        } else if (month >= 10 && month <= 11) {
            return "Inter-monsoon";
        } else if (month >= 12 || (month >= 1 && month <= 2)) {
            return "Northeast Monsoon";
        } else {
            return "Unknown";
        }
    }

    public static String getNoongarSeason(int month) {
        if (month >= 12 && month <= 1) {
            return "Birak";
        } else if (month >= 2 && month <= 3) {
            return "Bunuru";
        } else if (month >= 4 && month <= 5) {
            return "Djeran";
        } else if (month >= 6 && month <= 7) {
            return "Makuru";
        } else if (month >= 8 && month <= 9 ) {
            return "Djilba";
        } else if (month >= 10 && month <= 11 ) {
            return "Kambarang";
        } else {
            return "Unknown";
        }
    }

    public static boolean isValidCountry(String country) {
        return country.equalsIgnoreCase("Australia") || country.equalsIgnoreCase("Malaysia") || country.equalsIgnoreCase("Sri Lanka")
                || country.equalsIgnoreCase("Mauritius") || country.equalsIgnoreCase("Japan") || country.equalsIgnoreCase("Spain");
    }

    public static boolean isValidMonth(int month) {
        return month >= 1 && month <= 12;
    }
}
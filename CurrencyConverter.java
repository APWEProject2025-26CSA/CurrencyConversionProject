import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
public class CurrencyConverter{
    
    
    //TODO: Fix conversion factors
    public static String[] currenciesA = {"Indian Rupee", "US Dollar", "European Euro", "British Pound", "Canadian Dollar", "Mexican Peso", "United Arab Emirates Dirham", "Korean Won", "Australian Dollar", "Nigerian Naira", "Singapore Dollar", "Chinese Yuan", "Japanese Yen", "Russian Ruble"};
    public static double[] conversionFactorsToDollar = {
        0.012, // 0. Indian Rupee (INR): 1 INR = 0.012 USD
        1.0, // 1. US Dollar (USD): 1 USD = 1.0 USD
        1.09, // 2. European Euro (EUR): 1 EUR = 1.09 USD
        1.25, // 3. British Pound (GBP): 1 GBP = 1.25 USD
        0.74, // 4. Canadian Dollar (CAD): 1 CAD = 0.74 USD
        0.057, // 5. Mexican Peso (MXN): 1 MXN = 0.057 USD
        0.27, // 6. United Arab Emirates Dirham (AED): 1 AED = 0.27 USD
        0.00076, // 7. Korean Won (KRW): 1 KRW = 0.00076 USD
        0.66, // 8. Australian Dollar (AUD): 1 AUD = 0.66 USD
        0.00072, // 9. Nigerian Naira (NGN): 1 NGN = 0.00072 USD
        0.75, // 10. Singapore Dollar (SGD): 1 SGD = 0.75 USD
        0.14, // 11. Chinese Yuan (CNY): 1 CNY = 0.14 USD
        0.0068, // 12. Japanese Yen (JPY): 1 JPY = 0.0068 USD
        0.011, // 13. Russian Ruble (RUB): 1 RUB = 0.011 USD
};
    public static ArrayList<String> currencies = new ArrayList<String>(Arrays.asList(currenciesA));
    public static ArrayList<Double> conversionFactorsToDollar = new ArrayList<Double>(Arrays.asList(conversionFactorsToDollarA));
    
    public int convertFrom;
    public int convertTo;
    public double conversionQTY;
    
    public CurrencyConverter(int ind1, int ind2, double qty){
        this.convertFrom = ind1;
        this.convertTo = ind2;
        this.conversionQTY = qty;
    }
    
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        while (true){
            System.out.println("Hello this is the AP CSA Currency Converter, type \"Bye\" or \"bye\" to exit");
            System.out.println("Here is the list of currencies:");
            
            //For each loop
            int ind = 0;
            for (String currency: currencies){
                System.out.println(ind+". "+currency);
                ind++;
            }
            System.out.println("Which currency would you like to start from?");
            String inpt = scan.nextLine();
            if (inpt.equals("bye") || inpt.equals("Bye")){
                break;
            } else {
                System.out.println("Which currency would you like to convert to?");
                String inpt2 = scan.nextLine();
                if (inpt2.equals("bye") || inpt2.equals("Bye")){
                    break;
                } else {
                    int currencyIndexInpt = Integer.parseInt(inpt);
                    int currencyIndexInpt2 = Integer.parseInt(inpt2);
                    double conversionFactorToDollar = conversionFactorsToDollar.get(currencyIndexInpt);
                    double conversionFactorToCurrency = 1/conversionFactorToDollar;
                    double conversionFactorToDollar2 = conversionFactorsToDollar.get(currencyIndexInpt2);
                    double conversionFactorToCurrency2 = 1/conversionFactorToDollar2;
                    
                    System.out.println("How much of "+currencies.get(currencyIndexInpt)+" do you have?");
                    String QTYIn = scan.nextLine();
                    double QTY = Double.parseDouble(QTYIn);
                    CurrencyConverter cc = new CurrencyConverter(currencyIndexInpt, currencyIndexInpt2, QTY);
                    
                    double USD = QTY*conversionFactorToDollar;
                    double out = USD*conversionFactorToCurrency2;
                    
                    System.out.println(out);
                }
            }
        }
    }
}

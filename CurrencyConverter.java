import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
public class CurrencyConverter{
    
    
    //TODO: Fix conversion factors
    public static String[] currenciesA = {"Indian Rupee", "US Dollar", "European Euro", "British Pound", "Canadian Dollar", "Mexican Peso", "United Arab Emirates Dirham", "Korean Won", "Australian Dollar", "Nigerian Naira", "Singapore Dollar", "Chinese Yuan", "Japanese Yen", "Russian Ruble"};
    public static Double[] conversionFactorsToDollarA = {0.011, 1.0, 0.86, 0.76, 1.40, 18.29, 3.67, 1469.9, 1.52, 1446.75, 1.30, 7.07, 155.46, 77.73};
    
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
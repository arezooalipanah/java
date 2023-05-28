package customers.customersrepo;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.FileReader;
import java.util.List;

public class ConvertCSVToList {
    public static List<Customer> getList(String fileName) {
        List<Customer> customers = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            int iteration = 0;
            while ((line = bufferedReader.readLine()) != null) {
                if (iteration == 0) {
                    iteration++;
                    continue;
                }
                String[] attributes = line.split(",", -1);
                Customer customer = Customer.createCustomer(attributes);
                customers.add(customer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return customers;
    }
}

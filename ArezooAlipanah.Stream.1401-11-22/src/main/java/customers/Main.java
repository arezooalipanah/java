package customers;

import customers.customersrepo.Customer;
import customers.customersrepo.CustomerRepo;
import customers.customersrepo.Enums;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        CustomerRepo customerRepo = new CustomerRepo("churn.csv");

        System.out.println("-----------------add");
        customerRepo.create(new Customer(8888L, "arezoo", 743, Enums.Country.France, Enums.Gender.Male, 2, 1, 0.0d, 131736.88, 1, true, false, 108543.21, false, 0L));
        customerRepo.create(new Customer(5555L, "alipanah", 743, Enums.Country.Spain, Enums.Gender.Male, 2, 1, 0.0d, 131736.88, 1, true, false, 108543.21, false, 0L));

        System.out.println("-----------------get");
        System.out.println(customerRepo.getById(null));
        System.out.println(customerRepo.getById(8888L));

        System.out.println("-----------------put");
        System.out.println(customerRepo.put(8888L,
                new Customer(8888L, "new arezooo", 743, Enums.Country.France, Enums.Gender.Male, 3, 1, 0.0d, 131736.88, 1, true, false, 108543.21, false, 0L)));
        customerRepo.put(null, new Customer(3333L, "new arezooo", 743, Enums.Country.France, Enums.Gender.Male, 3, 1, 0.0d, 131736.88, 1, true, false, 108543.21, false, 0L));

        System.out.println("-----------------delete");
        customerRepo.deleteById(null);
        customerRepo.deleteById(5555L);

        System.out.println("-----------------most credit score");
        System.out.println(customerRepo.getMostCreditScore());
        System.out.println(customerRepo.getMostCreditScore2());
        System.out.println(customerRepo.getMostExitedCreditScore());

        System.out.println("-----------------remove empty id or name");
        customerRepo.removeEmptyNameOrId();

        System.out.println("-----------------get men");
        System.out.println(customerRepo.getSpecificMen(Enums.Country.France, 60000D));

        System.out.println("-----------------get customers by ids");
        System.out.println(customerRepo.getByIds(Arrays.asList(15717426L, 15585768L, 15619360L, 15738148L, 15687946L)));

        System.out.println("-----------------sort by credit score");
        System.out.println(customerRepo.sortByCreditScore());

        System.out.println("-----------------get less salary");
        System.out.println(customerRepo.getByLessSalaries(10));
        System.out.println(customerRepo.getByLessSalaries(10).size());

        System.out.println("-----------------average salary");
        System.out.println(customerRepo.calcAverageSalary(Enums.Country.Spain));

        System.out.println("-----------------total loan");
        System.out.println(customerRepo.calcTotalLoan(Enums.Country.Spain));

        System.out.println("-----------------get countries");
        System.out.println(customerRepo.getCountriesName());
    }
}

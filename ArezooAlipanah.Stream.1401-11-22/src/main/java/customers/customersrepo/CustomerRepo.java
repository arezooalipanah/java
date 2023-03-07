package customers.customersrepo;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Objects.isNull;

public class CustomerRepo {
    private final String resourcePath;
    private List<Customer> customers;

    public CustomerRepo(String resourcePath) {
        this.resourcePath = resourcePath;
        this.customers = new ArrayList<>(ConvertCSVToList.getList(resourcePath));
    }

    public void create(Customer customer) {
        try {
            customers = Stream.concat(customers.stream(), Stream.of(customer)).collect(Collectors.toList());
            System.out.println("Customer " + customer.getSurname() + " created " + customer);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(String.format("Exception in creating customer%s", e));
        }
    }

    public Customer getById(Long customerId) {
        try {
            Optional<Customer> customer = customers.stream()
                    .filter(cus -> customerId.equals(cus.getCustomerId()))
                    .collect(Collectors.toList()).stream().findFirst();
            return customer.orElse(null);
        } catch (NullPointerException e) {
            System.out.println("NullPointerException thrown in getting customer!");
        }

        return null;
    }

    public Customer put(Long customerId, Customer customer) {
        try {
            customers.stream().filter(c -> customerId.equals(c.getCustomerId())).forEach(c -> {
                c.setCustomerId(customerId);
                c.setSurname(customer.getSurname());
                c.setCreditScore(customer.getCreditScore());
                c.setGeography(customer.getGeography());
                c.setGender(customer.getGender());
                c.setAge(customer.getAge());
                c.setTenure(customer.getTenure());
                c.setBeginningBalance(customer.getBeginningBalance());
                c.setBalance(customer.getBalance());
                c.setNumOfProducts(customer.getNumOfProducts());
                c.setHasCrCard(customer.getHasCrCard());
                c.setActiveMember(customer.getActiveMember());
                c.setEstimatedSalary(customer.getEstimatedSalary());
                c.setExited(customer.getExited());
                c.setCurrentLoanAmount(customer.getCurrentLoanAmount());
            });

            System.out.println("Customer " + customerId + " updated");
            return customer;
        } catch (NullPointerException e) {
            System.out.println("NullPointerException thrown in updating customer! ");
        }
        return null;
    }

    public void deleteById(Long customerId) {
        try {
            System.out.println(customers.size());
            Predicate<Customer> isCustomerId = customer -> customerId.equals(customer.getCustomerId());
            customers.removeIf(isCustomerId);
            System.out.println(customers.size());
            System.out.println("Customer " + customerId + " deleted");
        } catch (NullPointerException e) {
            System.out.println("NullPointerException thrown in deleting customer! ");
        }
    }

    public Customer getMostCreditScore() {
        Optional<Customer> result = customers.stream()
                .sorted(Comparator.comparing(Customer::getCreditScore,
                        Comparator.nullsFirst(Comparator.naturalOrder())))
                .reduce((first, second) -> second);

        return result.orElse(null);
    }

    public Customer getMostCreditScore2() {
        Optional<Customer> result = customers.stream()
                .max(Comparator.comparing(Customer::getCreditScore,
                        Comparator.nullsFirst(Comparator.naturalOrder())));

        return result.orElse(null);
    }

    public Customer getMostExitedCreditScore() {
        Optional<Customer> result = customers.stream()
                .filter(Customer::getExited)
                .max(Comparator.comparing(Customer::getCreditScore,
                        Comparator.nullsFirst(Comparator.naturalOrder())));

        return result.orElse(null);
    }

    public void removeEmptyNameOrId() {
        System.out.println("before removing " + customers.size());
        customers.removeIf(c -> c.getSurname().equals("") || isNull(c.getCustomerId()));
        System.out.println("after removing " + customers.size());
    }

    public List<Customer> getSpecificMen(Enums.Country country, Double salary) {
        return customers.stream()
                .filter(c -> c.getGender().equals(Enums.Gender.Male)
                        && c.getEstimatedSalary() < salary
                        && c.getGeography().equals(country)).collect(Collectors.toList());
    }

    public List<Customer> getByIds(List<Long> ids) {
        return customers.stream().filter(c -> ids.contains(c.getCustomerId()))
                .collect(Collectors.toList());
    }

    public List<Customer> sortByCreditScore() {
        return customers.stream()
                .sorted(Comparator.comparing(Customer::getCreditScore,
                        Comparator.nullsFirst(Comparator.naturalOrder())))
                .collect(Collectors.toList());
    }

    public List<Customer> getByLessSalaries(int limit) {
        return customers.stream()
                .sorted(Comparator.comparing(Customer::getEstimatedSalary,
                        Comparator.nullsFirst(Comparator.naturalOrder())))
                .limit(limit)
                .collect(Collectors.toList());
    }

    public Double calcAverageSalary(Enums.Country country) {
        OptionalDouble avg = customers.stream()
                .filter(c -> c.getGeography().equals(country))
                .mapToDouble(Customer::getEstimatedSalary)
                .average();

        return avg.isPresent() ? avg.getAsDouble() : null;
    }

    public Long calcTotalLoan(Enums.Country country) {
        OptionalLong total = customers.stream()
                .filter(c -> c.getGeography().equals(country) && !isNull(c.getCurrentLoanAmount()))
                .mapToLong(Customer::getCurrentLoanAmount)
                .reduce(Long::sum);

        return total.isPresent() ? total.getAsLong() : null;
    }

    public List<Enums.Country> getCountriesName() {
        List<Enums.Country> countries = customers.stream()
                .map(Customer::getGeography)
                .distinct().collect(Collectors.toList());

        return countries;
    }

    @Override
    public String toString() {
        return "Customers{" +
                "resourceName='" + resourcePath + '\'' +
                ", customers=" + customers +
                '}';
    }
}

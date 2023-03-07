package customers.customersrepo;

public class Customer {
    private Long customerId;
    private String surname;
    private Integer creditScore;
    private Enums.Country geography;
    private Enums.Gender gender;
    private Integer age;
    private Integer tenure;
    private Double beginningBalance;
    private Double balance;
    private Integer numOfProducts;
    private Boolean hasCrCard;
    private Boolean isActiveMember;
    private Double estimatedSalary;
    private Boolean exited;
    private Long currentLoanAmount;

    public Customer(Long customerId, String surname, Integer creditScore, Enums.Country geography, Enums.Gender gender, Integer age, Integer tenure, Double beginningBalance, Double balance, Integer numOfProducts, Boolean hasCrCard, Boolean isActiveMember, Double estimatedSalary, Boolean exited, Long currentLoanAmount) {
        this.customerId = customerId;
        this.surname = surname;
        this.creditScore = creditScore;
        this.geography = geography;
        this.gender = gender;
        this.age = age;
        this.tenure = tenure;
        this.beginningBalance = beginningBalance;
        this.balance = balance;
        this.numOfProducts = numOfProducts;
        this.hasCrCard = hasCrCard;
        this.isActiveMember = isActiveMember;
        this.estimatedSalary = estimatedSalary;
        this.exited = exited;
        this.currentLoanAmount = currentLoanAmount;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public String getSurname() {
        return surname;
    }

    public Integer getCreditScore() {
        return creditScore;
    }

    public Enums.Country getGeography() {
        return geography;
    }

    public Enums.Gender getGender() {
        return gender;
    }

    public Integer getAge() {
        return age;
    }

    public Integer getTenure() {
        return tenure;
    }

    public Double getBeginningBalance() {
        return beginningBalance;
    }

    public Double getBalance() {
        return balance;
    }

    public Integer getNumOfProducts() {
        return numOfProducts;
    }

    public Boolean getHasCrCard() {
        return hasCrCard;
    }

    public Boolean getActiveMember() {
        return isActiveMember;
    }

    public Double getEstimatedSalary() {
        return estimatedSalary;
    }

    public Boolean getExited() {
        return exited;
    }

    public Long getCurrentLoanAmount() {
        return currentLoanAmount;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setCreditScore(Integer creditScore) {
        this.creditScore = creditScore;
    }

    public void setGeography(Enums.Country geography) {
        this.geography = geography;
    }

    public void setGender(Enums.Gender gender) {
        this.gender = gender;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setTenure(Integer tenure) {
        this.tenure = tenure;
    }

    public void setBeginningBalance(Double beginningBalance) {
        this.beginningBalance = beginningBalance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public void setNumOfProducts(Integer numOfProducts) {
        this.numOfProducts = numOfProducts;
    }

    public void setHasCrCard(Boolean hasCrCard) {
        this.hasCrCard = hasCrCard;
    }

    public void setActiveMember(Boolean activeMember) {
        isActiveMember = activeMember;
    }

    public void setEstimatedSalary(Double estimatedSalary) {
        this.estimatedSalary = estimatedSalary;
    }

    public void setExited(Boolean exited) {
        this.exited = exited;
    }

    public void setCurrentLoanAmount(Long currentLoanAmount) {
        this.currentLoanAmount = currentLoanAmount;
    }

    private static Long parseLong(String value) {
        try {
            return Long.valueOf(value);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private static Double parseDouble(String value) {
        try {
            return Double.valueOf(value);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private static Integer parseInteger(String value) {
        try {
            return Integer.valueOf(value);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public static boolean getBoolean(String value) {
        return !value.equals("0");
    }

    public static Customer createCustomer(String[] metadata) {
        Long customerId = parseLong(metadata[1]);
        String surname = metadata[2];
        Integer creditScore = parseInteger(metadata[3]);
        Enums.Country geography = Enums.Country.valueOf(metadata[4]);
        Enums.Gender gender = Enums.Gender.valueOf(metadata[5]);
        Integer age = parseInteger(metadata[6]);
        Integer tenure = parseInteger(metadata[7]);
        Double beginningBalance = parseDouble(metadata[8]);
        Double balance = parseDouble(metadata[9]);
        Integer numOfProducts = parseInteger(metadata[10]);
        Boolean hasCrCard = getBoolean(metadata[11]);
        Boolean isActiveMember = getBoolean(metadata[12]);
        Double estimatedSalary = parseDouble(metadata[13]);
        Boolean exited = getBoolean(metadata[14]);
        Long currentLoanAmount = parseLong(metadata[15]);

        return new Customer(customerId, surname, creditScore, geography, gender, age, tenure, beginningBalance, balance, numOfProducts, hasCrCard, isActiveMember, estimatedSalary, exited, currentLoanAmount);
    }

    @Override
    public String toString() {
        return "Customer{" +
                " customerId=" + customerId +
                ", surname='" + surname + '\'' +
                ", creditScore=" + creditScore +
                ", geography=" + geography +
                ", gender=" + gender +
                ", age=" + age +
                ", tenure=" + tenure +
                ", beginningBalance=" + beginningBalance +
                ", balance=" + balance +
                ", numOfProducts=" + numOfProducts +
                ", hasCrCard=" + hasCrCard +
                ", isActiveMember=" + isActiveMember +
                ", estimatedSalary=" + estimatedSalary +
                ", exited=" + exited +
                ", currentLoanAmount=" + currentLoanAmount +
                '}';
    }
}

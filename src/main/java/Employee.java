public class Employee {

    private String name;
    private double totalSales;
    private double salesPeriod;
    private double experienceMultiplier;
    private double score;

    public Employee(String name, double totalSales, double salesPeriod, double experienceMultiplier) {
        this.setName(name);
        this.setTotalSales(totalSales);
        this.setSalesPeriod(salesPeriod);
        this.setExperienceMultiplier(experienceMultiplier);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("The Employee's name cannot be null.");
        }

        this.name = name;
    }

    public double getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(double totalSales) {
        if (totalSales < 0) {
            throw new IllegalArgumentException("Employee total sales must be a positive number.");
        }

        this.totalSales = totalSales;
    }

    public double getSalesPeriod() {
        return salesPeriod;
    }

    public void setSalesPeriod(double salesPeriod) {
        if (salesPeriod < 0) {
            throw new IllegalArgumentException("Employee sales period must be a positive number.");
        }

        this.salesPeriod = salesPeriod;
    }

    public double getExperienceMultiplier() {
        return experienceMultiplier;
    }

    public void setExperienceMultiplier(double experienceMultiplier) {
        if (experienceMultiplier < 0) {
            throw new IllegalArgumentException("Employee experience multiplier must be a positive number.");
        }

        this.experienceMultiplier = experienceMultiplier;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}

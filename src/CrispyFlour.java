import java.time.LocalDate;

public class CrispyFlour extends Material {
    private double quantity;

    @Override
    public double getAmount() {
        return this.quantity * this.cost;
    }

    @Override
    public LocalDate getExpiryDate() {
        return manufacturingDate.plusYears(1);
    }

    public CrispyFlour(String id, String name, LocalDate manufacturingDate, int cost, double quantity) {
        super(id, name, manufacturingDate, cost);
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "CrispyFlour{" +
                "quantity=" + quantity +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", manufacturingDate=" + manufacturingDate +
                ", cost=" + cost +
                '}';
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    @Override
    public double getRealMoney() {
        LocalDate today = manufacturingDate;
        LocalDate ExpiryDate = getExpiryDate();
        if (today.isAfter(ExpiryDate.minusMonths(2))) {
            return getAmount() - (getAmount() * 0.4);
        } else if (today.isAfter(ExpiryDate.minusMonths(4))) {
            return getAmount() - (getAmount() * 0.2);
        } else {
            return getAmount() - (getAmount() * 0.05);
        }
    }
}
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Scanner;


public class Main {


    public static void main(String[] args) {
        ArrayList<Material> materials;
        materials = new ArrayList<>();
        materials.add(new Meat("1", "Thit lonw", LocalDate.now().plusDays(2), 120, 3));
        materials.add(new Meat("2", "Thit chos", LocalDate.now().plusDays(3), 200, 4));
        materials.add(new Meat("3", "Thit bo", LocalDate.now().plusDays(4), 250, 1));
        materials.add(new Meat("4", "Thit ga", LocalDate.now().plusDays(5), 90, 2));
        materials.add(new Meat("5", "Thit dee", LocalDate.now().plusDays(6), 220, 6));
        materials.add(new CrispyFlour("6", "bot chien khong gion", LocalDate.now().plusMonths(5), 120, 2));
        materials.add(new CrispyFlour("7", "bot chien gion", LocalDate.now().plusMonths(8), 120, 3));
        materials.add(new CrispyFlour("8", "bot chien chua chac da gion", LocalDate.now().plusMonths(2), 120, 4));
        materials.add(new CrispyFlour("9", "rat gion", LocalDate.now().plusMonths(6), 120, 5));
        materials.add(new CrispyFlour("10", "bot chien xu", LocalDate.now().plusMonths(7), 120, 6));
        System.out.println(materials);
        getToMeatPrice();
        getToCrispyFlourPrice();
        addElement();
        deleteElement();
    }

    public static void getToCrispyFlourPrice() {
        double cost = 0;
        double sale = 0;
        double discount;
        for (Material material : materials
        ) {
            if (material instanceof CrispyFlour) {
                cost += material.getAmount();
                sale += material.getRealMoney();
            }
        }
        discount = cost - sale;
        System.out.println("Giá ban dau: " + cost);
        System.out.println("Giá sale: " + sale);
        System.out.println("Giá chiet khau: " + discount);
    }

    public static void getToMeatPrice() {
        double cost = 0;
        double sale = 0;
        double discount;
        for (Material material : materials
        ) {
            if (material instanceof Meat) {
                cost += material.getAmount();
                sale += material.getRealMoney();
            }
        }
        discount = cost - sale;
        System.out.println("Giá ban dau: " + cost);
        System.out.println("Giá sau sale: " + sale);
        System.out.println("Giá chiết khấu: " + discount);
    }
    public static void addElement(Material material) {
        Scanner input = new Scanner(System.in);
        int index;
        System.out.print("Nhập vị trí muốn thêm: ");
        index = input.nextInt();
        for (int i = 0; i < materials.size(); i++) {
            if (i == index) {
                materials.add(i, material);
            } else if (index >= materials.size()) {
                materials.add(material);
                System.out.println("Không thể thêm tại vị trí số " + index);
                break;
            }
        }
    }
    public static void deleteElement() {
        Scanner input = new Scanner(System.in);
        int index;
        System.out.print("Nhập vị trí muốn xóa: ");
        index = input.nextInt();
        for (int i = 0; i < materials.size(); i++) {
            if (i == index) {
                materials.remove(i);
            } else if (index >= materials.size()) {
                System.out.println("Không tìm thấy vị trí số " + index);
                break;
            }
        }
    }
}






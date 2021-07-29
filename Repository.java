import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class Repository {

    List<Product> listProducts = new ArrayList<>();
    List<Product> listType;
    Scanner sc = new Scanner(System.in);

    public Repository() {
        listProducts.add(new Product(1, "Bánh mì", Type.Food, 100, 3500, 57));
        listProducts.add(new Product(2, "A'o phông", Type.Fashion, 100, 100000, 50));
        listProducts.add(new Product(3, "Máy sinh tố", Type.Houseware, 100, 3500, 57));
        listProducts.add(new Product(4, "Son môi", Type.Cosmetic, 100, 3500, 57));
        listProducts.add(new Product(5, "Bút chì", Type.Cosmetic, 100, 3500, 57));
        listProducts.add(new Product(6, "Bếp hồng ngoại", Type.Houseware, 100, 3500, 57));
        listProducts.add(new Product(7, "Váy", Type.Fashion, 100, 3500, 57));
        listProducts.add(new Product(8, "Gạo Thái", Type.Food, 100, 3500, 57));
        listProducts.add(new Product(9, "Giày Nice", Type.Fashion, 100, 3500, 57));
        listProducts.add(new Product(10, "Sơn móng", Type.Cosmetic, 100, 3500, 57));

    }

    public void show() {
        for (Product product : listProducts) {
            System.out.println(product);
        }
    }

    public void add() {

        System.out.println("Nhập id SP mới");
        int idA = Integer.valueOf(sc.nextLine());
        System.out.println("Nhập tên SP mới");
        String nameA = sc.nextLine();
        System.out.println("Nhập loại SP mới :");
        System.out.println(" A - Thức ăn, B - Đồ gia dụng, C -Mĩ phẩm, D - Thời trang");
        String s = sc.nextLine();
        Type typeA = null;
        if (s.equals("A")) {
            typeA = Type.Food;
        } else if (s.equals("B")) {
            typeA = Type.Houseware;
        } else if (s.equals("C")) {
            typeA = Type.Cosmetic;
        } else if (s.equals("D")) {
            typeA = Type.Fashion;
        }
        System.out.println("SL nhập");
        long inputAmountA = Integer.valueOf(sc.nextLine());
        System.out.println("Giá bán");
        long priceA = Integer.valueOf(sc.nextLine());
        System.out.println("SL bán");
        long sellAmountA = Integer.valueOf(sc.nextLine());

        listProducts.add(new Product(idA, nameA, typeA, inputAmountA, priceA, sellAmountA));
        for (Product product : listProducts) {
            System.out.println(product);
        }
    }

    public void editProduct(List<Product> listProducts) {

        System.out.println("Nhập ID SP mà bạn muốn sửa: ");

        int code = sc.nextInt();
        boolean checkCode = false;
        for (Product product : listProducts) {
            if (product.getId() == (code)) {

                checkCode = true;
                System.out.println("Thông tin sản phẩm cần sửa \n" + product);

                for (int i = 0; i < listProducts.size(); i++) {
                    if (product.getId() == i + 1) {
                        // System.out.println(listProducts.get(i).toString());
                        Scanner sc = new Scanner(System.in);
                        System.out.print("Nhập tên mới: ");
                        String name = sc.nextLine();
                        listProducts.get(i).setName(name);
                        System.out.println("Nhập loại SP mới :");
                        System.out.println(" A - Thức ăn, B - Đồ gia dụng, C -Mĩ phẩm, D - Thời trang");
                        String s = sc.nextLine();
                        Type typeA = null;
                        if (s.equals("A")) {
                            typeA = Type.Food;
                        } else if (s.equals("B")) {
                            typeA = Type.Houseware;
                        } else if (s.equals("C")) {
                            typeA = Type.Cosmetic;
                        } else if (s.equals("D")) {
                            typeA = Type.Fashion;
                        }
                        System.out.println("Nhập SL nhập mới : ");
                        long importPrice = sc.nextLong();
                        listProducts.get(i).setInputAmount(importPrice);
                        System.out.print("Nhập giá bán mới: ");
                        long salePrice = sc.nextLong();
                        listProducts.get(i).setPrice(salePrice);

                        System.out.print("Nhập số lượng bán mới: ");
                        int amountSale = sc.nextInt();
                        listProducts.get(i).setSellAmount(amountSale);
                        sc.nextLine();

                        System.out.println("Sản phẩm sau khi sửa là: ");
                        System.out.println(listProducts.get(i).toString());
                    }
                }
            }
        }
        if (!checkCode)
            System.out.println("Mã ID không đúng");
    }

    public void delete(List<Product> listProducts) {
        System.out.println("Nhập ID SP mà bạn muốn xoá: ");

        int num = Integer.valueOf( sc.nextLine());
        boolean checkNum = false;
        for (Product product : listProducts) {
            if (product.getId() == (num)) {

                checkNum = true;
                System.out.println("Thông tin sản phẩm cần xoá \n" + product);
                System.out.println("Bạn chắc muốn xoá Sp này");
                System.out.println("1- Xoá      2- Quay lại");
                int choice = Integer.valueOf(sc.nextLine());
               switch (choice) {
                    case 1:
                        listProducts.remove(product);
                 System.out.println("Danh sách SP sau khi xoá");
                        for (Product product1 : listProducts) {
                           
                          System.out.println(product1);
                      }
                        break;
                    case 2:
                        delete(listProducts);
                        
                }
            }
        }
        if (!checkNum)
            System.out.println("Mã ID không đúng");
    }

  

    public void checkSellAmount() {
        Map<String, Long> sell = new HashMap<>();
        for (Product product : listProducts) {

            sell.put(product.getName(), product.getSellAmount());
        }

        for (Map.Entry<String, Long> entry : sell.entrySet()) {
            System.out.println("SP :" + entry.getKey() + " -SL bán : " + entry.getValue());
        }
    }
    
 public void checkType(List<Product> listProducts) {
        Map<Type, Integer> countMap = new HashMap<>();
        for (Product product : listProducts) {
            if (!countMap.containsKey(product.getType())) {
                countMap.put(product.getType(), 1);
            } else countMap.put(product.getType(), countMap.get(product.getType()) + 1);
        }

         for (Map.Entry<Type, Integer> entry : countMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue() +" SP");
        }
    }
}

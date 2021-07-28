import java.util.Scanner;
import java.util.jar.Attributes.Name;

public class App {
    public static void main(String[] args) throws Exception {
        Repository list = new Repository();
        while (true) {
          
            Scanner sc = new Scanner (System.in);
            
            System.out.println("1 - Xem sản phẩm");
            System.out.println("2 - Thêm mới sản phẩm");
            System.out.println("3 - Tìm sản phẩm theo mã sản phẩm và sửa sản phẩm đó");
            System.out.println("4 - Tìm sản phẩm theo mã sản phẩm và xoá sản phẩm đó");
            System.out.println("5 - Xem sản phẩm và số lượng bán được (Sử dụng Map)");
            System.out.println("6 - Liệt kê loại sản phẩm và số lượng sản phẩm thuộc loại đó");
            System.out.println("0 - Thoát");
            System.out.println("----------------------------------------------------------------------------");
            int i = Integer.valueOf(sc.nextLine()) ;
            switch (i){
            case 0:
                    System.exit(0);
                    break;
                case 1:
                    System.out.println(" DANH SÁCH SẢN PHẨM");
                    list.show();
                    System.out.println("----------------------------------------------------------------------------");
                 break;
             case 2:
                 list.add();
                    System.out.println("----------------------------------------------------------------------------");
                 break;
             case 3:
               
                    list.editProduct(list.listProducts);
                    System.out.println("----------------------------------------------------------------------------");
                 break;
             case 4:
               list.delete(list.listProducts);
                    System.out.println("----------------------------------------------------------------------------");
                 break;
               
                
                 
             case 5:
                 list.checkSellAmount();
                System.out.println("----------------------------------------------------------------------------");
                 break;
             case 6:
                 list.checkType(list.listProducts);
                System.out.println("----------------------------------------------------------------------------");
                 break;
            }
            

        }
    }
}

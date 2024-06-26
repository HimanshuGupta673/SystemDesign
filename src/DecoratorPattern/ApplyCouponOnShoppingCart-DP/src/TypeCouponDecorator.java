import java.util.ArrayList;
import java.util.List;

public class TypeCouponDecorator extends CouponDecorator{

    Product product;
    int discountPercentage;
    ProductType type;
    static List<ProductType> elegibleType = new ArrayList<ProductType>();

    static {
        elegibleType.add(ProductType.FURNITURE_GOODS);
        elegibleType.add(ProductType.ELECTRONICS_GOODS);
    }

    TypeCouponDecorator(Product product, int discountPercentage, ProductType type){
        this.product = product;
        this.discountPercentage = discountPercentage;
        this.type = type;
    }

    @Override
    public double getPrice() {
        double price = product.getPrice();
        if(elegibleType.contains(type)){
            return price-(price*discountPercentage)/100;
        }
        return price;
    }
}

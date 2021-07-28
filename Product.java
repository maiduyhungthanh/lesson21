public class Product {
    private int id;
    private String name;
    private Type type;
    private long inputAmount;
    private long price;
    private long sellAmount;
    public Product(int id, String name, Type type, long inputAmount, long price, long sellAmount) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.inputAmount = inputAmount;
        this.price = price;
        this.sellAmount = sellAmount;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Type getType() {
        return type;
    }
    public void setType(Type type) {
        this.type = type;
    }
    public long getInputAmount() {
        return inputAmount;
    }
    public void setInputAmount(long inputAmount) {
        this.inputAmount = inputAmount;
    }
    public long getPrice() {
        return price;
    }
    public void setPrice(long price) {
        this.price = price;
    }
    public long getSellAmount() {
        return sellAmount;
    }
    public void setSellAmount(long sellAmount) {
        this.sellAmount = sellAmount;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return id + "-" + name + "-" + type.getAbb() + "- SL nhập " + inputAmount + "- Giá bán "+ price + "- SL bán"+ sellAmount ;
    }
}

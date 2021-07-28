public enum Type {
     Food("Thức ăn"), Houseware("Đồ gia dụng"), Cosmetic("Mỹ phẩm"), Fashion("Thời trang");

    private String abb;

    private Type(String abb) {
        this.abb = abb;
    }

    public String getAbb() {
        return abb;
    }

    public void setAbb(String abb) {
        this.abb = abb;
    }
    
}

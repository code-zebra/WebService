package cn.hainu.domain;

import java.io.Serializable;

/**
 * @author 黄杰峰
 * 历史订单中的商品
 */
public class FoodInList implements Serializable {

    /**
     * 食物名称、数量、价格
     */
    private String foodName;
    private int count;
    private int price;

    @Override
    public String toString() {
        return "FoodInList{" +
                "foodName='" + foodName + '\'' +
                ", count=" + count +
                ", price=" + price +
                '}';
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

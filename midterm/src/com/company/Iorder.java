package com.company;

import java.util.List;

public interface Iorder {
    public void Takeorder(List<Item>items,int CustomerID);
    public List<Item> sendOrder();
    public void clean();

}

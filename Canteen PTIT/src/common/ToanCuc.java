package common;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Pham Van Thanh
 */
public class ToanCuc {
    private static String username;
    private static int table_id;
    private static int order_id;

    

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        ToanCuc.username = username;
    }

    public static int getTable_id() {
        return table_id;
    }

    public static void setTable_id(int table_id) {
        ToanCuc.table_id = table_id;
    }
    
    public static int getOrder_id() {
        return order_id;
    }

    public static void setOrder_id(int order_id) {
        ToanCuc.order_id = order_id;
    }
    
    
}

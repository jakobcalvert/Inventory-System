/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package InventoryManagementSystem;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jakob
 */
public class PricedByWeightTest {
    
    public PricedByWeightTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setPricePerKg method, of class PricedByWeight.
     */
    @Test
    public void testSetPricePerKg() {
        double amount = 5;
        PricedByWeight instance = new PricedByWeight("123",0,0,0);
        instance.setPricePerKg(amount);
        assertEquals(instance.getPricePerKg(),amount,0.00000000000001);
    }

    /**
     * Test of setAmountKg method, of class PricedByWeight.
     */
    @Test
    public void testSetAmountKg() {
        double amount = 5;
        PricedByWeight instance = new PricedByWeight("123",0,0,0);
        instance.setAmountKg(amount);
        assertEquals(instance.getAmountKg(),amount,0.00000000000001);
    }

    /**
     * Test of setStockPrice method, of class PricedByWeight.
     */
    @Test
    public void testSetStockPrice() {
        double amount = 5;
        PricedByWeight instance = new PricedByWeight("123",0,0,0);
        instance.setStockPrice(amount);
        assertEquals(instance.getStockPrice(),amount,0.00000000000001);
    }


    /**
     * Test of compareTo method, of class PricedByWeight.
     */
    @Test
    public void testCompareTo() {
        PricedByWeight instance = new PricedByWeight("123",0,4,0);
        PricedByWeight instance2 = new PricedByWeight("123",0,5,0);
        int i = instance.compareTo(instance2);
        assertEquals(i,-1);
    }
    @Test
    public void testCompareTo2() {
        PricedByWeight instance = new PricedByWeight("123",0,5,0);
        PricedByWeight instance2 = new PricedByWeight("123",0,5,0);
        int i = instance.compareTo(instance2);
        assertEquals(i,0);
    }
    @Test
    public void testCompareTo3() {
        PricedByWeight instance = new PricedByWeight("123",0,6,0);
        PricedByWeight instance2 = new PricedByWeight("123",0,5,0);
        int i = instance.compareTo(instance2);
        assertEquals(i,1);
    }
    @Test
    public void testCompareTo4() {
        PricedByWeight instance = new PricedByWeight("123",0,6,0);
        PricedByUnit instance2 = new PricedByUnit("123",0,5,0,0);
        int i = instance.compareTo(instance2);
        assertEquals(i,-1);
    }
    
}

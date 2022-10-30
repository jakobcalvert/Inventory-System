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
public class PricedByUnitTest {

    public PricedByUnitTest() {
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
     * Test of setWeight method, of class PricedByUnit.
     */
    @Test
    public void testSetWeight() {
        double amount = 5;
        PricedByUnit instance = new PricedByUnit("123", 0, 0, 0, 0);
        instance.setWeight(amount);
        assertEquals(instance.getWeight(), amount, 0.00000000000001);
    }

    /**
     * Test of setAmount method, of class PricedByUnit.
     */
    @Test
    public void testSetAmount() {
        int amount = 5;
        PricedByUnit instance = new PricedByUnit("123", 0, 0, 0, 0);
        instance.setAmount(amount);
        assertEquals(instance.getAmount(), amount);
    }

    /**
     * Test of setPrice method, of class PricedByUnit.
     */
    @Test
    public void testSetPrice() {
        double amount = 5;
        PricedByUnit instance = new PricedByUnit("123", 0, 0, 0, 0);
        instance.setPrice(amount);
        assertEquals(instance.getPrice(), amount, 0.00000000000001);
    }

    /**
     * Test of setStockPrice method, of class PricedByUnit.
     */
    @Test
    public void testSetStockPrice() {
        double amount = 5;
        PricedByUnit instance = new PricedByUnit("123", 0, 0, 0, 0);
        instance.setStockPrice(amount);
        assertEquals(instance.getStockPrice(), amount, 0.00000000000001);
    }

    /**
     * Test of compareTo method, of class PricedByUnit.
     */
    @Test
    public void testCompareTo() {

        int amount = 5;
        PricedByUnit instance = new PricedByUnit("123", 0, 4, 0, 0);
        PricedByUnit instance2 = new PricedByUnit("123", 0, 5, 0, 0);
        int i = instance.compareTo(instance2);
        assertEquals(i, -1);
    }

    @Test
    public void testCompareTo2() {

        int amount = 5;
        PricedByUnit instance = new PricedByUnit("123", 0, 5, 0, 0);
        PricedByUnit instance2 = new PricedByUnit("123", 0, 5, 0, 0);
        int i = instance.compareTo(instance2);
        assertEquals(i, 0);
    }

    @Test
    public void testCompareTo3() {

        int amount = 5;
        PricedByUnit instance = new PricedByUnit("123", 0, 6, 0, 0);
        PricedByUnit instance2 = new PricedByUnit("123", 0, 5, 0, 0);
        int i = instance.compareTo(instance2);
        assertEquals(i, 1);
    }

    @Test
    public void testCompareTo4() {
        PricedByUnit instance = new PricedByUnit("123", 0, 6, 0,0);
        PricedByWeight instance2 = new PricedByWeight("123", 0, 5, 0);
        int i = instance.compareTo(instance2);
        assertEquals(i, 1);
    }

    /**
     * Test of removeAmount method, of class PricedByUnit.
     */
    @Test
    public void testRemoveAmount() {

        int amount = 5;
        PricedByUnit instance = new PricedByUnit("123", 0, 5, 0, 0);
        instance.removeAmount(amount);
        assertEquals(instance.getAmount(), 0);
    }

    /**
     * Test of addAmount method, of class PricedByUnit.
     */
    @Test
    public void testAddAmount() {

        int amount = 5;
        PricedByUnit instance = new PricedByUnit("123", 0, 0, 0);
        instance.addAmount(amount);
        assertEquals(instance.getAmount(), amount);

    }

}

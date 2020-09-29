// --== CS400 File Header Information ==--
// Name: <Jiangang Chen>
// Email: <jiangang.chen@wisc.edu>
// Team: <HE>
// Role: <Test Engineering 1>
// TA: <Na Li>
// Lecturer: <Florian Heimerl>
// Notes to Grader: <optional extra notes>

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * Please provide a accessor to HashTable capacity: hashTable.getCapacity())
 * Please provide a accessor to HashTable capacity: hashTable.getCapacity())
 * Please provide a accessor to HashTable capacity: hashTable.getCapacity())
 */
public class TestHashTable1 {
    protected HashTableMap<String, Student> map = null;
    protected File fileName = null;

    @BeforeEach
    public void initial() {
        map = new HashTableMap(2);
    }

    @Test
    public void test1HashTableCreation() {
        fileName = new File("test1.txt");
        map = new HashTableMap(20);
        DataLoader loader = new DataLoader(fileName, map);
        int numOfPaired = loader.getMap().size();
        if(numOfPaired != 13) {
           fail("HashTable creation false! Add 13 students. The number of key-value does not match."
                   + "Table capacity: " + loader.getMap().getCapacity() + "; Number of pairs: " + numOfPaired);
        }
        System.out.println("1. HashTable creation successful!");
    }

    @Test
    public void test2HashTableResizing() {
        fileName = new File("test1.txt");
        DataLoader loader = new DataLoader(fileName, map);
        int capacity = loader.getMap().getCapacity();
        if(capacity != 32) {
            fail("HashTable resizing false! Add 13 students in size 2 Table. The table capacity does not match."
                    + "Table capacity: " + loader.getMap().getCapacity() + "; Number of pairs: " + capacity);
        }
        System.out.println("2. HashTable resizing successful!");
    }

    @Test
    public void test3HashTableCollisionHanding() {
        // collossison same index, whether we can differnece the keys/// collsion handling
        map = new HashTableMap<String, Student>(5);
        Student a = new Student(1, "Engineering", 2021);
        Student b = new Student(2, "Engineering", 2022);
        Student nick39 = new Student(4810758423L, "Engineering", 2021);
        map.put("a", a);
        map.put("b", b);
        map.put("nick39", nick39); // a and nick39 will have collision
        if(map.containsKey("a")) {
            if (map.get("a").getID() != 1) {
                fail("3. HashTable handling false! The collision key's ID doesn't match!");
            }
        }else {
            fail("3. HashTable handling false! The collision key doesn't exit!");
        }
        if(map.containsKey("nick39")) {
            if (map.get("nick39").getID() != 4810758423L) {
                fail("3. HashTable handling false! The collision key's ID doesn't match!");
            }
        }else {
            fail("3. HashTable handling false! The collision key doesn't exit!");
        }
        System.out.println("3. HashTable handling successful!");

        }

    @Test
    public void test4HashTablePut() {
        fileName = new File("test1.txt");
        map = new HashTableMap(20);
        DataLoader loader = new DataLoader(fileName, map);
        Student jermaine58 = new Student(7684920493L, "ComputerScience", 2021);
        loader.getMap().put("jermaine58", jermaine58);
        System.out.print("4 HashTable put method test: ");
        assertEquals(true, loader.getMap().containsKey("jermaine58"));
        System.out.println("Pass!");
    }

    @Test
    public void test5HashTableRemove() {
        fileName = new File("data1.txt");
        map = new HashTableMap(20);
        DataLoader loader = new DataLoader(fileName, map);
        loader.getMap().remove("elim27");
        System.out.print("5 HashTable remove method test: ");
        assertEquals(false, loader.getMap().containsKey("elim27"));
        System.out.println("Pass!");
        // containsKey
        System.out.println("5 HashTable containsKey method test: Pass!");
    }

    @Test
    public void test6HashTableGet() {
        fileName = new File("data1.txt");
        map = new HashTableMap(20);
        DataLoader loader = new DataLoader(fileName, map);
        System.out.print("6.1 HashTable get method test: ");
        assertEquals(4810758423L, loader.getMap().get("nick39").getID());
        System.out.println("Pass!");
        System.out.print("6.2 HashTable get method test: ");
        try {
            Student a = new Student(1, "Engineering", 2021);
            map.put("a", a);
            map.get(null);
            fail("HashTbale get method fail! Get a null key but return ValueType");
        } catch (NoSuchElementException e) {
        } catch (Exception e) {
            e.printStackTrace();
            fail("HashTbale get method fail! Unexpected exception occur");
        }
        System.out.println("Pass!");
    }

    @Test
    public void test7HashTableClear() {
        fileName = new File("data1.txt");
        map = new HashTableMap(20);
        DataLoader loader = new DataLoader(fileName, map);
        System.out.print("7 HashTable clear method test: ");
        loader.getMap().clear();
        assertEquals(0, loader.getMap().size());
        System.out.println("Pass!");
    }

}

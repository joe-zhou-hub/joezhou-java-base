package com.joezhou.prototype;

import org.junit.Test;

import java.io.*;
import java.util.Date;

/**
 * @author JoeZhou
 */
public class DeepCloneTest {
    private static class Sheep implements Serializable{
        String name;
        Date birth;

        Sheep deepClone(Sheep sheep) {
            Sheep result = null;
            ObjectOutputStream oos = null;
            ObjectInputStream ois = null;
            try {
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                oos = new ObjectOutputStream(baos);
                oos.writeObject(sheep);
                oos.flush();
                ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
                ois = new ObjectInputStream(bais);
                result = (Sheep) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (oos != null) { oos.close(); }
                    if (ois != null) { ois.close(); }
                } catch (IOException e) { e.printStackTrace(); }
            }
            return result;
        }
    }

    /**
     * 通过DEBUG断点观测两只羊的属性，以及birth属性值的更改是否会同时影响两只羊的birth值。
     */
    @Test
    public void deepClone() {
        Date birth = new Date();
        Sheep sheepA = new Sheep();
        sheepA.name = "dorset";
        sheepA.birth = birth;
        Sheep sheepB = sheepA.deepClone(sheepA);
        sheepB.name = "dolly";
        birth.setTime(999999999999L);
    }
}

package com.joezhou.io;

import org.junit.Test;

import java.io.*;

/**
 * @author JoeZhou
 */
public class ObjectSeriesTest {
    private String filePath = "D:" + File.separator + "java-io" + File.separator + "object.txt";

    private static class Student implements Serializable {
        private String name;
        private transient Integer age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }
    }

    /**
     * 将 `Student.java` 写入 `object.txt` 文件中
     */
	@Test
	public void objectOutputStream() {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
			Student student = new Student();
			student.setName("赵四");
			student.setAge(18);
			oos.writeObject(student);
			oos.flush();
			System.out.println("write over...");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

    /**
     * 将 `Student.java` 从 `object.txt` 文件中读取出来
     */
    @Test
    public void objectInputStream() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            Student student = (Student) ois.readObject();
            System.out.println("name：" + student.getName());
            System.out.println("age：" + student.getAge());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}


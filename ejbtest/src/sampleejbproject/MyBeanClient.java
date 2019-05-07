package sampleejbproject;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

public class MyBeanClient {
    public static void main(String[] args) {
        try {
            InitialContext ctx = new InitialContext();
//            MyBeanRemote bean = (MyBeanRemote) ctx.lookup(MyBeanRemote.class.getName());
            MyBeanRemote bean = (MyBeanRemote) ctx.lookup("MyBean");

            ArrayList<String[]> tempArr = new ArrayList<>();

            tempArr.add(new String[]{"Иванов1", "Да"});
            tempArr.add(new String[]{"Иванов2", "Нет"});
            tempArr.add(new String[]{"Иванов3", "Не знаю"});

            tempArr.add(new String[]{"Петров1", "Да"});
            tempArr.add(new String[]{"Петров2", "Нет"});
            tempArr.add(new String[]{"Петров3", "Не знаю"});

            tempArr.add(new String[]{"Сидоров1", "Да"});
            tempArr.add(new String[]{"Сидоров2", "Нет"});
            tempArr.add(new String[]{"Сидоров3", "Не знаю"});

            HashMap hm1 = bean.task(tempArr);

            System.out.println("\nVector с Да");
            Vector yesVector = clientTask(hm1, "Да");
            yesVector.stream().forEach(System.out::println);

            System.out.println("\nVector с Нет");
            Vector noVector = clientTask(hm1, "Нет");
            noVector.stream().forEach(System.out::println);

            System.out.println("\nVector с Не знаю");
            Vector dkVector = clientTask(hm1, "Не знаю");
            dkVector.stream().forEach(System.out::println);

        } catch(NamingException e) {
            e.printStackTrace();
        }
    }

    private static Vector<String> clientTask(HashMap<String, String> hm, String answer) {
        Vector<String> vector = new Vector<>();

        hm.forEach((k, v) -> {
            if (v.equals(answer)) vector.add(k);
        });

        return vector;
    }
}

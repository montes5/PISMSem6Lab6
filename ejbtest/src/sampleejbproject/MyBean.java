package sampleejbproject;

import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.HashMap;

@Stateless(mappedName = "MyBean")
public class MyBean implements MyBeanLocal, MyBeanRemote {
    @Override
    public HashMap task(ArrayList<String[]> strArr) {
        HashMap hm = new HashMap();
        strArr.stream().forEach(v -> hm.put(v[0], v[1]));
        return hm;
    }
}

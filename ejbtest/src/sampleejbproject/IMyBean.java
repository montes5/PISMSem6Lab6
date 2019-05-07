package sampleejbproject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public interface IMyBean extends Serializable {
    public HashMap task(ArrayList<String[]> strArr);
}

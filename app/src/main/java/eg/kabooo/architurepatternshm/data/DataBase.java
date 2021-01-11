package eg.kabooo.architurepatternshm.data;

import eg.kabooo.architurepatternshm.pojo.NumberModel;

public class DataBase {
    public NumberModel getNumbers(){
        return new NumberModel(4, 2);
    }
}

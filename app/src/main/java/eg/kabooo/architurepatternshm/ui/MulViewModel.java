package eg.kabooo.architurepatternshm.ui;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import eg.kabooo.architurepatternshm.data.DataBase;

public class MulViewModel extends ViewModel {

    MutableLiveData<String> mLiveData = new MutableLiveData<>();

    public void getMultiplication() {
        DataBase dataBase = new DataBase();

        int firstNum = dataBase.getNumbers().getFirstNum();//4
        int secondNum = dataBase.getNumbers().getSecondNum();//2

        mLiveData.setValue(String.valueOf(firstNum * secondNum));//8

    }


}

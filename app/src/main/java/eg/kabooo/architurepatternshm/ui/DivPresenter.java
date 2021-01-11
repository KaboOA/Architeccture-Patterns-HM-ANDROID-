package eg.kabooo.architurepatternshm.ui;

import eg.kabooo.architurepatternshm.data.DataBase;

public class DivPresenter {

    DivView divView;

    public DivPresenter(DivView divView) {
        this.divView = divView;
    }

    public void getDivision() {
        DataBase dataBase = new DataBase();
        int firstNum = dataBase.getNumbers().getFirstNum();
        int secondNum = dataBase.getNumbers().getSecondNum();

        divView.onGetDivision(String.valueOf(firstNum / secondNum));
    }
}

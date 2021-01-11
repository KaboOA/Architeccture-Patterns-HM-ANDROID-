package eg.kabooo.architurepatternshm.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;

import eg.kabooo.architurepatternshm.R;
import eg.kabooo.architurepatternshm.data.DataBase;
import eg.kabooo.architurepatternshm.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements DivView, View.OnClickListener, Observer<String> {

    ActivityMainBinding binding;
    DivPresenter divPresenter;
    MulViewModel mulViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        divPresenter = new DivPresenter(this);
        mulViewModel = ViewModelProviders.of(this).get(MulViewModel.class);

        mulViewModel.mLiveData.observe(this, this);
        
        // set MulBtn show Multiplication Result (MVVM)
        binding.mulButton.setOnClickListener(this);
        // set plusBtn show plus Result (MVC)
        binding.plusButton.setOnClickListener(this);
        // set DivBtn show Division Result (MVP)
        binding.divButton.setOnClickListener(this);

    }

    private void getPlus() {
        DataBase data = new DataBase();

        int firstNum = data.getNumbers().getFirstNum();
        int secondNum = data.getNumbers().getSecondNum();

        binding.plusResultTextView.setText(String.valueOf(firstNum + secondNum));
    }

    @Override
    public void onGetDivision(String division) {
        binding.divResultTextView.setText(division);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.plus_button:
                getPlus();
                break;
            case R.id.div_button:
                divPresenter.getDivision();
                break;
            case R.id.mul_button:
                mulViewModel.getMultiplication();
                break;
        }
    }

    @Override
    public void onChanged(String s) {
        binding.mulResultTextView.setText(s);
    }

}

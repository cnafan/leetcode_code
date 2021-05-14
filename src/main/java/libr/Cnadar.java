package libr;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Cnadar {
    public List<List<String>> getR(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year-1);
        calendar.set(Calendar.MONTH, month-1);
        int i = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)-1;
        List<List<String>> res = new ArrayList<>();

        System.out.println(i);
        return res;
    }


    public static void main(String[] args) {
        new Cnadar().getR(2020, 2, 6);
    }
}

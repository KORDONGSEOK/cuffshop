package dev.cuffshop;

import dev.cuffshop.domain.member.DayCode;
import dev.cuffshop.domain.member.MonthCode;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

public class BirthDayTest {


    @Test
    public void monthCodes() {
        List<MonthCode> monthCodes = new LinkedList<>();
        for(int i=1; i<= 12; i++){
            String month = String.format("%02d", i);
            monthCodes.add(new MonthCode(month, month + "월"));
        }

        for (MonthCode monthCode : monthCodes) {
            System.out.println("code = " + monthCode.getCode() + "display = " + monthCode.getDisplayName());
        }
    }

    @Test
    public void dayCodes() {
        List<DayCode> dayCodes = new LinkedList<>();
        for(int i=1; i<=31; i++){
            String day = String.format("%02d",i);
            dayCodes.add(new DayCode(day, day + "일"));
        }

        for (DayCode dayCode : dayCodes) {
            System.out.println("dayCode:" + dayCode.getCode() +":"+ dayCode.getDisplayName() );
        }
    }


}

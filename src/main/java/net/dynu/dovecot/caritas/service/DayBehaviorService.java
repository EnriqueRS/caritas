package net.dynu.dovecot.caritas.service;

import net.dynu.dovecot.caritas.domain.Utils;
import net.dynu.dovecot.caritas.model.DayBehavior;
import net.dynu.dovecot.caritas.repository.DayBehaviorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

/**
 * Created by Enrique Ríos on 15/7/20.
 * caritas
 */

@Service
public class DayBehaviorService {
    @Autowired
    private DayBehaviorRepository dayBehaviorRepository;

    public List<DayBehavior> getLastXDaysFromDay (Integer id, int days){
        return dayBehaviorRepository.getLastXDays(id, days);
    }

    public List<DayBehavior> getLastXDays (int days) {
        return getLastXDaysFromDay(Utils.getCurrentDateIdFormat(), days);
    }

    public void saveDayBehavior(int dayId, Integer behavior) throws ParseException {
        DayBehavior behaviorDay = new DayBehavior(dayId, behavior, Utils.getDateFromDateIdFormat(dayId));
        dayBehaviorRepository.save(behaviorDay);
    }

    public Optional<DayBehavior> getDay (int id) {
        return dayBehaviorRepository.findById(id);
    }
}

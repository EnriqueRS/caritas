package net.dynu.dovecot.caritas.service;

import net.dynu.dovecot.caritas.domain.Utils;
import net.dynu.dovecot.caritas.model.DayBehavior;
import net.dynu.dovecot.caritas.repository.DayBehaviorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by Enrique Ríos on 15/7/20.
 * caritas
 */

@Service
public class DayBehaviorService {
    @Autowired
    private DayBehaviorRepository dayBehaviorRepository;

    public Optional<DayBehavior> getLastXDaysFromDay (Integer id, int days){
        return dayBehaviorRepository.getLastXDays(id, days);
    }

    public Optional<DayBehavior> getLastXDays (int days) {
        return getLastXDaysFromDay(Utils.getCurrentDateIdFormat(), days);
    }
}

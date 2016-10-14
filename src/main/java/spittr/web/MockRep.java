package spittr.web;

import org.springframework.stereotype.Component;
import spittr.Spitter;

/**
 * Created by root on 13.10.16.
 */

@Component
public class MockRep implements SpitterRepository {
    @Override
    public Spitter save(Spitter unsaved) {
        return null;
    }

    @Override
    public Spitter findByUsername(String userName) {
        return null;
    }
}

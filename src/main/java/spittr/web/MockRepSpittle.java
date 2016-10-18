package spittr.web;

import org.springframework.stereotype.Component;
import spittr.Spitter;
import spittr.Spittle;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by root on 13.10.16.
 */

@Component
public class MockRepSpittle implements SpittleRepository {

    List<Spittle> list = new LinkedList<>();

    @Override
    public List<Spittle> findSpittles(long l, int i) {
        if(list.isEmpty()){
            list.add(new Spittle("Hello wolrd!", new Date()));
        }
        return list;
    }

    @Override
    public Spittle findOne(long id) {
        return null;
    }
}

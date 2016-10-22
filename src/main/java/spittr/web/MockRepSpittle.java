package spittr.web;

import org.springframework.stereotype.Component;
import spittr.Spittle;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by root on 13.10.16.
 */

@Component
public class MockRepSpittle implements SpittleRepository {

    List<Spittle> spittleList = new LinkedList<>();

    @Override
    public List<Spittle> findSpittles(long l, int i) {
        if(spittleList.isEmpty()){
            spittleList.add(new Spittle("Hello wolrd!", new Date()));
        }
        return spittleList;
    }

    @Override
    public Spittle findOne(long id) {

        for (Spittle s :
                spittleList) {
            if(s.getId() == id)
                return s;
        }
        return new Spittle("hello world!", new Date());
    }
}

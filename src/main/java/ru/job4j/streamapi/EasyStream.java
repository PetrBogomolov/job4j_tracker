package ru.job4j.streamapi;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class EasyStream {
   private List<Integer> save;

   public EasyStream of(List<Integer> source) {
        EasyStream easyStream = new EasyStream();
        easyStream.save = source;
        return easyStream;
   }

   public EasyStream map(Function<Integer, Integer> fun) {
        for (Integer element : save) {
            save.set(save.indexOf(element), fun.apply(element));
        }
        Collections.sort(save);
        return this;
   }

   public EasyStream filter(Predicate<Integer> fun) {
        save.removeIf(i -> !fun.test(i));
        return this;
   }

   public List<Integer> collect() {
        return save;
   }
}

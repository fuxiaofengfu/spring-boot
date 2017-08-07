package com.designmodel.javaobserve;

import java.util.Observable;

/**
 * 被观察者
 */
public class JavaObservable extends Observable {

   public void action(Object arg){
       super.setChanged();
       super.notifyObservers(arg);
   }

}

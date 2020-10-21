package ru.sbrf.cu.list;

public class MyLinkedList<T extends Comparable<T>> implements MyList<T>, MyQueue<T> {
    private ListItem<T> head = null;
    private ListItem<T> tail = null;
    private int size = 0;

    @Override
    public void add( T item ) {
        // Создаем новый элемент
        ListItem<T> internalItem = new ListItem<>();
        internalItem.value = item;
        //Если голова ещё не задана - то её присваиваем новому элементу
        if ( head == null ) {
            head = internalItem;
        }
        // Хвост заменяется на новый
        ListItem<T> tempTail = tail;
        tail = internalItem;
        // Связываем старый хвост и новый хвост между собой
        if ( tempTail != null ) {
            tempTail.next = tail;
        }
        tail.prev = tempTail;
        // Двигаемся по счетчику
        size++;
    }

    @Override
    public int size() {
        return size;
    }

   @Override
   public T get( int index ) {
       // TODO Ошибка если индекс больше размера
       if (index > (size-1) || index < 0){
           return null;
       }
       // TODO Если индекс > size/2 - то перебираем от tail
       int currPosition = 0;
       T result = null;
       ListItem<T> item = head;

       //Проверяем положение элемента относительно хвоста
       if (index > (size/2)){
           //Элемент ближе к хвосту, переопределяем переменные
           currPosition = size-1;
           item = tail;
           // Пошли перебирать элементы с хвоста
           while ( result == null && currPosition < size ) {
               if ( index == currPosition ) {
                   result = item.value;
               }
               item = item.prev;
               currPosition--;
           }
       }
       else{
           //Элемент ближе к голове
           // Пошли перебирать элементы пока не дойдем до индекса или же не выйдем за размеры списка
           while ( result == null && currPosition < size ) {
               if ( index == currPosition ) {
                   result = item.value;
               }
               item = item.next;
               currPosition++;
           }
       }
       return result;
   }

    @Override
    public boolean remove( T item ) {
        // TODO - реализовать.
        int currPosition = 0;
        boolean result = false;
        ListItem<T> key = head;
        while(result == false && currPosition < size){
            if (key.value == item){
                ListItem<T> prev = key.prev;
                ListItem<T> next = key.next;
                prev.next = next;
                next.prev = prev;
                size--;
                result = true;
            }
            key = key.next;
            currPosition++;
        }
        return result;
    }

    @Override
    public T poll() {
        //TODO реализовать
        T val = null;
        if (size > 0){
            ListItem<T> first = head;
            ListItem<T> next = head.next;
            val = first.value;
            if (size == 1){
                head = null;
            }
            else {
                head = next;
            }
            size--;
        }
        return val;
    }

    @Override
    public void sort() {
        boolean wasChange = true;
        while ( wasChange ){
            wasChange = false;
            ListItem<T> first = head;
            ListItem<T> second = head.next;
            while ( second != null ){
                wasChange = compareAndReplaceItem(first, second) || wasChange;
                first = second;
                second = second.next;
            }
        }
    }

    private boolean compareAndReplaceItem(ListItem<T> first, ListItem<T> second ) {
        T fstval = first.value;
        T sndval = second.value;
        if (second.value.compareTo( first.value ) < 0){
            second.prev = first.prev;
            if (second.prev == null){
                head = second;
            }
            first.next = second.next;
            if (first.next == null){
                tail = first;
            }
            second.next = first;
            first.prev = second;
            return true;
        }
        return false;
    }

    private class ListItem<T> {
        T value;
        ListItem<T> prev;
        ListItem<T> next;
    }
}

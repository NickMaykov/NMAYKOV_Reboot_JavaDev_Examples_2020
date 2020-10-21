package ru.sbrf.cu.list;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Реализация MyList должна")
class MyListTest {
    MyList<Integer> list;
    MyQueue<Integer> queue;

    @BeforeEach
    public void beforeAll() {
        list = new MyLinkedList<>();
        list.add( 1 );
        list.add( 2 );
        list.add( 10 );

        queue = new MyLinkedList<>();
        queue.add( 9 );
        queue.add( 2 );
        queue.add( 5 );
        queue.add( 3 );
    }

    @DisplayName("добавлять элементы и корректно давать размер")
    @Test
    public void testAdd() {
        assertEquals( 3, list.size() );
    }

    @DisplayName("находить элемент по индексу")
    @Test
    public void testGet() {
        list.add( 6 );
        list.add( 4 );
        assertEquals( Integer.valueOf( 6 ), list.get( 3 ) );
    }

    @DisplayName("возвращать null если выходим за размер")
    @Test
    public void testGetWithNull() {
        assertNull( list.get( 3 ) );
    }

    @DisplayName("находить удалять по элемент по совпадению")
    @Test
    public void testRemoveFirst() {
        list.add( 2 );
        boolean result = list.remove( 2 );
        assertTrue( result );
        assertEquals( Integer.valueOf( 2 ), list.get( 2 ) );
        assertEquals( 3, list.size() );
    }

    @DisplayName("возвращать false если удаление по элементу не удалось")
    @Test
    public void testRemoveFalse() {
        boolean result = list.remove( 3 );
        assertFalse( result );
        assertEquals( 3, list.size() );
    }

    @DisplayName("проверить работу poll()")
    @Test
    public void testPoll(){
        assertEquals(9, queue.poll());
        assertEquals(2, queue.poll());
        assertEquals(5, queue.poll());
        assertEquals( Integer.valueOf( 3 ), queue.get( 0 ) );
        assertEquals(3, queue.poll());
        assertNull(queue.poll());
    }

    @DisplayName("кооректно сортировать Integer")
    @Test
    public void testSort() {
        list.add( 6 );
        list.add( 4 );
        // 1,2,10,6,4
        list.sort();

        assertEquals( 5, list.size() );
        assertEquals( Integer.valueOf( 1 ), list.get( 0 ) );
        assertEquals( Integer.valueOf( 2 ), list.get( 1 ) );
        assertEquals( Integer.valueOf( 4 ), list.get( 2 ) );
        assertEquals( Integer.valueOf( 6 ), list.get( 3 ) );
        assertEquals( Integer.valueOf( 10 ), list.get( 4 ) );
    }
}
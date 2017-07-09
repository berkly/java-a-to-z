package ru.kovladimir.list;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ArrayContainerTest {

    @Test
    public void whenAddElementThenContainerHasIt() {
        ArrayContainer<Integer> container = new ArrayContainer<>();

        container.add(1);
        boolean result = container.contains(1);

        assertThat(result, is(true));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddInPositionBiggerThanSizeThenThrowException() {
        ArrayContainer<Integer> container = new ArrayContainer<>();

        container.add(6, 5);
    }

    @Test
    public void whenAddInValidPositionThanContainsIt() {
        ArrayContainer<Integer> container = new ArrayContainer<>();
        container.add(1);

        container.add(0, 2);
        int result = container.get(0);

        assertThat(result, is(2));
    }

    @Test
    public void whenAddInValidPositionThanShiftOldValueToNextPosition() {
        ArrayContainer<Integer> container = new ArrayContainer<>();
        container.add(1);

        container.add(0, 2);
        int result = container.get(1);

        assertThat(result, is(1));
    }

    @Test
    public void whenGetIndexOfAddedElementThenReturnIt() {
        ArrayContainer<Integer> container = new ArrayContainer<>();
        container.add(1);

        int result = container.indexOf(1);

        assertThat(result, is(0));
    }

    @Test
    public void whenSetNewElementThenContainsItInThisPosition() {
        ArrayContainer<Integer> container = new ArrayContainer<>();
        container.add(1);

        container.set(0, 2);
        int result = container.get(0);

        assertThat(result, is(2));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenClearContainerThenItHasNoElements() {
        ArrayContainer<Integer> container = new ArrayContainer<>();
        container.add(1);

        container.clear();
        int result = container.get(0);
    }

    @Test
    public void whenRemoveByIndexThenContainerDoesnotHaveIt() {
        ArrayContainer<Integer> container = new ArrayContainer<>();
        container.add(1);

        container.remove(0);
        boolean result = container.contains(1);

        assertThat(result, is(false));
    }

    @Test
    public void whenRemoveElementThenNextElementIsInHisPosition() {
        ArrayContainer<Integer> container = new ArrayContainer<>();
        container.add(1);
        container.add(2);

        container.remove(0);
        int position = container.indexOf(2);

        assertThat(position, is(0));
    }

    @Test
    public void whenRemoveByIndexInMiddleThenContainerDoesNotHaveIt() {
        ArrayContainer<Integer> container = new ArrayContainer<>();
        container.add(1);
        container.add(2);
        container.add(3);
        container.add(4);

        container.remove(2);
        boolean result = container.contains(3);

        assertThat(result, is(false));
    }

    @Test
    public void whenRemoveByIndexInMiddleThenNextElementIsInHisPosition() {
        ArrayContainer<Integer> container = new ArrayContainer<>();
        container.add(1);
        container.add(2);
        container.add(3);
        container.add(4);

        container.remove(2);
        int position = container.indexOf(4);

        assertThat(position, is(2));
    }

    @Test
    public void whenRemoveByObjectThenContainerDoesnotHaveIt() {
        ArrayContainer<Integer> container = new ArrayContainer<>();
        container.add(1);

        container.remove(new Integer(1));
        boolean result = container.contains(1);

        assertThat(result, is(false));
    }

    @Test
    public void whenContainerHasOneElementThenReturnOne() {
        ArrayContainer<Integer> container = new ArrayContainer<>();
        container.add(1);

        int size = container.size();

        assertThat(size, is(1));
    }

    @Test
    public void whenContainerHasTwoElementsThenReturnTwo() {
        ArrayContainer<Integer> container = new ArrayContainer<>();
        container.add(1);
        container.add(1);

        int size = container.size();

        assertThat(size, is(2));
    }

    @Test
    public void whenRemoveElementThenSizeMustDecrement() {
        ArrayContainer<Integer> container = new ArrayContainer<>();
        container.add(1);
        container.add(1);

        container.remove(1);
        int size = container.size();

        assertThat(size, is(1));
    }
}